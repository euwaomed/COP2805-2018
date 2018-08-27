/**
 * 
 */
package week04;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import week03.Employee;

/**
 * This class provides methods to count words in text and eventually other
 * counting functions.
 * 
 * Evaluates an individual line by splitting into the words. Checks to see if
 * each word has previously been mapped and if so, increment the occurrence
 * count, otherwise add and set count to 1.
 * 
 * @author eomed
 *
 */
public class CountUtility
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            List<WordCountResult> countWordOccurrences(BufferedReader
	 *            reader) throws Exception
	 * @param reader
	 *            Parameter
	 * @throws Exception
	 * @param override
	 *            None
	 * @param comment
	 *            Evaluates the provided reader to find individual words and the
	 *            number of occurrences of the word. If there are processing
	 *            errors the exception is thrown to the caller.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public List<WordCountResult> countWordOccurrences(BufferedReader reader)
			throws Exception
	{
		try
		{
			// word, occurrences
			Map<String, Integer> data = new TreeMap<>(); // TreeMap arranges
															// items by natural
															// order.
			Stream<String> streamData = reader.lines();
			String[] stringArray;
			stringArray = streamData.toArray(size -> new String[size]);
		}
		catch(Exception ex1)
		{
			System.out.println("Processing error.");
		}
		
		return evaluateLine(Map<String, WordCountResult> occurances);
		
	}

	private void evaluateLine(String line,
			Map<String, WordCountResult> occurances)
	{

		Map<String, Integer> map = new TreeMap<>();

		String[] words = line.split("[ \n\t\r.,;:!?(){");
		for(int i = 0; i < words.length; i++)
		{
			String key = words[i].toLowerCase();

			if(key.length() > 0)
			{
				if(!map.containsKey(key))
				{
					map.put(key, 1);
				}
				else
				{
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

		// Get key and value from each entry
		for(Map.Entry<String, Integer> entry : entrySet)
			System.out.println(entry.getValue() + "\t" + entry.getKey());
	}
}
