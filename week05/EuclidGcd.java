/**
 * 
 */
package week05;

/**
 * Assignment Task: This assignment focuses on performance of algorithms. You
 * will be implementing the Euclid algorithm from chapter 22 and Fibonacci
 * algorithm (listing 22.2) to be executed by the test harness.
 * 
 * Description of Code: Section 22.6 in the text provides the algorithm for the
 * Euclid algorithm. You need to adapt the algorithm to fit into the
 * getEuclidGcdBreak method. It takes the two values m and n and returns the GCD
 * value. It is not static, so don't let the book implementation lead you
 * astray.
 * 
 * INTRODUCTION TO JAVA PROGRAMMING was used as a reference for code.
 * 
 * @author eomed
 */
public class EuclidGcd
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            EuclidGcd()
	 * @param override
	 *            None
	 * @param comment
	 *            Constructor
	 * @param visiblity
	 *            public
	 * 
	 */
	public EuclidGcd()
	{
		// There are no class attributes to initialize

	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getEuclidGcdBreak(long m, long n)
	 * @param m
	 *            Parameter
	 * @param n
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Implements the GCD algorithm. this is a private method that
	 *            the start method calls in the reference implementation.
	 *            Consider it a hint.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	private long getEuclidGcdBreak(long m, long n)
	{
		if(m % n == 0)
			return n;
		else
			return start(n, m % n);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            start(long m, long n)
	 * @param m
	 *            Parameter
	 * @param n
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            The public method that is called by the TestHarness and other
	 *            users. This is the actual method used by the TestHarness
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public long start(long m, long n)
	{
		// Learned from
		// https://stackoverflow.com/questions/29639374/c-how-do-i-call-private-methods-through-public-ones
		return getEuclidGcdBreak(m, n);

	}

}
