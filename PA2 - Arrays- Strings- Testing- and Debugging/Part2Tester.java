/**
 * @author Justin Ferrell (cs11sbm)
 * @PID A14437143
 * @date April 19, 2018
 * @about This file, Part2Tester.java, uses unit tester methods to
 *      find and list errors within CaesarWithBugs.class
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 1: Method: testEncryptWithLargePositiveRotation
 *            Method: testDecryptWithLargePositiveRotation
 *
 * Logic Error - Encryption/Decryption cannot handle very large (positive) numbers
 *
 * Explanation: We can assume that the code for the Caesar encrypt and decrypt do not
 *      function properly when given numbers much larger than 26.
 *
 *      The particular edge case I tested was: 2147483647
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 2: Method: testEncryptWithLargeNegativeRotation
 *            Method: testDecryptWithLargeNegativeRotation
 *
 * Logic Error - Encryption/Decryption cannot handle very large (negative) numbers
 *
 * Explanation: We can assume that the code for the Caesar encrypt and decrypt do not
 *      function properly when given numbers much smaller than -26.
 *
 *      The specific edge case I tested was: -2147483647
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 3: Method: testEncryptWithAandZ
 *
 * Logic Error - A's and Z's fail to be encrypted
 *
 * Explanation: We can assume from the tester output that the encrypt method does not
 *      include A's and Z's within its encryption. This shows that the method is
 *      perhaps checking for > 'A' and < 'Z' rather than >= 'A' and <= 'Z'
 *
 *      The specific case I tested was: 'AaZz'
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 4: Method: testDecryptWithSymbols
 *
 * Logic Error - The symbols '[', '\', '^', ']', '_', and '`' do not decrypt properly.
 *
 * Explanation: This shows that the decrypt method has a logic error when checking for
 *      letters versus non-alphabetic characters. Although the symbols encrypt properly
 *      in that they stay the same, the symbols do not stay the same during decryption.
 *
 *      The specific case I tested was: '[\]^_`'
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * # Error 5: Method: testEncryptWithEmptyString
 *
 * Logic Error - Empty strings are not properly accounted for.
 *
 * Explanation: Encrypting an empty String throws a StringIndexOutOfBoundsException
 *      This shows that empty String's are not properly accounted for. If
 *      they had been accounted for encrypting an empty String would have still returned an
 *      empty String, however it threw an error instead
 *
 * ---------------------------------------------------------------------------------------------------------------------
 */

/**
 * Part2Tester class
 *
 * Tests the encrypt and decrypt methods in the CaesarWithBugs.class
 * Task is to find and list the bugs by using unit tester methods
 * There should be 5 errors
 *
 */
public class Part2Tester {

    /**
     * Check the test case to see if it's correct
     *
     * @param testName       The name of the unit test being evaluated.
     * @param message        The message to encrypt or decrypt
     * @param expectedAnswer The answer expected
     * @param actualAnswer   The actual answer produced
     * @param enc_or_dec     A string specifying what function was tested.
     * @return 1 if the test failed, and 0 otherwise.
     */
    public static int testCase(String testName,
                               String message, String expectedAnswer,
                               String actualAnswer, String enc_or_dec) {
        if (!expectedAnswer.equals(actualAnswer)) {
            System.out.println("Test [" + testName + "] FAILED (" +
                    enc_or_dec + ")");
            System.out.println("  Given message to " + enc_or_dec + " is: "
                    + message);
            System.out.println("  Your Answer is: " + actualAnswer);
            System.out.println("  The correct answer is: " + expectedAnswer + "\n");
            return 1;
        } else {
            System.out.println("Test [" + testName + "] Passed!\n");
            return 0;
        }
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with a very small rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testEncryptWithSmallPositiveRotation() {
        // Input
        String message1 = "menu";

        // Do the test
        String encrypted1 = CaesarWithBugs.encrypt(message1, 2);

        // Validate
        String encryptedAnswer = "ogpw";
        return testCase("EncryptWithSmallPositiveRotation",
                message1, encryptedAnswer, encrypted1, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a very small rotation,
     * Then we do not get the expected code
     *
     * @return int
     */
    public static int testDecryptWithSmallPositiveRotation() {
        String encrypted2 = "ogpw";
        String messageAnswer = "menu";
        String message2 = CaesarWithBugs.decrypt(encrypted2, 2);

        return testCase("DecryptWithSmallPositiveRotation",
                encrypted2, messageAnswer, message2, "decrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with a very large rotation,
     * Then we do not get the expected code
     *
     * @return int
     */
    public static int testEncryptWithLargePositiveRotation() {
        // Input
        String text = "menu";
        final int LARGE_NUMBER = 2147483647;
        // Test Encryption
        String encryptedText = CaesarWithBugs.encrypt(text, LARGE_NUMBER);
        // Validate
        String encryptedSolution = "jbkr";
        return testCase("EncryptWithLargePositiveRotation",
                text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a very large rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testDecryptWithLargePositiveRotation() {
        final int LARGE_NUMBER = 2147483647;
        String encryptedText = "jbkr";
        String decryptedSolution = "menu";
        String decryptedText = CaesarWithBugs.decrypt(encryptedText, LARGE_NUMBER);

        return testCase("DecryptWithLargePositiveRotation",
                encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with a very small negative rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testEncryptWithSmallNegativeRoatation() {
        // Input
        String text = "menu";
        final int SMALL_NEG_NUMBER = -2;
        // Test Encryption
        String encryptedText = CaesarWithBugs.encrypt(text, SMALL_NEG_NUMBER);
        // Validate
        String encryptedSolution = "kcls";
        return testCase("EncryptWithSmallNegativeRotation",
                text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a very small negative rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testDecryptWithSmallNegativeRotation() {
        final int SMALL_NEG_NUMBER = -2;
        String encryptedText = "kcls";
        String decryptedSolution = "menu";
        String decryptedText = CaesarWithBugs.decrypt(encryptedText, SMALL_NEG_NUMBER);

        return testCase("DecryptWithSmallNegativeRotation",
                encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with a very large negative rotation,
     * Then we do not get the expected code
     *
     * @return int
     */
    public static int testEncryptWithLargeNegativeRotation() {
        // Input
        String text = "menu";
        final int LARGE_NEG_NUMBER = -2147483647;
        // Test Encryption
        String encryptedText = CaesarWithBugs.encrypt(text, LARGE_NEG_NUMBER);
        // Validate
        String encryptedSolution = "phqx";
        return testCase("EncryptWithLargeNegativeRotation",
                text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a very large negative rotation,
     * Then we do not get the expected code
     *
     * @return int
     */
    public static int testDecryptWithLargeNegativeRotation() {
        final int LARGE_NEG_NUMBER = -2147483647;
        String encryptedText = "phqx";
        String decryptedSolution = "menu";
        String decryptedText = CaesarWithBugs.decrypt(encryptedText, LARGE_NEG_NUMBER);

        return testCase("DecryptWithLargeNegativeRotation",
                encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message with A's and Z's,
     * When we encrypt the message,
     * Then we do not get the expected code
     *
     * @return
     */
    public static int testEncryptWithAandZ() {
        // Input
        String text = "AaZz";
        final int ROTATION_NUM = 2;
        // Test Encryption
        String encryptedText = CaesarWithBugs.encrypt(text, ROTATION_NUM);
        // Validate
        String encryptedSolution = "CcBb";
        return testCase("EncryptWithAandZ",
                text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message whose decryption should have A's and Z's
     * When we decrypt the message,
     * Then we get the expected code
     *
     * @return
     */
    public static int testDecryptWithAandZ() {
        final int ROTATION_NUM = 2;
        String encryptedText = "CcBb";
        String decryptedSolution = "AaZz";
        String decryptedText = CaesarWithBugs.decrypt(encryptedText, ROTATION_NUM);

        return testCase("DecryptWithAandZ",
                encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with upper case letters,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testEncryptWithUpperCaseLetters() {
        // Input
        String text = "MeNu";
        final int ROTATION_NUM = 2;
        // Test Encryption
        String encryptedText = CaesarWithBugs.encrypt(text, ROTATION_NUM);
        // Validate
        String encryptedSolution = "OgPw";
        return testCase("EncryptWithUpperCaseLetters",
                text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a upper case letters,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testDecryptWithUpperCaseLetters() {
        final int ROTATION_NUM = 2;
        String encryptedText = "OgPw";
        String decryptedSolution = "MeNu";
        String decryptedText = CaesarWithBugs.decrypt(encryptedText, ROTATION_NUM);

        return testCase("DecryptWithUpperCaseLetters",
                encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty message of symbols,
     * When we encrypt the message,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testEncryptWithSymbols() {
        // Input
        String text = "[\\]^_`";
        final int ROTATION_NUM = 2;
        // Test Encryption
        String encryptedText = CaesarWithBugs.encrypt(text, ROTATION_NUM);
        // Validate
        String encryptedSolution = "[\\]^_`";
        return testCase("EncryptWithSymbols",
                text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty message of symbols,
     * When we decrypt the message,
     * Then we do not get the expected code
     *
     * @return int
     */
    public static int testDecryptWithSymbols() {
        final int ROTATION_NUM = 2;
        String encryptedText = "[\\]^_`";
        String decryptedSolution = "[\\]^_`";
        String decryptedText = CaesarWithBugs.decrypt(encryptedText, ROTATION_NUM);

        return testCase("DecryptWithSymbols",
                encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given an empty message,
     * When we encrypt the message,
     * Then we do not get the expected code
     *
     * @throws StringIndexOutOfBoundsException
     * @return int
     */
    public static int testEncryptWithEmptyString() {
        try {
            // Input
            String text = "";
            final int ROTATION_NUM = 2;
            // Test Encryption
            String encryptedText = CaesarWithBugs.encrypt(text, ROTATION_NUM);
            // Validate
            String encryptedSolution = "";
            return testCase("EncryptWithEmptyString",
                    text, encryptedSolution, encryptedText, "encrypt");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Test [\"EncryptWithEmptyString\"] FAILED (\"encrypt\")");
            System.out.println("  Given message to encrypt is: \"\"");
            System.out.println("  Your Answer is: StringIndexOutOfBoundsException");
            System.out.println("  The correct answer is: \"\"\n");
            return 1;
        }
    }

    /**
     * Given an empty message,
     * When we decrypt the message,
     * Then we get the expected code
     *
     * @throws StringIndexOutOfBoundsException
     * @return int
     */
    public static int testDecryptWithEmptyString() {
        try {
            final int ROTATION_NUM = 2;
            String encryptedText = "";
            String decryptedSolution = "";
            String decryptedText = CaesarWithBugs.decrypt(encryptedText, ROTATION_NUM);

            return testCase("DecryptWithEmptyString",
                    encryptedText, decryptedSolution, decryptedText, "decrypt");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Test [\"DecryptWithEmptyString\"] FAILED (\"decrypt\")");
            System.out.println("  Given message to decrypt is: \"\"");
            System.out.println("  Your Answer is: StringIndexOutOfBoundsException");
            System.out.println("  The correct answer is: \"\"\n");
            return 1;
        }
    }

    /**
     * The main method to test the Caesar class.
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        System.out.println("Part2Tester");
        System.out.println("===============================================================");
        /** The main method. THIS IS WHERE YOU SHOULD ADD TESTS TO FIND
         * THE ERRORS IN CeasarWithBugs.  We have a few tests, but they
         * do not expose the errors.
         **/

        //The Caesar Cipher With Bugs Tests
        int failCases = 0;

        //Tests Small Rotation (provided code)
        failCases += testEncryptWithSmallPositiveRotation();
        failCases += testDecryptWithSmallPositiveRotation();

        //Tests Large Rotation (my code)
        failCases += testEncryptWithLargePositiveRotation(); //fails - Error 1.1
        failCases += testDecryptWithLargePositiveRotation(); //fails - Error 1.2

        //Tests Small Negative Rotation (my code)
        failCases += testEncryptWithSmallNegativeRoatation();
        failCases += testDecryptWithSmallNegativeRotation();

        //Tests Large Negative Rotation (my code)
        failCases += testEncryptWithLargeNegativeRotation(); //fails - Error 2.1
        failCases += testDecryptWithLargeNegativeRotation(); //fails - Error 2.2

        //Tests for Edges, A and Z (my code)
        failCases += testEncryptWithAandZ(); //fails - Error 3
        failCases += testDecryptWithAandZ();

        //Tests Uppercase Letters (my code)
        failCases += testEncryptWithUpperCaseLetters();
        failCases += testDecryptWithUpperCaseLetters();

        //Tests Symbols (my code)
        failCases += testEncryptWithSymbols();
        failCases += testDecryptWithSymbols(); //fails - Error 4

        //Tests Empty Strings (my code)
        failCases += testEncryptWithEmptyString(); //fails - Error 5
        failCases += testDecryptWithEmptyString();


        //Messages that print whether tests were successful or not
        if (failCases == 0) {
            System.out.println("ALL Tests Passed! :D");
        } else {
            System.out.println("Some tests failed! :( Number of Failed Test Cases : " + failCases);
        }
    }
}
