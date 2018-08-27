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

public interface MyList<E> extends java.lang.Iterable<E>
{
	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            next()
	 * @param e
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Add a new element at the end of this list
	 * @param visiblity
	 *            public
	 */
	public void add(E e);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            add(int index, E e)
	 * @param e
	 *            Parameter
	 * @param index
	 *            Parameter
	 * @param override
	 *            Yes
	 * @param comment
	 *            Add a new element at the specified index in this list
	 * @param visiblity
	 *            public
	 */
	public void add(int index, E e);

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
	public void clear();

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            contains(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Return true if this list contains the element
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public boolean contains(E e);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            get(int index)
	 * @param index
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Return the element from this list at the specified index
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public E get(int index);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            indexOf(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Return the index of the first matching element in this list.
	 *            Return -1 if no match.
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public int indexOf(E e);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            isEmpty()
	 * @param override
	 *            None
	 * @param comment
	 *            Return true if this list contains no elements
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public boolean isEmpty();

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            lastIndexOf(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Return the index of the last matching element in this list
	 *            Return -1 if no match
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public int lastIndexOf(E e);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            remove(E e)
	 * @param e
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Remove the first occurrence of the element o from this list.
	 *            Shift any subsequent elements to the left. Return true if the
	 *            element is removed.
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public boolean remove(E e);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            remove(int index)
	 * @param index
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Remove the element at the specified position in this list
	 *            Shift any subsequent elements to the left. Return the element
	 *            that was removed from the list.
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public E remove(int index);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            set(int index, E e)
	 * @param e
	 *            Parameter
	 * @param index
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Replace the element at the specified position in this list
	 *            with the specified element and returns the new set.
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public E set(int index, E e);

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            size()
	 * @param override
	 *            None
	 * @param comment
	 *            Return the number of elements in this list
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public int size();

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            iterator()
	 * @param override
	 *            None
	 * @param comment
	 *            Return an iterator for the list
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public java.util.Iterator<E> iterator();
}