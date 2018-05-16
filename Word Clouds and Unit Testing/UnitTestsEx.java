/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date 4/27/2018
 * @about This file, UnitTestsEx.java, holds the code for the class and methods
 *      used to test the derivative() method in ExampleClass.java
 */

import java.util.*;

/**
 * UnitTestsEx class
 *
 * Tests the derivative() method in ExampleClass class
 * using various Unit Tester methods that test many
 * happy and edge cases to ensure the derivative()
 * method works correctly
 */
public class UnitTestsEx {

    /**
     * Instance Variables
     */
    //often used, so made into final variables
    private static final int MAX_INT = 2147483647;
    private static final int MIN_INT = -2147483647;


    /**
     * Constructors
     */

    /**
     * Default Constructor for UnitTestsEx class
     * Does nothing
     * Used strictly for creating UnitsTestsEx objects
     */
    public UnitTestsEx() {
    }


    // TODO Methods (Write your Unit Tests here.)


    /**
     * Outputs the results for the Unit Tester methods below
     *
     * @param testName The name of the unit test being evaluated.
     * @param testInput The input for the specific case tested in a Unit Tester
     * @param correctAnswer The correct answer for the specific case
     * @param testAnswer Actual result of the specific case
     */
    public static void outputTestResults(String testName,
                               String testInput, String correctAnswer,
                               String testAnswer) {
        if (!testAnswer.equals(correctAnswer)) {
            System.out.println("\tTest with [" + testName + "] FAILED");
            System.out.println("\t\tGiven message to derive was: " + testInput);
            System.out.println("\t\tYour Answer is: " + testAnswer);
            System.out.println("\t\tThe correct answer is: " + correctAnswer + "\n");
        } else {
            System.out.println("\tTest [" + testName + "] Passed!");
            System.out.println("\t\tGiven message to derive was: " + testInput);
            System.out.println("\t\tThe correct answer is: " + correctAnswer);
            System.out.println("\t\tYour Answer is: " + testAnswer + "\n");
        }
    }

    /**
     * exampleTestUsingPrinting
     *
     * Example test case. Uses println very often.
     * May be useful if you prefer your unit test to
     * "speak" to you.
     * NOTE: The return type of this method is void.
     * All the results are printed to terminal.
     *
     * @return void
     */
    public void exampleTestUsingPrinting() {
        System.out.println("Unit Test Example. ");

        ExampleClass ec = new ExampleClass();

        String correctAnswer = "9y^2";
        String result = ec.derivative(3, 'y', 3);

        String correctAnswer2 = "5";
        String result2 = ec.derivative(5, 'x', 1);

        //The derivative of 5x^0
        //The derivative of 5x
        //The answer should be 5.

        //However, the function might return 0x^-1. That's not right.
        //Fix that error in the method, and then rerun this tester.


        System.out.println(
                "The correct answer is:  " + correctAnswer + "\n" +
                        "The answer received is: " + result + "\n"
        );

        System.out.println(
                "The correct answer is:  " + correctAnswer2 + "\n" +
                        "The answer received is: " + result2 + "\n"
        );
    }


    /**
     * exampleTestUsingExceptions
     *
     * If the program crashes due to the test case, an Exception
     * will be thrown. However, here is the important difference:
     * you may now edit your method and fix the code that causes
     * the Exception. Then, when you run the test again, if the
     * Exception is not thrown anymore, then the code would be fixed.
     *
     * Exceptions are also possibly useful in minimizing the amount
     * of lines printed to the Terminal.
     *
     * Note the return type is void. If a test case fails, then
     * an Exception will be thrown. Also note, that the example of
     * throwing an Exception took in an argument: a String.
     *
     * Run this method and see what the Exception prints out the Terminal.
     *
     * @throws Exception thrown if testing derivative() fails
     * @return void
     */
    public void exampleTestUsingExceptions() throws Exception {
        ExampleClass ec = new ExampleClass();

        String correctAnswer = "9y^2";
        String result = ec.derivative(3, 'y', 3);

        String correctAnswer2 = "5";
        String result2 = ec.derivative(5, 'x', 1);

        //The derivative of 5x^0
        //The derivative of 5x
        //The answer should be 5.

        //However, the function might return 0x^-1. That's not right.
        //Fix that error in the method, and then rerun this tester.

        System.out.println("Running tests using Exception.");

        if (!correctAnswer.equals(result)) {
            System.out.println("result " + result);
            throw new Exception("First test failed.");
        }

        if (!correctAnswer2.equals(result2)) {
            throw new Exception("Second test failed.");
        }
    }

    /**
     * Tests derivative() with various positive coefficients
     *
     * @return void
     */
    public void testDerivPositiveCoefficients() {
        ExampleClass ecTests = new ExampleClass();

        System.out.println(
                "\nExecuting Derivative Tests with Positive Coefficients..."
        );

        String testName = "Small Positive Coefficient";
        String testInput = "10x^3";
        String testAnswer = ecTests.derivative(10, 'x', 3);
        String correctAnswer = "30x^2";

        outputTestResults(testName, testInput, correctAnswer, testAnswer);

        String testName2 = "Large Positive Coefficient";
        String testInput2 = "2147483647y^3";
        String testAnswer2 = ecTests.derivative(MAX_INT, 'y', 3);
        String correctAnswer2 = "6442450941y^2";

        outputTestResults(testName2, testInput2, correctAnswer2, testAnswer2);
    }

    /**
     * Tests derivative() with various negative coefficients
     *
     * @return void
     */
    public void testDerivNegativeCoefficient() {
        ExampleClass ecTests = new ExampleClass();

        System.out.println(
                "\nExecuting Derivative Tests with Negative Coefficients..."
        );

        String testName = "Small Negative Coefficient";
        String testInput = "-10x^3";
        String testAnswer = ecTests.derivative(-10, 'x', 3);
        String correctAnswer = "-30x^2";

        outputTestResults(testName, testInput, correctAnswer, testAnswer);

        String testName2 = "Large Negative Coefficient";
        String testInput2 = "-2147483647y^3";
        String testAnswer2 = ecTests.derivative(MIN_INT, 'y', 3);
        String correctAnswer2 = "-6442450941y^2";

        outputTestResults(testName2, testInput2, correctAnswer2, testAnswer2);
    }

    /**
     * Tests derivative() with a coefficient of zero
     *
     * @return void
     */
    public void testDerivZeroCoefficient() {
        ExampleClass ecTests = new ExampleClass();

        System.out.println(
                "\nExecuting Derivative Test with Coefficient of Zero..."
        );

        String testName = "Coefficient of Zero";
        String testInput = "0x^3";
        String testAnswer = ecTests.derivative(0, 'x', 3);
        String correctAnswer = "0";

        outputTestResults(testName, testInput, correctAnswer, testAnswer);
    }

    /**
     * Tests derivative() with various positive exponents
     *
     * @return void
     */
    public void testDerivPositivePowers() {
        ExampleClass ecTests = new ExampleClass();

        System.out.println(
                "\nExecuting Derivative Tests with Positive Exponents..."
        );

        String testName = "Small Positive Exponent";
        String testInput = "3x^6";
        String testAnswer = ecTests.derivative(3, 'x', 6);
        String correctAnswer = "18x^5";

        outputTestResults(testName, testInput, correctAnswer, testAnswer);

        String testName2 = "Large Positive Exponent";
        String testInput2 = "3y^2147483647";
        String testAnswer2 = ecTests.derivative(3, 'y', MAX_INT);
        String correctAnswer2 = "6442450941y^2147483646";

        outputTestResults(testName2, testInput2, correctAnswer2, testAnswer2);
    }

    /**
     * Tests derivative() with various negative exponents
     *
     * @return void
     */
    public void testDerivNegativePowers() {
        ExampleClass ecTests = new ExampleClass();

        System.out.println(
                "\nExecuting Derivative Tests with Negative Exponents..."
        );

        String testName = "Small Negative Exponent";
        String testInput = "3x^-6";
        String testAnswer = ecTests.derivative(3, 'x', -6);
        String correctAnswer = "-18x^-7";

        outputTestResults(testName, testInput, correctAnswer, testAnswer);

        String testName2 = "Large Negative Exponent";
        String testInput2 = "3y^-2147483647";
        String testAnswer2 = ecTests.derivative(3, 'y', MIN_INT);
        String correctAnswer2 = "-6442450941y^-2147483648";

        outputTestResults(testName2, testInput2, correctAnswer2, testAnswer2);
    }

    /**
     * Tests derivative() with an exponent of zero
     *
     * @return void
     */
    public void testDerivZeroPower() {
        ExampleClass ecTests = new ExampleClass();

        System.out.println(
                "\nExecuting Derivative Test with Exponent of Zero..."
        );

        String testName = "Exponent of Zero";
        String testInput = "3x^0";
        String testAnswer = ecTests.derivative(3, 'x', 0);
        String correctAnswer = "0";

        outputTestResults(testName, testInput, correctAnswer, testAnswer);
    }

    /**
     * The main method to test
     * the derivative method in the Example Class
     *
     * @param args unused
     * @throws Exception exampleTestUsingExceptions()
     */
    public static void main(String[] args) throws Exception {
        UnitTestsEx unitTests = new UnitTestsEx();

        //Write your method calls below. 

        unitTests.exampleTestUsingPrinting();        //TODO Try me.
        unitTests.exampleTestUsingExceptions();      //TODO Try me.

        unitTests.testDerivPositiveCoefficients();
        unitTests.testDerivNegativeCoefficient();
        unitTests.testDerivZeroCoefficient();
        unitTests.testDerivPositivePowers();
        unitTests.testDerivNegativePowers();
        unitTests.testDerivZeroPower();
    }
}



