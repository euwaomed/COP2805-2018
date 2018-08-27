/**
 * 
 */
package week05;

/**
 * Assignment Task: This assignment focuses on performance of algorithms. You
 * will be implementing the Euclid algorithm from chapter 22 and Fibonacci
 * algorithm (listing 22.2) to be executed by the test harness.
 * 
 * Description of Code: Fibonacci implements the algorithm from section 22.5.
 * 
 * INTRODUCTION TO JAVA PROGRAMMING was used as a reference for code.
 * 
 * @author eomed
 */
public class Fibonacci
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            fib(long index)
	 * @param index
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Calculates the Fibonacci number at the specified index. This
	 *            is not a static method
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */

	public long fib(long index)
	{
		if(index == 0) // Base case
			return 0;
		else if(index == 1) // Base case
			return 1;
		else // Reduction and recursive calls
			return fib(index - 1) + fib(index - 2);
	}

}
