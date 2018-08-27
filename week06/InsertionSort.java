/**
 * 
 */
package week06;

/**
 * Description: The insertion-sort algorithm sorts a list of values by
 * repeatedly inserting a new element into a sorted sublist until the whole list
 * is sorted.
 * 
 * @author eomed
 *
 */
public class InsertionSort extends AbstractSort
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            InsertionSort(int[] list)
	 * @param list
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            The insertionSort(int[] list) method sorts any array of int
	 *            elements. The method is implemented with a nested for loop.
	 * @param visiblity
	 *            public
	 */
	public InsertionSort(int[] list)
	{
		super("InsertionSort", list);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            sort()
	 * @param list
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            This implements the method defined in AbstractSort. The
	 *            appropriate sort algorithm is implemented here
	 * @param visiblity
	 *            public (non-Javadoc)
	 * @see week06.AbstractSort#sort()
	 */
	@Override
	public void sort()
	{
		for(int i = 1; i < m_list.length; i++)
		{
			int index = m_list[i];
			int k;
			for(k = i - 1; k >= 0 && m_list[k] > index; k--)
			{
				m_list[k + 1] = m_list[k];
			}

			m_list[k + 1] = index;
		}
	}
}