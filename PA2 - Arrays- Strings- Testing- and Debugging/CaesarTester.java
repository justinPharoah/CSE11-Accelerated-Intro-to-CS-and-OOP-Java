/**
 * @author Justin Ferrell
 * @login cs11sbm
 * @PID A14437143
 * @date  4/20/2018
 * @about This file, CaesarTester.java, is used to test
 *      Caesar.java using basic strings and rotation values.
 */

/**
 * CaesarTester class
 *
 * Used to test Caesar.java for correct output.
 */
public class CaesarTester {

    private static int testNum = 0;  // Keep track of which test we're running

    /**
     * Checks the test case to see if it's correct
     *
     * @param message The message to encrypt or decrypt
     * @param expectedAnswer The answer expected
     * @param actualAnswer The actual answer produced
     * @param enc_or_dec A string specifying what function was tested.
     * @return 1 if the test failed, and 0 otherwise.
     */
    public static int testCase(String message, String expectedAnswer,
                               String actualAnswer, String enc_or_dec) {
        testNum++;
        if (!expectedAnswer.equals(actualAnswer)) {
            System.out.println("Test " + testNum + " Failed (" +
                    enc_or_dec + ")");
            System.out.println("Given message to " + enc_or_dec + " is: "
                    + message);
            System.out.println("Your Answer is: " + actualAnswer);
            System.out.println("The correct answer is: " + expectedAnswer + "\n");
            return 1;
        } else {
            System.out.println("Test " + testNum + " Passed!\n");
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
        String text = "menu";

        // Do the test
        String encryptedText = Caesar.encryptStr(text, 2);

        // Validate
        String encryptedSolution = "ogpw";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a very small rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testDecryptWithSmallPositiveRotation() {
        String encryptedText = "ogpw";
        String decryptedSolution = "menu";
        String decryptedText = Caesar.decryptStr(encryptedText, 2);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with a very large rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testEncryptWithLargePositiveRotation() {
        // Input
        String text = "menu";
        final int LARGE_NUMBER = 2147483647;
        // Test Encryption
        String encryptedText = Caesar.encryptStr(text, LARGE_NUMBER);
        // Validate
        String encryptedSolution = "jbkr";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
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
        String decryptedText = Caesar.decryptStr(encryptedText, LARGE_NUMBER);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
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
        String encryptedText = Caesar.encryptStr(text, SMALL_NEG_NUMBER);
        // Validate
        String encryptedSolution = "kcls";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
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
        String decryptedText = Caesar.decryptStr(encryptedText, SMALL_NEG_NUMBER);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we encrypt the message with a very large negative rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testEncryptWithLargeNegativeRotation() {
        // Input
        String text = "menu";
        final int LARGE_NEG_NUMBER = -2147483647;
        // Test Encryption
        String encryptedText = Caesar.encryptStr(text, LARGE_NEG_NUMBER);
        // Validate
        String encryptedSolution = "phqx";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty plain message,
     * When we decrypt the message with a very large negative rotation,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testDecryptWithLargeNegativeRotation() {
        final int LARGE_NEG_NUMBER = -2147483620;
        String encryptedText = "qiry";
        String decryptedSolution = "menu";
        String decryptedText = Caesar.decryptStr(encryptedText, LARGE_NEG_NUMBER);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given a non-empty plain message with A's and Z's,
     * When we encrypt the message,
     * Then we get the expected code
     *
     * @return
     */
    public static int testEncryptWithAandZ() {
        // Input
        String text = "AaZz";
        final int ROTATION_NUM = 2;
        // Test Encryption
        String encryptedText = Caesar.encryptStr(text, ROTATION_NUM);
        // Validate
        String encryptedSolution = "CcBb";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
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
        String decryptedText = Caesar.decryptStr(encryptedText, ROTATION_NUM);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
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
        String encryptedText = Caesar.encryptStr(text, ROTATION_NUM);
        // Validate
        String encryptedSolution = "OgPw";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
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
        String decryptedText = Caesar.decryptStr(encryptedText, ROTATION_NUM);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
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
        String encryptedText = Caesar.encryptStr(text, ROTATION_NUM);
        // Validate
        String encryptedSolution = "[\\]^_`";
        return testCase(text, encryptedSolution, encryptedText, "encrypt");
    }

    /**
     * Given a non-empty message of symbols,
     * When we decrypt the message,
     * Then we get the expected code
     *
     * @return int
     */
    public static int testDecryptWithSymbols() {
        final int ROTATION_NUM = 2;
        String encryptedText = "[\\]^_`";
        String decryptedSolution = "[\\]^_`";
        String decryptedText = Caesar.decryptStr(encryptedText, ROTATION_NUM);

        return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Given an empty message,
     * When we encrypt the message,
     * Then we get the expected code
     *
     * @throws StringIndexOutOfBoundsException
     * @return int
     */
    public static int testEncryptWithEmptyString() {
            // Input
            String text = "";
            final int ROTATION_NUM = 2;
            // Test Encryption
            String encryptedText = Caesar.encryptStr(text, ROTATION_NUM);
            // Validate
            String encryptedSolution = "";
            return testCase(text, encryptedSolution, encryptedText, "encrypt");
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
            final int ROTATION_NUM = 2;
            String encryptedText = "";
            String decryptedSolution = "";
            String decryptedText = Caesar.decryptStr(encryptedText, ROTATION_NUM);

            return testCase(encryptedText, decryptedSolution, decryptedText, "decrypt");
    }

    /**
     * Tests Self-Written cases to determine if
     * the 3 encryption/decryption methods fail in
     * various circumstances.
     *
     * @return int number of failed tests
     */
    private static int testAllCases() {
        int failCases = 0;

        failCases += testEncryptWithSmallPositiveRotation();
        failCases += testDecryptWithSmallPositiveRotation();

        failCases += testEncryptWithLargePositiveRotation();
        failCases += testDecryptWithLargePositiveRotation();

        failCases += testEncryptWithSmallNegativeRoatation();
        failCases += testDecryptWithSmallNegativeRotation();

        failCases += testEncryptWithLargeNegativeRotation();
        failCases += testDecryptWithLargeNegativeRotation();

        failCases += testEncryptWithAandZ();
        failCases += testDecryptWithAandZ();

        failCases += testEncryptWithUpperCaseLetters();
        failCases += testDecryptWithUpperCaseLetters();

        failCases += testEncryptWithSymbols();
        failCases += testDecryptWithSymbols();

        failCases += testEncryptWithEmptyString();
        failCases += testDecryptWithEmptyString();

        return failCases;
    }

    /**
     * Main method to call methods in Caesar and test them
     *
     * @param args Unused
     * @return void
     */
    public static void main(String[] args) {

        /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
         * FOR encrypt and decrypt methods AND ANY OTHER METHOD
         * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
         **/

        //The Caesar Cipher Tests
        int failCases = 0;

        // Avoid magic numbers for constants
        final int ENC_ROTATION = 17;
        final int DEC_ROTATION = -58;

        String message1 = "When in the course of human events it becomes necessary for one people to" +
                " dissolve the political bands which have connected them with another and to" +
                " assume among the powers of the earth the separate and equal station to" +
                " which the laws of nature and of nature's God entitle them a decent respect" +
                " to the opinions of mankind requires that they should declare the causes" +
                " which impel them to the separation.";

        String encryptedAnswer = "Nyve ze kyv tflijv fw yldre vmvekj zk svtfdvj evtvjjrip " +
                "wfi fev gvfgcv kf uzjjfcmv kyv gfczkztrc sreuj nyzty yrmv tfeevtkvu kyvd nzky refkyvi" +
                " reu kf rjjldv rdfex kyv gfnvij fw kyv vriky kyv jvgrirkv reu vhlrc jkrkzfe kf nyzty " +
                "kyv crnj fw erkliv reu fw erkliv'j Xfu vekzkcv kyvd r uvtvek ivjgvtk kf kyv fgzezfej fw" +
                " drebzeu ivhlzivj kyrk kyvp jyflcu uvtcriv kyv trljvj nyzty zdgvc kyvd kf kyv jvgrirkzfe.";

        System.out.println("***** PART A TESTS ******\n");

        //Test 1
        String encrypted1 = Caesar.encryptStr(message1, ENC_ROTATION);
        failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

        //Test 2
        String encrypted2 = "Byffi yhwlsjncih qilfx, byffi yhwlsjncih qilfx";
        String messageAnswer = "Hello encryption world, hello encryption world";
        String message2 = Caesar.decryptStr(encrypted2, DEC_ROTATION);
        failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

        //Tests 3 - 18
        failCases += testAllCases();

        System.out.println("\n***** PART B TESTS *******\n");

        //Test 19
        encrypted1 = Caesar.encryptChArr(message1, ENC_ROTATION);
        failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

        //Test 20
        message2 = Caesar.decryptChArr(encrypted2, DEC_ROTATION);
        failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

        //Tests 21 - 36
        failCases += testAllCases();

        System.out.println("\n***** PART C TESTS *******\n");

        //Test 37
        encrypted1 = Caesar.encryptSB(message1, ENC_ROTATION);
        failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

        //Test 38
        message2 = Caesar.decryptSB(encrypted2, DEC_ROTATION);
        failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

        //Tests 39 - 55
        failCases += testAllCases();

        //Messages that print whether tests were successful or not
        if (failCases == 0) {
            System.out.println("All Tests Passed!");
        } else {
            System.out.println("Number of Failed Test Cases : " + failCases);
        }
    }
}
