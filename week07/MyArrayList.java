package week07;

/**
 * Description: This assignment focuses collections. Collections are data
 * structures that contain data. With Java and Generics, we can create
 * collections that will work on any data type. This is huge. It means that we
 * can use the collection anywhere and get compile-time type checking. This
 * dramatically reduces coding errors due to typecasting issues.
 * 
 * This assignment leverages the MyList, MyAbstractList and MyArrayList examples
 * from the text (Chapter 24). There are some subtle differences in the required
 * implementation, so simply copying the listings will not pass the provided
 * unit test. Refer to the UML definitions below.
 * 
 * @author eomed
 *
 */
public class MyArrayList<E> extends MyAbstractList<E>
{
	private E[] data = (E[])new Object[INITIAL_CAPACITY];

	public static final int INITIAL_CAPACITY = 16;

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            add(int index, E e)
	 * @param index
	 *            Parameter
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Add a new element at the specified index
	 * @param visiblity
	 *            public
	 */
	@Override
	public void add(int index, E e)
	{
		ensureCapacity();

		// Move the elements to the right after the specified index
		for(int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];

		// Insert new element to data[index]
		data[index] = e;

		// Increase size by 1
		size++;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            checkIndex(int index)
	 * @param index
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Checks index
	 * @param visiblity
	 *            private
	 */
	private void checkIndex(int index)
	{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException(
					"index " + index + " out of bounds");
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            clear()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Clear the list
	 * @param visiblity
	 *            public
	 */
	@Override
	public void clear()
	{
		data = (E[])new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            contains(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return true if this list contains the element
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public boolean contains(E e)
	{
		for(int i = 0; i < size; i++)
			if(e.equals(data[i]))
				return true;

		return false;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            ensureCapacity()
	 * @param override
	 *            None
	 * @param comment
	 *            Create a new larger array, double the current size + 1
	 * @param visiblity
	 *            private
	 */
	private void ensureCapacity()
	{
		if(size >= data.length)
		{
			E[] newData = (E[])(new Object[size * 2 + 1]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            get(int index)
	 * @param index
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return the element at the specified index
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public E get(int index)
	{
		checkIndex(index);
		return data[index];
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            indexOf(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return the index of the first matching element in this list.
	 *            Return -1 if no match.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public int indexOf(E e)
	{
		for(int i = 0; i < size; i++)
			if(e.equals(data[i]))
				return i;

		return -1;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            iterator()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Override iterator() defined in Iterable
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public java.util.Iterator<E> iterator()
	{
		return new ArrayListIterator();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            lastIndexOf(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return the index of the last matching element in this list.
	 *            Return -1 if no match.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public int lastIndexOf(E e)
	{
		for(int i = size - 1; i >= 0; i--)
			if(e.equals(data[i]))
				return i;

		return -1;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyArrayList()
	 * @param override
	 *            None
	 * @param comment
	 *            Create a default list
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public MyArrayList()
	{
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyArrayList(E[] objects)
	 * @param objects
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Create a list from an array of objects
	 * @param visiblity
	 *            public
	 */
	public MyArrayList(E[] objects)
	{
		for(int i = 0; i < objects.length; i++)
			add(objects[i]); // Warning: don’t use super(objects)!
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            remove(int index)
	 * @param index
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Remove the element at the specified position in this list.
	 *            Shift any subsequent elements to the left. Return the element
	 *            that was removed from the list.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public E remove(int index)
	{
		checkIndex(index);

		E e = data[index];

		// Shift data to the left
		for(int j = index; j < size - 1; j++)
			data[j] = data[j + 1];

		data[size - 1] = null; // This element is now null

		// Decrement size
		size--;

		return e;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            set(int index, E e)
	 * @param index
	 *            Parameter
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Replace the element at the specified position in this list
	 *            with the specified element.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public E set(int index, E e)
	{
		checkIndex(index);
		E old = data[index];
		data[index] = e;
		return old;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            toString()
	 * @param override
	 *            Yes
	 * @param comment
	 *            The toString() method overrides the toString method in the
	 *            Object class to return a string representing all the elements
	 *            in the list.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");

		for(int i = 0; i < size; i++)
		{
			result.append(data[i]);
			if(i < size - 1)
				result.append(", ");
		}

		return result.toString() + "]";
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            trimToSize()
	 * @param override
	 *            None
	 * @param comment
	 *            Trims the capacity to current size
	 * @param visiblity
	 *            public
	 */
	public void trimToSize()
	{
		if(size != data.length)
		{
			E[] newData = (E[])(new Object[size]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		} // If size == capacity, no need to trim
	}

	private class ArrayListIterator implements java.util.Iterator<E>
	{
		/**
		 * Parameterized constructor
		 * 
		 * @param name
		 *            current
		 * @param override
		 *            None
		 * @param comment
		 *            Part of The ArrayListIterator class
		 * @param visiblity
		 *            private
		 */
		private int current = 0; // Current index

		/**
		 * Parameterized constructor
		 * 
		 * @param name
		 *            hasNext()
		 * @param override
		 *            Yes
		 * @param comment
		 *            Part of The ArrayListIterator class
		 * @param visiblity
		 *            public
		 * 
		 * @return the return type minus the qualified name
		 */
		@Override
		public boolean hasNext()
		{
			return (current < size);
		}

		/**
		 * Parameterized constructor
		 * 
		 * @param name
		 *            next()
		 * @param override
		 *            Yes
		 * @param comment
		 *            Part of The ArrayListIterator class
		 * @param visiblity
		 *            public
		 * 
		 * @return the return type minus the qualified name
		 */
		@Override
		public E next()
		{
			return data[current++];
		}

		/**
		 * Parameterized constructor
		 * 
		 * @param name
		 *            remove()
		 * @param override
		 *            Yes
		 * @param comment
		 *            Part of The ArrayListIterator class
		 * @param visiblity
		 *            public
		 */
		@Override
		public void remove()
		{
			MyArrayList.this.remove(current);
		}
	}
}