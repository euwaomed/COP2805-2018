package week09;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import test.AbstractJUnitBase;
import week09.MyMap.Entry;

public class JUnitHashMapTest extends AbstractJUnitBase
{
    String[] testKeys = { "Smith", "Anderson", "Lewis", "Cook", "Smithers",
            "Jefferson", "Johnson", "Bigalow", "Williams", "Danielson" };

    @Test
    public void testCollisions()
    {
        trace("** Testing MyHashMapLinear - testCollisions");
        MyMap<String, Integer> map = new MyHashMapLinear<String, Integer>();
        for(int i = 0; i < testKeys.length; i++)
        {
            map.put(testKeys[i], i);
        }

        String fmt = String.format(" ** Map size: expected %d. actual: %d",
                testKeys.length, map.size());
        trace("  -- Map size: " + map.size());
        trace("  -- Map entries\n" + map.toString());
        assertTrue(fmt, map.size() == testKeys.length);
        trace("** Completed MyHashMapLinear - testCollisions");
    }

    @Test
    public void testSameKey()
    {
        trace("** Testing MyHashMapLinear - same key");
        MyMap<String, Integer> map = new MyHashMapLinear<String, Integer>();
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        // map.put("Smith", 65);

        trace("  -- Map size: " + map.size());
        trace("  -- Map entries\n" + map.toString());
        trace("  -- Get age for Lewis: " + map.get("Lewis"));
        trace("  -- Smith in map? " + map.containsKey("Smith"));
        assertTrue(" ** Map size: expected 4. actual: " + map.size(),
                map.size() == 4);
        boolean actual = map.containsKey("Cook");
        assertTrue(
                " ** Test on hash containing 'Cook' - Expected: true, actual: false",
                actual);
        trace("  -- Is age 33 in map? " + map.containsValue(33));

        map.remove("Smith");
        trace("  -- Remove: Map entries\n" + map.toString());

        map.clear();

        trace("  -- Clear: Map entries\n" + map.toString());
        trace("** Completed MyHashMapLinear - same key");
    }

    @Test
    public void testExamineFile()
    {
        trace("** Testing testExamineFile - checking file content");

        try
        {
            String filePath = initFilePath("MyHashMapLinear.java", "week09");
            trace(" -- file path: " + filePath);

            if(filePath == null)
            {
                fail("Failed testExamineFile - '" + filePath
                        + "' file not found");
            }
            else
            {
                File srcFile = new File(filePath);
                if(!srcFile.exists())
                {
                    trace("Failed testExamineFile - '" + filePath
                            + "' file not found");
                    fail("Failed testExamineFile - '" + filePath
                            + "' file not found");
                }
                else
                {
                    // evaluate file
                    FileEvaluationData evalData = new FileEvaluationData();
                    evaluateFile(srcFile, evalData);
                    if(!evalData.result)
                    {
                        trace(evalData.getDataAsString());
                        fail(evalData.getDataAsString());
                    }
                }
            }
        }
        catch(IOException ex)
        {
            fail("Failed testExamineFile - " + ex.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            fail("Unexpected error: Failed testExamineFile - " + ex.getMessage());
        }

        trace("** Completed testExamineFile - checking file content");
    }

    private void evaluateFile(File file, FileEvaluationData evalData)
            throws IOException
    {
        trace("evaluateFile()");
//      boolean result = true;

        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        String line = "";
        int lineNumber = 0;
        while((line = buffer.readLine()) != null)
        {
            lineNumber++;
            lineNumber = processLine(line.trim(), buffer, lineNumber, evalData);

//          if(result == false)
//          {
//              String msg = String.format(
//                      "Error processing text at line %d, '%s'", lineNumber,
//                      line);
//              trace(msg);
//              break;
//          }
        }

        buffer.close();

//      return result;
    }

    private int processLine(String line, BufferedReader reader, int lineNumber,
            FileEvaluationData evalData) throws IOException
    {
        if(line.contains("LinkedList<MyMap.Entry<K, V>>[] table"))
        {
            // processTestMatch
            // m_curEvalFermiState = EVAL_FERMI_STATES.TESTMATCH;
            lineNumber = processEvalState(line, EVAL_STATES.TABLE, reader,
                    lineNumber, evalData);
        }
        else if(line.contains("Set<MyMap.Entry<K, V>> entrySet()")) //
        {
            lineNumber = processEvalState(line, EVAL_STATES.SETENTRY, reader,
                    lineNumber, evalData);
        }
        else if(line.contains("boolean containsValue("))
        {
            lineNumber = processEvalState(line, EVAL_STATES.CONTAINSVALUE,
                    reader, lineNumber, evalData);
        }
        else if(line.contains("get("))
        {
            lineNumber = processEvalState(line, EVAL_STATES.GET, reader,
                    lineNumber, evalData);
        }
        else if(line.contains("Set<K> keySet()"))
        {
            lineNumber = processEvalState(line, EVAL_STATES.KEYSET, reader,
                    lineNumber, evalData);
        }
        else if(line.contains("V put("))
        {
            lineNumber = processEvalState(line, EVAL_STATES.PUT, reader,
                    lineNumber, evalData);
        }
        else if(line.contains("Set<V> values()"))
        {
            lineNumber = processEvalState(line, EVAL_STATES.TABLE, reader,
                    lineNumber, evalData);
        }

        return lineNumber;
    }

    /**
     * Processes an existing line and will deep dive into the code
     *
     * @param line
     *            current lie to process
     * @param state
     *            The state of the evaluation
     * @param reader
     *            BufferedReader to read from
     * @param lineNumber
     *            current line number being processed
     * @return updated line number being processed
     * @throws IOException
     *             On error.
     */
    private int processEvalState(String line, EVAL_STATES state,
            BufferedReader reader, int lineNumber, FileEvaluationData evalData)
            throws IOException
    {
        trace(" -- processEvalState() - " + state);
        // boolean result = true;
        int braceCount = 0;
        boolean fDone = false;

        // check and see if this line has an opening brace
        if(line.trim().endsWith("{"))
        {
            braceCount++;
        }
        while(!fDone)
        {
            line = reader.readLine();
            if(line == null)
            {
                String msg = " -- processEvalState: reached end of file unexpectedly";
                evalData.m_data.add(msg);
                trace(msg);
                break;
            }
            lineNumber++;

            // look for the opening brace, evaluate the content, and
            // closing brace
            if(line.trim().endsWith("{")) // brace starts on same line
            {
                braceCount++;
            }
            else if(line.trim().endsWith("}"))
            {
                braceCount--;
            }
            else
            {
                switch(state)
                {
                    case READY:
                        break;

                    case SETENTRY: // found the setEntry method signature

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table[i]"))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    case CONTAINSVALUE:

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table[i]"))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    case GET:

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table["))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    case KEYSET:

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table[i]"))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    case PUT:

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table["))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    case VALUE:

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table["))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    case TABLE:

                        if(line.trim().contains(
                                "LinkedList<Entry<K, V>> bucket = table["))
                        {
                            // found possible invalid code brace, process body
                            String msg = String.format(
                                    " -- invalid code found at %d - bucket implementation",
                                    lineNumber);
                            // trace(msg);
                            evalData.result = false;
                            evalData.m_data.add(msg);
                        }
                        break;

                    default:
                        trace(" -- nothing to process");
                        break;
                }
            }

            if(braceCount == 0)
            {
                fDone = true;
            }
        }

        return lineNumber;
    }

    private enum EVAL_STATES
    {
        READY, TESTMATCH, SETENTRY, CONTAINSVALUE, GET, KEYSET, PUT, VALUE, TABLE
    }

    // private static String INVALID_LIST = "LinkedList<MyMap.Entry<K, V>>[]
    // table";

    class FileEvaluationData
    {
        public FileEvaluationData()
        {
            m_data = new ArrayList<String>();
        }

        public String getDataAsString()
        {
            StringBuilder builder = new StringBuilder();
            for(String msg : m_data)
            {
                builder.append(msg);
                builder.append(CRLF);
            }

            return builder.toString();
        }

        boolean result;
        List<String> m_data;
    }
}
