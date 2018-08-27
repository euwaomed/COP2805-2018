/**
 * 
 */
package week01;

import java.util.ArrayList;

/**
 * @author eomed
 * 
 * 
 *         Description: Adapted from programming exercise 19.2
 * 
 *         Define a new stack class, GenericStack2 that extends ArrayList. Do
 *         not create a test program, this class is evaluated using the test
 *         harness.
 * 
 *         GenericStack2 WILL NOT have that declaration. GenericStack2 inherits
 *         from ArrayList.
 *
 */
public class GenericStack2<T> extends ArrayList<T>
{

	private static final long serialVersionUID = 1L;

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
		return super.isEmpty();
	}

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
		return super.size();
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
		return get(this.getSize() - 1);
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
		// T o = get(getSize() - 1);
		return remove(getSize() - 1);
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
		add(o);
		// return o;
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
	public String toString()
	{
		return "stack: " + super.toString();
	}
}