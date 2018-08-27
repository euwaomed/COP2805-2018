/**
 * 
 */
package week04;

/**
 * This class encapsulates the results of a word count search.
 * 
 * @author eomed
 *
 */
public class WordCountResult
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            WordCountResult(int count, String word)
	 * @param count
	 *            Parameter
	 * @param word
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Constructor that initializes an instance Used when a new word
	 *            has been found that needs to be added to the occurrence list
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "count", "word"
	 */
	public WordCountResult(int count, String word)
	{
		// TODO Auto-generated constructor stub
		this.m_count = count;
		this.m_word = word;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getCount()
	 * @param override
	 *            None
	 * @param comment
	 *            Returns the number of occurrences of the word
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public int getCount()
	{
		// TODO Auto-generated method stub
		return m_count;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getWord()
	 * @param override
	 *            None
	 * @param comment
	 *            Returns the word being analyzed
	 * @param visiblity
	 *            public
	 * @return the return type minus the qualified name
	 */
	public String getWord()
	{
		// TODO Auto-generated method stub
		return m_word;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            incrementCount()
	 * @param override
	 *            None
	 * @param comment
	 *            Increments the occurrence count. Used when the word has been
	 *            added already and a new occurrence has been found
	 * @param visiblity
	 *            public
	 */
	public void incrementCount()
	{
		m_count++;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            setCount(int count)
	 * @param count
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Used to set the occurrence count. Replaces any existing value.
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "count"
	 */
	public void setCount(int count)
	{
		// TODO Auto-generated method stub
		m_count = count;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            setWord(String word)
	 * @param word
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Used to set the word. Replaces the existing word
	 * @param visiblity
	 *            public
	 * @param parameters
	 *            "word"
	 */
	public void setWord(String word)
	{
		// TODO Auto-generated method stub
		m_word = word;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            toString()
	 * @param override
	 *            Yes
	 * @param comment
	 *            Custom to string that generates the following text: count
	 *            <tab> word For example: 5 the || Format syntax: "%d\t%s"
	 * @param visiblity
	 *            public
	 * 
	 *            Override the toString
	 * 
	 * @return formatted string
	 */
	@Override
	public String toString()
	{
		return String.format("%d\t%s", this.getCount(), this.getWord());
	}

	private int m_count;
	private String m_word;

}
