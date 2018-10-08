/**
 * @author Justin Ferrell (cs11sbm)
 * @PID A14437143
 * @date April 18, 2018
 * @about List and fix this program that has numerous Compile Time, Run Time, and Logic errors.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 1: Line 8 (original file) / Line 188 (current file)
 *
 * Compile Time Error - Invalid Method Declaration
 *
 *      - Incorrect: public static findMax(int[] array)
 *
 *      - Fix:       public static int findMax(int[] array)
 *
 * Explanation: This is an invalid method declaration, and a return type is required.
 *      Correction starts at the return type for the method findMax.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 2: Line 51 (original file) / Line 241 (current file)
 *
 * Compile Time Error - Not a statement
 *
 *      - Incorrect: sum == array[i];
 *
 *      - Fix: sum += array[i];
 *
 * Explanation: '==' is a boolean comparison, and cannot assign array[i] to a variable,
 *      or in this case add array[i] to the existing value of sum.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 3: Line 30 (original file) / Line 215 (current file)
 *
 * Compile Time Error - Cannot Find Symbol
 *
 *      - Incorrect: min = array[0];
 *
 *      - Fix: int min = array[0];
 *
 * Explanation: The variable min cannot be initialized with array[0] if min has not been
 *      declared in the first place. min must be declared an int since array is an array
 *      of ints.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 4: Line 54 (original file) / Line 244 (current file)
 *
 * Compile Time Error - Incompatible Types: possible lossy conversion from double to int
 *
 *      - Incorrect: int average = ( sum / (array.length ) );
 *
 *      - Fix: double average = (sum / (array.length));
 *
 * Explanation: The calculation '(sum / (array.length))' results in a double since sum is
 *      a variable of type double. This result cannot be assigned to an int variable.
 *      Also fixed coding style.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 5: Line 60 (original file) / Line 255 (current file)
 *
 * Compile Time Error - Invalid Method Parameter
 *
 *      - Incorrect: public static int[] arrayCopy(int array)
 *
 *      - Fix: public static int[] arrayCopy(int [] array)
 *
 * Explanation: Purpose of the method is to copy the array parameter, and cannot be done
 *      if the parameter is an int variable, not an int array. Several statements also
 *      threw Compile Time Errors because of this:
 *
 *      Line 61: if (array == null)
 *          Error: bad operand types for binary operator '=='
 *          first type: int | second type: <nulltype>
 *
 *      Line 64: int[] result = new int[array.length];
 *          Error: int cannot be dereferenced
 *
 *      Line 66: for (int i = 0; i < array.length; i++)
 *          Error: int cannot be dereferenced
 *
 *      Line 67: result[i++] = array[i];
 *          Error: array required, but int found
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 6: Line 15 (original file) / Line 195 (current file)
 *
 * Runtime Error - java.lang.ArrayIndexOutOfBoundsException: 8
 *
 *      - Incorrect: for (int i = 0; i <= array.length; i++)
 *
 *      - Fix: for (int i = 0; i < array.length; i++)
 *
 * Explanation: The for loop attempts to access the Array 'array' with an illegal index
 *      position. The index is greater than or equal to the length of 'array'.
 *      Although the error is on Line 15, the exception was thrown on:
 *
 *      Line 16: if (array[i] > max)
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 7: Line 92 (original file) / Line 298 (current file)
 *
 * Runtime Error - java.lang.ArrayIndexOutOfBoundsException: 8
 *
 *      - Incorrect: for (int j = 0; i < result.length - i - 1; j++)
 *
 *      - Fix: for (int j = 0; j < result.length - i - 1; j++)
 *
 * Explanation: The for loop was using 'i' and not 'j' for the condition
 *      j < result.length - i - 1. This means j would be continuously incremented with no
 *      bounds until an attempt to access the Array 'result' with an illegal index greater
 *      than or equal to the length of the array on Line 93. This explains why the
 *      exception is thrown on Line 93:
 *
 *      Line 93: if (result[j] > result[j + 1])
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 8: Line 74 (original file) / Line 274 (current file)
 *
 * Logic Error - Returns nothing if array is not null
 *
 *      - Incorrect: if (array != null)
 *
 *      - Fix: if (array == null)
 *
 * Explanation: This is a logic error because if the array passed into the printArray
 *      method is not null, or filled, the array will not be printed out, and instead
 *      the printArray method will return nothing. Instead, we want the printArray
 *      method to return nothing only if the array is empty, or null, in order to
 *      avoid a NullPointerException.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 9: Line 67 (original file) / Line 262 (current file)
 *
 * Logic Error - Improper index assignment when copying original array to copy array
 *
 *      - Incorrect: result[i++] = array[i];
 *
 *      - Fix: result[i] = array[i];
 *
 * Explanation: This is a logic error because by incrementing 'i' in result[i++], the
 *      following element of the passed in array will be assigned to the first element of
 *      result. For example: if i = 0, result[i++] = array[i]; will yield result[0] = array[1];
 *      and thus result[0] will equal 4, not 7. In the end, result will now contain:
 *      {4, 0, 8, 0, 32, 0, 13, 0,} rather than {7, 4, 1, 8, 12, 32, 64, 13,}.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 10: Line 96 (original file) / Line 302 (current file)
 *
 * Logic Error - Improper index assignment for swapping two indices
 *
 *      - Incorrect: result[j + 1] = result[j]
 *
 *      - Fix: result[j] = result[j + 1]
 *
 * Explanation: This is a logic error because the purpose of this line is to take the
 *      smaller value, which is in i + 1 and assign it to the current index i.
 *      With the current code, for example, if result[j] = 7, and result[j + 1] = 4,
 *      result[j + 1] will now be assigned the value 7, and result[j] will also still be 7,
 *      instead of result[j + 1] = 4 and result[j] = 4.
 *      The impact of this is shown in the next error.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 11: Line 97 (original file) / Line 303 (current file)
 *
 * Logic Error = Improper index assignment for temp
 *
 *      - Incorrect: result[j] = temp;
 *
 *      - Fix: result[j + 1] = temp;
 *
 * Explanation: This is a logic error because temp is being assigned to the wrong index
 *      of the array 'result'. At this point, as seen in the previous error,
 *      result[j + 1] = 7, and result[j] = 7. If we now do result[j] = temp;,
 *      result[j] will still hold the value 7, instead of being assigned the smaller
 *      value, 4. With the fixed code in the previous error, and the fixed code for this
 *      error, result[j] will equal 4, and result[j + 1] will equal 7.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 */

/**
 * FunWithIntArrays class
 *
 * This is a program that has numerous Compile Time, Run Time, and Logic errors.
 * Task is to find them, list them, and fix them
 */
public class FunWithIntArrays {

    /**
     * Returns the largest element in the input array
     *
     * @param array takes in an int array 'array'
     * @return int
     */
    public static int findMax(int[] array) {
        //short circuit protects null access
        if (array == null || array.length == 0)
            return -1;

        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    /**
     * Returns the smallest element in the input array
     *
     * @param array takes in an int array 'array'
     * @return int
     */
    public static int findMin(int[] array) {
        //short circuit protects null access
        if (array == null || array.length == 0)
            return -1;

        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = i;
            }
        }

        return min;
    }


    /**
     * Returns the average of elements in the input array
     *
     * @param array takes in an int array 'array'
     * @return double
     */
    public static double findAvg(int array[]) {
        //short circuit protects null access
        if (array == null || array.length == 0)
            return -1;

        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (sum / (array.length));

        return average;
    }

    /**
     * Returns a copy of the input array
     *
     * @param array takes in an int array 'array'
     * @return int[]
     */
    public static int[] arrayCopy(int[] array) {
        if (array == null)
            return null;

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    /**
     * Outputs the elements of the input array
     *
     * @param array takes in an int array 'array'
     * @return void
     */
    public static void printArray(int[] array) {
        if (array == null)
            return;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }

    /**
     * Uses Bubble Sort and
     * Returns a sorted copy of the input array
     *
     * @param array takes in an int array 'array'
     * @return int[]
     */
    public static int[] arraySort(int[] array) {
        if (array == null)
            return null;

        int[] result = arrayCopy(array);

        for (int i = 0; i < result.length - 1; ++i) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    //swapping result[j] and result[j+1]
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        return result;
    }
}
