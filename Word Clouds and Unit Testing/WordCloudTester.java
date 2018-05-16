/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date 4/27/2018
 * @about File name: WordCloudTester.java , a file which contains
 *      the class used to test the methods within WordCloud.java
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * WordCloudTester class
 *
 * Defines the methods use to test the methods of WordCloud.
 */
public class WordCloudTester {
    private static int testNum;

    /**
     * Main Method used to execute Unit Tester methods
     *
     * NOTE: If you plan on throw Exceptions, you need to change "IOException" to "Exception"
     * IOExceptions are a specific set of Exceptions.
     */
    public static void main(String[] args) throws IOException {
        WordCloudTester wct = new WordCloudTester();
        // This tester uses the command line. That's why the args are passed to the method
        // wct.providedTester(args);

        WordCloud wc = new WordCloud();
        System.out.println("ArrayList after reading in file: ");
        wc.getWordsFromFile("harry_potter.txt");


        for(WordPair wp : wc.getList()) {
            System.out.print(wp + " ");
        }
        System.out.println();

        testFileReading();

        System.out.println("\nArrayList after removing common words: ");
        wc.removeCommon("commonWords.txt");

        for(WordPair wp : wc.getList()) {
            System.out.print(wp + " ");
        }
        System.out.println();

        testCorrectWordsRemoved();

        System.out.println("\nArrayList with top N words with certain length: ");
        wc.topNWords(10, 7);

        for (WordPair wp : wc.topNWords(10, 7)) {
            System.out.print(wp.getWord() + "(" + wp.getCount() + ")  ");
        }
        System.out.println();


        testCorrectLengthTopNWords();
        System.out.println("\nArrayList with top N words starting with beginsWith: ");
        wc.topNWords(10, 's');

        for (WordPair wp : wc.topNWords(10, 's')) {
            System.out.print(wp.getWord() + "(" + wp.getCount() + ")  ");
        }
        System.out.println("\nTests: ");

        testCorrectStartTopNWords();

        System.out.println();
        wc.findWordCount("harry");

        testCorrectWordCount();

        wc.printWords(wc.getList(), true);

        testFileWriting();

    } // End Main Method

    /**
     * Tests the file reading method for
     *      - correct file being read in
     *      - safeguards against non-existing files
     *      - file read in correctly
     *      - correctly reads in various files
     * @throws IOException Error in file handling
     * @return void
     */
    public static void testFileReading() throws IOException {
        //correct file read in or file exists or not
        //file read in correctly
        //read in files besides provided ones
    }

    /**
     * Tests Word Count method for
     *      - case insensitivity
     *      - punctuation affecting count
     * @return void
     */
    public static void testCorrectWordCount() {
        //test case insensitivity
        //test punctuation affecting count differences
        WordCloud wc = new WordCloud();
        System.out.println("Count should be 0. It is..." +
            wc.findWordCount("the"));
    }

    /**
     * Tests Word Removal method for
     *      - case insensitivity
     *      - punctuation affecting removal
     * @return void
     */
    public static void testCorrectWordsRemoved() {
        //test case insensitivity
        //test punctuation affecting words removed
    }

    /**
     * Tests for correct list of top
     * n words based on length
     * @return void
     */
    public static void testCorrectLengthTopNWords() {

    }

    /**
     * Tests for correct list of top
     * n words starting with a specific character
     *      - case insensitivity
     *      - punctuation affect
     * @return void
     */
    public static void testCorrectStartTopNWords() {
        //test case insensitivity
        //test punctuation affect
        WordCloud wc = new WordCloud();
        ArrayList<WordPair> expectedList = new ArrayList<>();
        expectedList.add(new WordPair("son"));
        expectedList.addAll(Arrays.asList(new WordPair("son"),
                new WordPair("sister"),
                new WordPair("sat"),
                new WordPair("shooting"),
                new WordPair("strange"),
                new WordPair("small"),
                new WordPair("sister,"),
                new WordPair("son,"),
                new WordPair("street"),
                new WordPair("sign")));

        int failCount = 0;
        for (int i = 0; i < expectedList.size(); i++) {
            if (wc.topNWords(10, 's') != null && !wc.topNWords(10, 's')
                    .get(i).toString2().equals(expectedList.get(i).toString2())) {
                failCount++;
            }
        }
        testNum++;
        if (failCount != 0) {
            System.out.println("Test " + testNum + " Failed (Top N Words with given length)");
            System.out.println("Your Answer is: " + wc.topNWords(10, 's'));
            System.out.println("The correct answer is: " + expectedList + "\n");
        } else {
            System.out.println("Test " + testNum + " Passed!");
        }
    }

    /**
     * Tests if file writing method correctly
     * writes to specified file and also if the
     * written file will also read in correctly
     * @return void
     */
    public static void testFileWriting() {
        //written file also reads in correctly
    }

    /**
     * Write more unit tests above this provided tester
     */


    /**
     * WordCloudTester
     *
     * Class to test a WordCloud.  The class expects two command line arguments:
     * argument[0] is filename
     * argument[1] is numberOfTopNWords, where numberOfTopNWords is the number of commonly occurring words to print
     * argument[2] is console or file, where if you type console, it prints it to the console else prints to a file
     * argument[3] is length or char, where if you type length, the next argument will be the value of length, else next
     * argument will be the character
     * argument[4] is the value of either length or character based on previous argument
     * Note that it expects a file with common word occurrences named "commonWords.txt"
     *
     * Author: Ujjwal Gulecha 10/05/2016
     */
    public static void providedTester(String[] args) throws IOException {

        // Command line usage:
        // java WordCloudTester nameOfInputFile.txt numberOfTopNWords {console|file} {length|char} {value}

        // init the word cloud
        WordCloud w = new WordCloud();
        System.out.println("Reading in File: " + args[0]);
        w.getWordsFromFile(args[0]);

        System.out.println("Removing common words");
        w.removeCommon("commonWords.txt");

        // get the input number of words you want
        int numberOfTopNWords = Integer.parseInt(args[1]);

        // condition ? a : b => if (condition == true) then a else b
        // parse the second argument to check if it is printToFile or not
        boolean printToFile = args[2].charAt(0) == 'f' ? true : false;
        // parse the third argument to check if it is filter by lengh or not
        boolean filterByLength = args[3].charAt(0) == 'l' ? true : false;
        int lengthValue = 0;
        char charValue = 'a';

        if (filterByLength) {
            lengthValue = Integer.parseInt(args[4]);
        } else {
            charValue = args[4].charAt(0);
        }

        System.out.println("Printing the top " + numberOfTopNWords + " words filtered by " + (filterByLength ?
                "length >= " + lengthValue : "starting with character " + charValue) + (printToFile == true ?
                " in file a named myOutput.out" : " on console"));
        w.printWords(filterByLength == true ? w.topNWords(numberOfTopNWords, lengthValue)
                : w.topNWords(numberOfTopNWords, charValue), printToFile);
    }
}



