
package week11;

/**
 * @author Efosa
 * 
 * Description: Implement this example from your textbook: section 30.8.6,
 * Case Study: Occurrences of Words". Modify it to accept an argument, 
 * which is the name of a file. Read the contents of the file as the input 
 * (instead of a hardcoded string). I wanted to create a word count without 
 * punctuation.
 * 
 * Resources used to assist me were:
 * https://www.youtube.com/watch?v=eRfhW2uRlbk
 * https://github.com/jsquared21/Intro-to-Java-Programming/blob/master/Exercise_21/Exercise_21_08/Exercise_21_08.java
 * Section 30.8.6, "Case Study: Occurrences of Words"
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter
{

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            main(String[] args) throws FileNotFoundException
	 * @param args
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Uses TreeMap to sort the list of words. Uses Scanner class to
	 *            read a text file. Words are delimited by whitespace
	 *            characters, punctuation marks (,;.:?), * quotation marks ('"),
	 *            and parentheses. Count words in case-insensitive fashion *
	 *            (e.g., consider Good and good to be the same word)
	 * @param visiblity
	 *            public

	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		// You can use TreeMap to sort the list of words
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		// Use Scanner class to read a text file
		Scanner txtFile = new Scanner(new File(
				"C:\\Users\\eomed\\OneDrive\\Desktop\\CountOccurrenceOfWordsStreamTest.txt"));
		while(txtFile.hasNext())
		{
			String[] word = txtFile.nextLine().split("[ \n\t\r\"\'.,;:!?()]");
			store(map, word);

		}
		txtFile.close();

		for(Map.Entry<String, Integer> entry : map.entrySet())
		{
			System.out.println("The number occurences of the word" + " " + "'"
					+ entry.getKey() + "'" + "\t" + "=" + " "
					+ entry.getValue());
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            store(TreeMap<String, Integer> map, String[] word)
	 * @param map
	 *            Parameter
	 * @param word
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Helper method for 'store'
	 * @param visiblity
	 *            private
	 */
	private static void store(TreeMap<String, Integer> map, String[] word)
	{
		for(int i = 0; i < word.length; i++)
		{
			String key = word[i].toLowerCase();

			if(key.length() > 0 && Character.isLetter(key.charAt(0)))
			{
				if(!map.containsKey(key))
				{
					map.put(key, 1);
				}
				else
				{
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
	}
}