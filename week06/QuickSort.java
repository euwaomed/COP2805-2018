package week06;

public class QuickSort extends AbstractSort
{
    /**
     * Constructor
     * This is a recursive algorithm
     * Recursion means that a method calls itself until the 
     * exit condition is met
     * 
     * @param list
     *            Array of ints to sort
     */
    public QuickSort(int[] list)
    {
        super("QuickSort", list);
    }

    /**
     * Calls the internal method quickSort (which is recursive)
     */
    @Override
    public void sort()
    {
        quickSort(m_list, 0, m_list.length - 1);

    }

    /**
     * Splits the list into an left and right list
     * 
     * @param array Array of ints to sort
     * @param left Left index
     * @param right Right index
     * @return index of the 
     */
    private int partition(int[] array, int left, int right)
    {
        int i = left;
        int j = right;
        int tmp;

        int pivot = array[(left + right) / 2]; // This is different than what we
                                             // worked with earlier

        while(i <= j)
        {
            while(array[i] < pivot) // not checking the indexes, only the values
            {
                i++;
            }

            while(array[j] > pivot) // not checking the indexes, only the values
            {
                j--;
            }

            if(i <= j)
            {
                // swap
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                // adjust the indexes
                i++;
                j--;
            }
        }

        return i;
    }

    /**
     * This is the recursive method.
     * @param array Array of ints to sort
     * @param left left index
     * @param right right index
     */
    void quickSort(int[] array, int left, int right)
    {
        int index = partition(array, left, right);

        if(left < index - 1)
        {
            quickSort(array, left, index - 1);
        }
        
        if(index < right) // this is different
        {
            quickSort(array, index, right);
        }
    }
}
