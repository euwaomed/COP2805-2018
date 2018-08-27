package week03;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import test.javadoc.JUnitJavadocValidationUtility2;
import test.javadoc.MethodTestData2;
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
public class JUnitJavadocValidation
{
    public JUnitJavadocValidation()
    {
        m_stream = System.out; // Standard out

        trace("########### Initializing JUnitJavadocValidation for week03 ###########");
        List<FileTestData2> testFiles = new ArrayList<FileTestData2>();

        List<MethodTestData2> methods = new ArrayList<MethodTestData2>();

        // Employee.java
        methods.add(new MethodTestData2("equals", "Object", "boolean", "public"));
        methods.add(
                new MethodTestData2("getDisplayName", "", "String", "public"));
        methods.add(new MethodTestData2("getFirstName", "", "String", "public"));
        methods.add(new MethodTestData2("getFormattedSalary", "", "String",
                "public"));
        methods.add(new MethodTestData2("getLastName", "", "String", "public"));
        methods.add(new MethodTestData2("getSalary", "", "double", "public"));
        methods.add(new MethodTestData2("setFirstName", "String", "void", "public"));
        methods.add(new MethodTestData2("setLastName", "String", "void", "public"));
        methods.add(new MethodTestData2("setSalary", "double", "void", "public"));
        methods.add(new MethodTestData2("toString", "", "String", "public"));

        List<ConstructorTestData> constructors = new ArrayList<ConstructorTestData>();
        constructors.add(new ConstructorTestData("Employee", 0, "public"));
        constructors.add(new ConstructorTestData("Employee", 2, "public"));
        constructors.add(new ConstructorTestData("Employee", 3, "public"));

        testFiles.add(new FileTestData2("week03", "Employee.java", methods,
                constructors));

        methods = new ArrayList<MethodTestData2>();

        // DataLayer.java
        List<MethodTestData2> dlMethods = new ArrayList<MethodTestData2>();
        dlMethods.add(new MethodTestData2("addEmployee", "Employee", "void", "public"));
        dlMethods.add(
                new MethodTestData2("deleteEmployee", "Employee", "boolean", "public"));
        dlMethods.add(new MethodTestData2("getEmployeeByName", "String", "Employee",
                "public"));
        dlMethods.add(new MethodTestData2("getEmployees", "", "List<Employee>",
                "public"));
        dlMethods.add(new MethodTestData2("getSize", "", "int", "public"));

        List<ConstructorTestData> dlConstructors = new ArrayList<ConstructorTestData>();
        dlConstructors.add(new ConstructorTestData("DataLayer", 1, "public"));
        testFiles.add(new FileTestData2("week03", "DataLayer.java", dlMethods,
                dlConstructors));

        // CollectionBusinessLayer.java
        List<MethodTestData2> blMethods = new ArrayList<MethodTestData2>();
        blMethods.add(
                new MethodTestData2("addEmployee", "StringStringdouble", "Employee", "public"));
        blMethods.add(
                new MethodTestData2("deleteEmployee", "String", "Employee", "public"));
        blMethods.add(new MethodTestData2("changeEmployeeSalary", "Stringdouble", "boolean",
                "public"));
        blMethods.add(new MethodTestData2("listAllEmployees", "","List<Employee>", "public"));
        blMethods.add(
                new MethodTestData2("listEmployee", "String", "Employee", "public"));

        List<ConstructorTestData> blConstructors = new ArrayList<ConstructorTestData>();
        blConstructors.add(new ConstructorTestData("CollectionBusinessLayer", 0,
                "public"));
        blConstructors.add(new ConstructorTestData("CollectionBusinessLayer", 1,
                "public"));
        testFiles.add(new FileTestData2("week03", "CollectionBusinessLayer.java",
                blMethods, blConstructors));

        for(FileTestData2 file : testFiles)
        {
            trace(" - testing " + file.getFileName());
        }
        m_validator = new JUnitJavadocValidationUtility2("Week03 Javadoc Test",
                testFiles);
        m_validator.suppressParserTrace(true);

        trace("########### Initialization Complete for JUnitJavadocValidation ###########");
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

    /**
     * Trace the msg to a PrintStream Provides the method for tests to report
     * status
     *
     * @param msg
     */
    protected void trace(String msg)
    {
        if(m_stream == null)
        {
            System.out.println(msg);
        }
        else
        {
            m_stream.println(msg);
        }
    }

    private JUnitJavadocValidationUtility2 m_validator;

    protected PrintStream m_stream;
    // private String m_packageName;
    // private ArrayList<MethodData> m_methods;
    // private static String ONEPARAM = "\\w* \\w*\\(\\w* \\w*\\)";
    private static String CRLF = System.getProperty("line.separator");
}
