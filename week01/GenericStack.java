package week01;

/**
 * @author eomed
 * 
 *         Description: Implement the GenericStack as defined in listing 19.1.
 *         The file name must be GenericStack.java and the class name
 *         GenericStack.
 * 
 *         It must compile and execute against the test harness. You do this by
 *         running the jUnitGenericStackTest.java class in your Eclipse IDE or
 *         running the TestHarness.java.
 *
 */
public class GenericStack<T>
{

	private java.util.ArrayList<T> list = new java.util.ArrayList<T>();

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getSize()
	 * @param override
	 *            None
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public int getSize()
	{
		return list.size();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            peek()
	 * @param override
	 *            None
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public T peek()
	{
		return list.get(getSize() - 1);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            push(T o)
	 * @param o
	 *            Parameter
	 * @param override
	 *            None
	 * @param visiblity
	 *            public
	 */
	public void push(T o)
	{
		list.add(o);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            pop()
	 * @param override
	 *            None
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public T pop()
	{
		T o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            isEmpty()
	 * @param override
	 *            None
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            toString()
	 * @param override
	 *            Yes
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	@Override
	public String toString()
	{
		return "stack: " + list.toString();
	}
}