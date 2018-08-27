package week02;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import test.TestResult;
import test.TestResultDetail;
import test.javadoc.ConstructorTestData;
import test.javadoc.FileTestData2;
import test.javadoc.JUnitJavadocValidationUtility2;
import test.javadoc.MethodTestData2;

/**
 * Tests the Javadoc in the source file.
 *
 * @author Scott
 *
 */
public class JUnitJavadocValidation
{
	public JUnitJavadocValidation()
	{
		m_stream = System.out; // Standard out

		trace("########### Initializing JUnitJavadocValidation for week02 ###########");

		List<FileTestData2> testFiles = new ArrayList<FileTestData2>();
		List<MethodTestData2> methods = new ArrayList<MethodTestData2>();
		List<ConstructorTestData> constructors = new ArrayList<ConstructorTestData>();

		constructors.add(new ConstructorTestData("IteratorTest", 1, "public"));

		methods.add(new MethodTestData2("execute", "", "void", "public"));
		methods.add(new MethodTestData2("getElapsedTimeInMilliseconds", "",
				"long", "public"));
		methods.add(new MethodTestData2("getIteratorElapsedTimeInMilliseconds",
				"", "long", "public"));
		methods.add(new MethodTestData2("getListSize", "", "long", "public"));

		testFiles.add(new FileTestData2("week02", "IteratorTest.java", methods,
				constructors));

		m_validator = new JUnitJavadocValidationUtility2("Week02 Javadoc Test",
				testFiles);

		m_validator.suppressParserTrace(true);
	}

	@Test
	public void testJavadoc()
	{
		trace("** Validating Javadoc **");

		// Update these values for each assignment
		// m_packageName = "week02";
		TestResult result = m_validator.runTest();
		StringBuilder details = new StringBuilder();
		if(!result.passed())
		{
			List<TestResultDetail> detailList = result.getTestResultDetails();
			for(TestResultDetail detail : detailList)
			{
				trace(detail.testDetails());
				details.append(detail.testDetails());
				details.append(CRLF);
			}
		}
		trace(String.format("** Test result: %s **",
				result.passed() ? "Passed" : "Failed"));
		assertTrue(details.toString(), result.passed());
	}

	/**
	 * Trace the msg to a PrintStream Provides the method for tests to report
	 * status
	 *
	 * @param msg
	 */
	private void trace(String msg)
	{
		m_stream.println(msg);
	}

	private JUnitJavadocValidationUtility2 m_validator;
	protected PrintStream m_stream;
	private static String CRLF = System.getProperty("line.separator");
}
