package week10;

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
            boolean enumerationTest = executeTest(JUnitTest.class);
            boolean javadocTest = executeTest(JUnitJavadocValidation.class);
            boolean result = enumerationTest && javadocTest;

            trace(result ? "Tests Passed" : "Tests Failed");
        }
        catch(Exception ex)
        {
            trace(ex.getMessage());
        }
    }
}
