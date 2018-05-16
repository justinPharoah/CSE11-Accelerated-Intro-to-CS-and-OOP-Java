/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date 4/27/2018
 * @about This file, ExampleClass.java, has various intentions
 *      1. Codes a method, derivative(), to derive various expressions
 *      2. Teaches about Unit Testing, proper coding styles, commenting,
 *          and the for-each loop
 *      3. Further experience with helper methods
 */

import java.math.BigInteger;

/**
 * ExampleClass class
 *
 * Defines the derivative() method testing in UnitTestsEx.java
 * and
 * This is an example class. Notice that none of the methods
 * are static. This means you must create an instance of
 * ExampleClass before you can call one of its methods.
 *
 * Note, you will not be able to compile this file until
 * you get to the second part.
 */

public class ExampleClass {

    /**
     * Instance Variables
     */
    private String[] str;

    /**
     * Constructors
     */
    // No-argument construtor
    public ExampleClass() {

        // TODO Print statements start  
//        System.out.println("\n" +
//                "This is an example of a constructor with no arguments"
//        );
//
//        System.out.println(
//                "This is how your code should look if a single line is too long."
//        );
//
//        String[] str = {
//                "In general, don't initialize instance variables in the class.",
//                "Instead, initialize them using the constructor.",
//                "You might want to comment out all these Strings" +
//                        " when you finished reading it."};
//
//        // Read the following as "for each String s in str"
//
//        for (String s : str) {
//            System.out.println(s);
//        }
//
//        System.out.println();
        // TODO End of Print Statements  
    }

    /**
     * Methods
     */

    /**
     * the equation is in the format of a*b^c, where a and c are integers
     * and b is a variable name.  Note that the * symbol is omitted.
     *
     * For example, 2x^4 would be a==2, b=='x', and c==4.
     *
     * The derivative of 2x^4 is 8x^3. Therefore, the new values are
     * a == 8, b == 'x', c == 4.
     *
     * The return type is a String, so you will get
     * "8x^3" as the return string. No spaces, and everything is
     * concatenated with each other. The length of this particular string
     * was 4.
     */
//    public String derivative(int multiplier, char variableName, int power) {
//    }

    /** Part 1: Introduction

     The first thing in test-driven development is to understand what
     your method does. Then, write tests cases for that method.

     You won't be able to run the test yet, but make sure that your
     tester itself will be correct. You should be testing the correct
     input types for the arguments, and for the return type.

     Here are some more examples.
     Input: 16, 't', and "2"
     Output: the String "32t^1"

     Here's your practice task:

     In the UnitTestsEx.java, write several Unit Tests that will test
     this function. You know the input types, and the creation of the
     String is straightforward.

     Write testers for normal cases as well as unusual and edge cases.

     Go ahead and comment out line 74, the method signature
     of "derivative"

     */

/**************************************************************************/
/** DO NOT GO FURTHER UNTIL YOU COMPLETE THE TASK IN Part 1: Introduction */
/**************************************************************************/
    /*
    Now, unlike PSA1, here is the difference. You are GIVEN a 
    partially implemented derivative function. It is below and it is named
    derivative2. You should have already written your testers in UnitTestsEx.java.

    If not, do it now. That is the purpose of Test-Driven Development: writing
    your testers before you implement the function!
    */

    /*******************************/
    /*            Part 2           */
    /*******************************/

    /*
        The definition of the method named derivative is partially 
        implemented below.

        TODO Rename derivative2 as derivative so that your tester methods call
        the correct function. (Alternatively, you could rename all your 
        method calls, but why)
    */

    /*
     Original Method Description:
            the equation is in the format of a*b^c, where a and c are integers 
            and b is a variable name. Note that the * symbol is omitted.

            For example, 2x^4 would be a==2, b=='x', and c==4. 

            The derivative of 2x^4 is 8x^3. Therefore, the new values are
            a == 8, b == 'x', c == 4. 

            The return type is a String, so you will get
            "8x^3" as the return string. No spaces, and everything is 
            concatenated with each other. The length of this particular string
            was 4.
     Task:
            TODO: This function is partially implemented correctly. Fix this
            method as much as you want, and then rerun your unit tests.

            The more you fix, the more your unit tests should report correct. 

            The more unit tests you wrote, the more obvious what your task
            is in continually fixing the implementation of this method. 

            Again, this section does not count for credit. You may do as much
            as you want. 
    */

    /**
     * Calculates the derivative
     * given a coefficient, variable, and exponent
     *
     * @param multiplier coefficient of expression to derive
     * @param variableName variable in the expression to derive
     * @param power exponent of expression to derive
     * @return String representation of derived answer
     */
    public String derivative (int multiplier, char variableName, int power) {
        BigInteger bigMultiplier = BigInteger.valueOf(multiplier);
        BigInteger bigPower = BigInteger.valueOf(power);
        BigInteger newMultiplier, newPower;

//        print(multiplier, variableName, power);       //Print original

        newMultiplier = bigMultiplier.multiply(bigPower);               //Find new values
        newPower = bigPower.subtract(BigInteger.valueOf(1));

//        print(newMultiplier.intValue(), variableName, newPower.intValue());       //Print new

        if (power == 0) {
            return newMultiplier.toString();
        } else if (bigMultiplier.intValue() == 0 || newPower.intValue() == 0) {
            return bigMultiplier.toString();
        } else {
            return (newMultiplier.toString() +         //Return as String
                    variableName + "^" +
                    newPower.toString());
        }
    }

    /**
     * Helper method:
     *
     * Prints out the mathematical equation: a*b^c where
     * a is the multiplier, b is the variable letter, and c the power.
     * There are no intentional errors in this method
     *
     * Input: a is the multiplier in the expression, b is the
     * variable name, and c is the exponent of the variable.
     *
     * Output: Nothing. The result of the passed in arguments
     * will be that the term will be printed out in the format:
     *
     * ab^c
     * a times b to the power of c.
     */
    public void print(int a, char b, int c) {
        System.out.println("Equation:");
        System.out.println(
                Integer.toString(a) + (char) b +
                        '^' + Integer.toString(c) + "\n"
        );
    }
}
