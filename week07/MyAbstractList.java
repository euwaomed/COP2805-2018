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

public abstract class MyAbstractList<E> implements MyList<E>
{
	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            size
	 * @param override
	 *            None
	 * @param comment
	 *            The size of the list
	 * @param visiblity
	 *            protected
	 */
	protected int size = 0; // The size of the list

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            add(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Add a new element at the end of this list
	 * @param visiblity
	 *            public
	 */
	@Override
	public void add(E e)
	{
		add(size, e);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            isEmpty()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return true if this list contains no elements
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyAbstractList()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Create a default list
	 * @param visiblity
	 *            protected
	 */
	protected MyAbstractList()
	{
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            MyAbstractList(E[] objects)
	 * @param objects
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Create a list from an array of objects
	 * @param visiblity
	 *            protected
	 */
	protected MyAbstractList(E[] objects)
	{
		for(int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            size()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Return the number of elements in this list
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	@Override
	public int size()
	{
		return size;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            remove(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Remove the first occurrence of the element e from this list.
	 *            Shift any subsequent elements to the left. Return true if the
	 *            element is removed.
	 * @param visiblity
	 *            public
	 */
	@Override
	public boolean remove(E e)
	{
		if(indexOf(e) >= 0)
		{
			remove(indexOf(e));
			return true;
		}
		else
			return false;
	}
}