package week05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import test.javadoc.JUnitJavadocValidationUtility2;
import test.javadoc.MethodTestData2;
import test.AbstractJUnitBase;
import test.TestResult;
import test.TestResultDetail;
import test.javadoc.ConstructorTestData;
import test.javadoc.FileTestData2;

/**
 * Tests the Javadoc in the source file.
 * 
 * @author Scott
 *
 */
public class JUnitJavadocValidation extends AbstractJUnitBase
{
	public JUnitJavadocValidation()
	{
		m_stream = System.out; // Standard out

		// setup files to analyze (constructors/methods)
		List<FileTestData2> testFiles = new ArrayList<FileTestData2>();
		List<MethodTestData2> gcdMethods = new ArrayList<MethodTestData2>();

		// EuclidGcd.java
		gcdMethods.add(new MethodTestData2("start", "longlong", "long", "public"));

		List<ConstructorTestData> constructors = new ArrayList<ConstructorTestData>();
		constructors.add(new ConstructorTestData("EuclidGcd", 0, "public"));

		testFiles.add(new FileTestData2("week05", "EuclidGcd.java", gcdMethods,
				constructors));

		// Fibonacci.java
		List<MethodTestData2> fibMethods = new ArrayList<MethodTestData2>();
		fibMethods.add(new MethodTestData2("fib", "long", "long", "public"));

		testFiles.add(new FileTestData2("week05", "Fibonacci.java", fibMethods));

		m_validator = new JUnitJavadocValidationUtility2("Week05 Javadoc Test",
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
			trace(" - Javadoc validation failed - details");
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
}
