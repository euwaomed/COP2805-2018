package week06;

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
		
		// InsertionSort.java
		List<MethodTestData2> insertionMethods = new ArrayList<MethodTestData2>();
		insertionMethods.add(new MethodTestData2("sort","","void","public"));
		
		List<ConstructorTestData> constructors = new ArrayList<ConstructorTestData>();
		constructors.add(new ConstructorTestData("InsertionSort", 1, "public"));

		testFiles.add(new FileTestData2("week06", "InsertionSort.java", insertionMethods,
				constructors));

		// MergeSort.java
		List<MethodTestData2> mergeMethods = new ArrayList<MethodTestData2>();
		mergeMethods.add(new MethodTestData2("sort","","void","public"));
		
		List<ConstructorTestData> mergeConstructors = new ArrayList<ConstructorTestData>();
		mergeConstructors.add(new ConstructorTestData("MergeSort", 1, "public"));

		testFiles.add(new FileTestData2("week06", "MergeSort.java", mergeMethods, mergeConstructors));

		// SelectionSort.java
		List<MethodTestData2> selectionMethods = new ArrayList<MethodTestData2>();
		selectionMethods.add(new MethodTestData2("sort","","void","public"));
		
		List<ConstructorTestData> selectionConstructors = new ArrayList<ConstructorTestData>();
		selectionConstructors.add(new ConstructorTestData("SelectionSort", 1, "public"));

		testFiles.add(new FileTestData2("week06", "SelectionSort.java", selectionMethods, selectionConstructors));

		m_validator = new JUnitJavadocValidationUtility2("Week06 Javadoc Test",
				testFiles);
		m_validator.suppressParserTrace(true);
	}

	@Test
	public void testJavadoc()
	{
		trace("** Validating Javadoc **");

		// Update these values for each assignment
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
}
