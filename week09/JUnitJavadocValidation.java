package week09;

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
 * @author Scott LaChance
 */
public class JUnitJavadocValidation extends AbstractJUnitBase
{
	public JUnitJavadocValidation()
	{
		m_stream = System.out; // Standard out

		// setup files to analyze (constructors/methods)
		
		List<FileTestData2> testFiles = new ArrayList<FileTestData2>();
		
		// BST.java
		List<MethodTestData2> methods1 = new ArrayList<MethodTestData2>();
		methods1.add(new MethodTestData2("clear","","void","public"));
		methods1.add(new MethodTestData2("containsKey","K","boolean","public"));
		methods1.add(new MethodTestData2("containsValue","V","boolean","public"));
		methods1.add(new MethodTestData2("entrySet","","Set<MyMap.Entry<K, V>>","public"));
		methods1.add(new MethodTestData2("get","K","V","public"));
		methods1.add(new MethodTestData2("isEmpty","","boolean","public"));
		methods1.add(new MethodTestData2("keySet","","Set<K>","public"));
		methods1.add(new MethodTestData2("put","KV","V","public"));
		methods1.add(new MethodTestData2("remove","K","void","public"));
		methods1.add(new MethodTestData2("size","","int","public"));
		methods1.add(new MethodTestData2("toString","","String","public"));
		methods1.add(new MethodTestData2("values","","Set<V>","public"));
		
		List<ConstructorTestData> constructors1 = new ArrayList<ConstructorTestData>();
		constructors1.add(new ConstructorTestData("MyHashMapLinear", 1, "public"));
		constructors1.add(new ConstructorTestData("MyHashMapLinear", 2, "public"));

		testFiles.add(new FileTestData2("week09", "MyHashMapLinear.java", methods1,
				constructors1));

		m_validator = new JUnitJavadocValidationUtility2("Week09 Javadoc Test",
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
