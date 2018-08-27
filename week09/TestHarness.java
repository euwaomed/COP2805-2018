package week09;

import test.AbstractTestHarness;

public class TestHarness extends AbstractTestHarness
{

	public static void main(String[] args)
	{
		new TestHarness().runTests();

	}
	
	protected void runTests()
	{
		try
		{
			trace("Running tests version 2");
			boolean test = executeTest(JUnitHashMapTest.class);
			boolean javaDocTest = executeTest(JUnitJavadocValidation.class);
			boolean result = test && javaDocTest;

			trace("  ** Overall Result: " + (result ? "Tests Passed" : "Tests Failed") + " ** ");
		}
		catch(Exception ex)
		{
			trace(ex.getMessage());
		}
	}
}
