/**
 * 
 */
package week06;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element (considering ascending order) from unsorted part and putting it at
 * the beginning. The algorithm maintains two subarrays in a given array.
 * 
 * @author eomed
 *
 */
public class SelectionSort extends AbstractSort
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            SelectionSort(int[] list)
	 * @param list
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            The subclass takes only an array of integers. It initializes
	 *            the AbstractSort super class by providing a name of the
	 *            algorithm, so two parameters are provided to the super class
	 *            as required by the AbstractSort
	 * @param visiblity
	 *            public
	 * 
	 */
	public SelectionSort(int[] list)
	{
		super("SelectionSort", list);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            sort()
	 * 
	 * @param list
	 *            Parameter
	 * 
	 * @param override
	 *            Yes
	 * 
	 * @param comment
	 *            This implements the method defined in AbstractSort. The
	 *            appropriate sort algorithm is implemented here
	 * 
	 * @param visiblity
	 *            public
	 * 
	 *            (non-Javadoc)
	 * 
	 * @see week06.AbstractSort#sort()
	 */
	@Override
	public void sort()
	{

		for(int first = 0; first < m_list.length - 1; first++)
		{
			int second = first;
			for(int j = first + 1; j < m_list.length; j++)
				if(m_list[j] < m_list[second])
					second = j;
			swap(m_list, first, second);
		}

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            swap(int[] list, int first, int second)
	 * @param list
	 *            Parameter
	 * @param first
	 *            Parameter
	 * @param second
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Private helper method to swap the two numbers.
	 * @param visiblity
	 *            private
	 */
	private void swap(int[] list, int first, int second)
	{
		int temp = list[first];
		list[first] = list[second];
		list[second] = temp;
	}

}
