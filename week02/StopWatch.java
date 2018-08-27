package week02;

/**
 * @author Scott
 * @version 1.0
 * @created 13-Mar-2016 9:12:01 PM
 */
public class StopWatch
{
	private long m_startTime;

	private long m_stopTime;

	public void finalize() throws Throwable
	{

	}

	/**
	 * Default constructor
	 */
	public StopWatch()
	{

		m_startTime = 0;
		m_stopTime = 0;
	}

	/**
	 * Returns the elapsed time for the stopwatch in milliseconds
	 */
	public long getElapsedTimeMilliSeconds()
	{
		return m_stopTime - m_startTime;
	}

	public long getStartTime()
	{
		return m_startTime;
	}

	public long getStopTime()
	{
		return m_stopTime;
	}

	/**
	 * Resets the start time to the current time
	 */
	public void start()
	{
		m_startTime = System.currentTimeMillis();
	}

	/**
	 * Sets the end time to the current time
	 */
	public void stop()
	{
		m_stopTime = System.currentTimeMillis();
	}

}// end StopWatch