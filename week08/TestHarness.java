package week08;

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
            boolean fibTest = executeTest(JUnitBstTest.class);
            boolean javaDocTest = executeTest(JUnitJavadocValidation.class);
            boolean result = fibTest && javaDocTest;

            trace("  ** Overall Result: " + (result ? "Tests Passed" : "Tests Failed") + " ** ");
        }
        catch(Exception ex)
        {
            trace(ex.getMessage());
        }
    }
}
