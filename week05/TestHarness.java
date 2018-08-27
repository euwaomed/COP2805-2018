package week05;

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
            //trace("Running tests version 2");
            boolean fibTest = executeTest(JUnitFibonacciTest.class);
            boolean gcdTest = executeTest(JUnitEuclidGcdTest.class);
            boolean javadocTest = executeTest(JUnitJavadocValidation.class);
            boolean result = fibTest && gcdTest && javadocTest;

            trace(result ? "Tests Passed" : "Tests Failed");
        }
        catch(Exception ex)
        {
            trace(ex.getMessage());
        }
    }
}
