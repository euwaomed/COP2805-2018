/**
 * 
 */
package week06;

/**
 * Description: The merge sort algorithm can be described recursively as
 * follows: The algorithm divides the array into two halves and applies a merge
 * sort on each half recursively. After the two halves are sorted, merge them.
 * 
 * I used the book approach
 * 
 * @author eomed
 *
 */
public class MergeSort extends AbstractSort
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MergeSort(int[] list)
	 * @param list
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            The algorithm divides the array into two halves and applies a
	 *            merge sort on each half recursively. After the two halves are
	 *            sorted, merge them.
	 * @param visiblity
	 *            public
	 */
	public MergeSort(int[] list)
	{
		super("MergeSort", list);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            sort()
	 * @param override
	 *            Yes
	 * @param comment
	 *            This implements the method defined in AbstractSort. The
	 *            appropriate sort algorithm is implemented here
	 * @param visiblity
	 *            public (non-Javadoc)
	 * 
	 * @see week06.AbstractSort#sort()
	 */
	@Override
	public void sort()
	{
		sortArray(m_list);

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            sortArray(int[] list)
	 * @param list
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            The method for sorting the numbers
	 * @param visiblity
	 *            public
	 */
	public void sortArray(int[] list)
	{
		if(list.length > 1)
		{
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			sortArray(firstHalf);

			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0,
					secondHalfLength);
			sortArray(secondHalf);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            merge(int[] list1, int[] list2, int[] temp)
	 * @param list1
	 *            Parameter
	 * @param list2
	 *            Parameter
	 * @param temp
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Merge two sorted lists
	 * @param visiblity
	 *            public
	 */
	public void merge(int[] list1, int[] list2, int[] temp)
	{
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while(current1 < list1.length && current2 < list2.length)
		{
			if(list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while(current1 < list1.length)
			temp[current3++] = list1[current1++];

		while(current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

}
