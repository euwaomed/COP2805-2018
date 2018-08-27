package week08;

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
		methods1.add(new MethodTestData2("clone","","Object","public"));
		methods1.add(new MethodTestData2("createNewNode","E","TreeNode<E>","protected"));
		methods1.add(new MethodTestData2("delete","E","boolean","public"));
		methods1.add(new MethodTestData2("getRoot","","TreeNode<E>","public"));
		methods1.add(new MethodTestData2("getSize","","int","public"));
		methods1.add(new MethodTestData2("inorder","","void","public"));
		methods1.add(new MethodTestData2("inorder","TreeNode<E>","void","protected"));
		methods1.add(new MethodTestData2("insert","E","boolean","public"));
		methods1.add(new MethodTestData2("iterator","","Iterator<E>","public"));
		methods1.add(new MethodTestData2("path","E","ArrayList<TreeNode<E>>","public"));
		methods1.add(new MethodTestData2("postorder","","void","public"));
		methods1.add(new MethodTestData2("postorder","TreeNode<E>","void","protected"));
		methods1.add(new MethodTestData2("preorder","","void","public"));
		methods1.add(new MethodTestData2("preorder","TreeNode<E>","void","protected"));
		methods1.add(new MethodTestData2("search","E","boolean","public"));
		methods1.add(new MethodTestData2("getLeafData","","List<E>","public"));
		
		List<ConstructorTestData> constructors1 = new ArrayList<ConstructorTestData>();
		constructors1.add(new ConstructorTestData("BST", 0, "public"));
		constructors1.add(new ConstructorTestData("BST", 1, "public"));

		testFiles.add(new FileTestData2("week08", "BST.java", methods1,
				constructors1));

		m_validator = new JUnitJavadocValidationUtility2("Week08 Javadoc Test",
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
