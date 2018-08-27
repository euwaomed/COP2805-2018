package week07;

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
		
		// MyAbstractList.java
		List<MethodTestData2> methods1 = new ArrayList<MethodTestData2>();
		methods1.add(new MethodTestData2("add","E","void","public"));
		methods1.add(new MethodTestData2("isEmpty","","boolean","public"));
		methods1.add(new MethodTestData2("size","","int","public"));
		
		List<ConstructorTestData> constructors1 = new ArrayList<ConstructorTestData>();
		constructors1.add(new ConstructorTestData("MyAbstractList", 0, "protected"));
		constructors1.add(new ConstructorTestData("MyAbstractList", 1, "protected"));

		testFiles.add(new FileTestData2("week07", "MyAbstractList.java", methods1,
				constructors1));

		// MyList.java - interface
		List<MethodTestData2> myListMethods = new ArrayList<MethodTestData2>();
		myListMethods.add(new MethodTestData2("add","E","void","public"));
		myListMethods.add(new MethodTestData2("add","intE","void","public"));
		myListMethods.add(new MethodTestData2("clear","","void","public"));
		myListMethods.add(new MethodTestData2("contains","E","boolean","public"));
		myListMethods.add(new MethodTestData2("get","int","E","public"));
		myListMethods.add(new MethodTestData2("indexOf","E","int","public"));
		myListMethods.add(new MethodTestData2("isEmpty","","boolean","public"));
		myListMethods.add(new MethodTestData2("lastIndexOf","E","int","public"));
		myListMethods.add(new MethodTestData2("remove","int","E","public"));
		myListMethods.add(new MethodTestData2("set","intE","E","public"));
		myListMethods.add(new MethodTestData2("size","","int","public"));
		
		List<ConstructorTestData> myListConstructors = new ArrayList<ConstructorTestData>();
		testFiles.add(new FileTestData2("week07", "MyList.java", myListMethods,
				myListConstructors));
		
		// MyArrayList.java - interface
		List<MethodTestData2> myArrayListMethods = new ArrayList<MethodTestData2>();		
		myArrayListMethods.add(new MethodTestData2("add","intE","void","public"));
		myArrayListMethods.add(new MethodTestData2("clear","","void","public"));
		myArrayListMethods.add(new MethodTestData2("contains","E","boolean","public"));
		myArrayListMethods.add(new MethodTestData2("get","int","E","public"));
		myArrayListMethods.add(new MethodTestData2("indexOf","E","int","public"));
		myArrayListMethods.add(new MethodTestData2("iterator","","Iterator<E>","public"));
		myArrayListMethods.add(new MethodTestData2("lastIndexOf","E","int","public"));
		myArrayListMethods.add(new MethodTestData2("remove","int","E","public"));
		myArrayListMethods.add(new MethodTestData2("set","intE","E","public"));
		myArrayListMethods.add(new MethodTestData2("toString","","String","public"));
		myArrayListMethods.add(new MethodTestData2("trimToSize","","void","public"));
		
		List<ConstructorTestData> myArrayListConstructors = new ArrayList<ConstructorTestData>();
		myArrayListConstructors.add(new ConstructorTestData("MyArrayList", 0, "public"));
		myArrayListConstructors.add(new ConstructorTestData("MyArrayList", 1, "public"));
		testFiles.add(new FileTestData2("week07", "MyArrayList.java", myArrayListMethods,
				myArrayListConstructors));
		
		m_validator = new JUnitJavadocValidationUtility2("Week07 Javadoc Test",
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
}
