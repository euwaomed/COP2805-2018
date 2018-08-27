package week06;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaseSorting
{
	public TestCaseSorting()
	{
	}

	@Test
	public void runTest()
	{
		trace("runTest");
		boolean success = true;
        int runs = 5;

        for(int i = 0; i < runs; i++)
        {
        	success = test();
        }

        assertTrue("TestCaseSorting failed",success);
	}

    private boolean test()
    {
    	boolean result = true;

        int[] testList = getTestList();

        trace(" Processing " + testList.length + " items...");
        // Make copies of the test data so we can compare them afterward
        // Remember, the array list gets passed by reference
        int[] insertionList = Arrays.copyOf(testList, testList.length);
        int[] selectionList = Arrays.copyOf(testList, testList.length);
        int[] mergeList = Arrays.copyOf(testList, testList.length);
        int[] quickList = Arrays.copyOf(testList, testList.length);
        //int[] merge2List = Arrays.copyOf(testList, testList.length);
        //dumpArray(quickList);

        InsertionSort insertion = new InsertionSort(insertionList);
        SelectionSort selection = new SelectionSort(selectionList);
        MergeSort merge = new MergeSort(mergeList);
        QuickSort quick = new QuickSort(quickList);
        //MergeSort2 merge2 = new MergeSort2(merge2List);
        
        int[] insertionSortedList = runTest(insertion);
        int[] selectionSortedList = runTest(selection);
        int[] mergeSortedList = runTest(merge);
        int[] quickSortedList = runTest(quick);
        //int[] merge2SortedList = runTest(merge2);

        if(!verifySorts(insertionSortedList, selectionSortedList, mergeSortedList, quickSortedList))
        {
        	dumpArrays(insertionSortedList, selectionSortedList, mergeSortedList, quickSortedList);
        	fail("Sort routines did not match");
        }

        return result;
    }

    private void dumpArray(int[] array)
    {
    	String fmt = "%d %d %d %d %d %d %d %d %d %d";
		int size = array.length;
		int[] tmpArray = new int[10];
		for(int index = 0; index < size; index++)
		{
			int tmpIndex = index % 10; // 0-9 index range
			tmpArray[tmpIndex] = array[index];
			if(tmpIndex == 9)
			{
				String msg = String.format(fmt, tmpArray[0],tmpArray[1],tmpArray[2],tmpArray[3],
						tmpArray[4],tmpArray[5],tmpArray[6],tmpArray[7],tmpArray[8],tmpArray[9]);
				trace(msg);

				for(int j = 0; j < 10; j++)
				{
					tmpArray[j] = -1;
				}
			}

		}
    }
    private void dumpArrays(int[] a,
			int[] b, int[] c, int[] d)
	{
    	String fmt = "%d\t%d\t%d\t%d";
    	trace("Insertion\tSelection\tMerge\tQuick");
		int size = a.length;
		for(int index = 0; index < size; index++)
		{
			String msg = String.format(fmt, a[index],b[index],c[index],d[index]);
			trace(msg);
		}
	}

	private boolean verifySorts(int[] a, int[] b, int[] c, int[] d)
    {
        boolean result = true;

        // verify lengths are the same
        if(!(a.length == b.length && a.length == c.length && b.length == c.length && b.length == d.length))
        {
            result = false;
            String msg = String
                    .format("Lengths different; insertion = %d, selection = %d, merge = %d, quick = %d",
                            a.length, b.length, c.length, d.length);
            trace(msg);
        }
        else
        {
            for(int i = 0; i < a.length; i++)
            {
                boolean same = a[i] == b[i] && b[i] == c[i] && b[i] == d[i]; // using transitive
                if(!same)
                {
                    String msg = String
                            .format("Mismatched value at index %d; insertion = %d, selection = %d, merge = %d, quick = %d",
                                    i, a[i], b[i], c[i], d[i]);
                    trace(msg);
                    result = false;
                    break; // early out
                }
            }
        }

        return result;
    }

    private static int[] getTestList()
    {
        Random rand = new Random();
        //int size = 100000;
        int size = 100;//0;

        int[] list = new int[size];

        for(int i = 0; i < size; i++)
        {
            int val = rand.nextInt(size);
            list[i] = val;
        }

        return list;
        //return new int[]{4,4,3,2,1};
    }

    private int[] runTest(AbstractSort sorter)
    {
        trace("Testing sort routine " + sorter.getName());
        trace("---------------------------------");

        try
        {
	        long start = System.nanoTime();
	        sorter.sort();
	        long end = System.nanoTime();
	        long elapsed = end - start;
			long elapsedTimeMs = TimeUnit.NANOSECONDS.toMillis(elapsed);
	        trace(String.format("Processed in: %d ms\r\n", elapsedTimeMs));
	    }
        catch(Exception ex)
        {
        	trace("Error in " + sorter.getName());
        	trace(ex.getMessage());
        }

        trace("=================================");

        return sorter.getList();
    }

	private static void trace(String msg)
	{
		System.out.println(msg);
	}
}
