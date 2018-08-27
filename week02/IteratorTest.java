/**
 * 
 */
package week02;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Measure the time it takes to loop through the list using Iterator to access
 * the data and measure the time it takes to loop through the list using the
 * get(index) method (standard for loop)
 * Credit to Professor Scott. Information from the instructional video was used heavily. 
 * If there are errors, I will edit and change upon request.
 * 
 * @author Efosa Uwa-Omede
 *
 */
public class IteratorTest
{

	/**
	 * Parameterized constructor
	 * 
	 * @param listSize Name of the method
	 * 
	 */

	public IteratorTest(int listSize)
	{
		listsize = listSize;
		watch = new StopWatch();
		initialize();
	}

	public void execute()
	{
		Iterator<Integer> item = linkedList.listIterator();
		watch.start();

		while(item.hasNext())
		{
			Integer integer = item.next();
		}
		watch.stop();
		iteratorElapsedTime = watch.getElapsedTimeMilliSeconds();
		watch.start();
		for(int i = 0; i < linkedList.size(); i++)
		{
			Integer integer = linkedList.get(i);
		}
		watch.stop();
		getAtElapsedTime = watch.getElapsedTimeMilliSeconds();
	}

	/**
	 * Get the return type
	 * 
	 * @return the return type minus the qualified name
	 */
	public long getIteratorElapsedTimeInMilliseconds()
	{
		//Getter method that returns iterator elapsed time
		return iteratorElapsedTime;
	}

	/**
	 * Get the return type
	 * 
	 * @return the return type minus the qualified name
	 */
	public long getElapsedTimeInMilliseconds()
	{
		//Getter method that turns the get(index) elapsed time.
		return getAtElapsedTime;
	}

	/**
	 * Get the return type
	 * 
	 * @return the return type minus the qualified name
	 */
	public long getListSize()
	{
		// The size of the linked list after the integers have been added.
		return linkedList.size();
	}

	private void initialize()
	{
		linkedList = new LinkedList<Integer>();
		for(int data = 0; data < listsize; data++)
		{
			linkedList.add(data);
		}
	}

	private int listsize;
	private StopWatch watch;
	private LinkedList<Integer> linkedList;
	private long iteratorElapsedTime;
	private long getAtElapsedTime;

}
