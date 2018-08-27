package week03;

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
        boolean employeeTest = executeTest(EmployeeTest.class);
        boolean dataLayerTest = executeTest(DataLayerTest.class);
        boolean collectionBusinessLayerTest = executeTest(CollectionBusinessLayerTest.class);
        boolean javadocTest = executeTest(JUnitJavadocValidation.class);
        boolean result = employeeTest && dataLayerTest && collectionBusinessLayerTest && javadocTest;
        trace(result ? "Tests Passed" : "Tests Failed");
    }
    catch(Exception ex)
    {
        trace(ex.getMessage());
    }
    }
}