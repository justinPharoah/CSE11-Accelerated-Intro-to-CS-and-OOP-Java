/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date 4/27/2018
 * @about WordPair.java file holds a class to store two elements, a String and an int,
 *      for a WordCloud program.  The String is the word that appears in the test and the
 *      int is the number of occurrences
 *
 *  Previous Author: Ujjwal Gulecha 10/05/2016
 */

/**
 * WordPair class
 *
 * Stores a WordPair object as a String and a int. The String is the word that
 * appears in the test and the int is the number of occurrences
 */
public class WordPair {

    private String word;
    private int count;

    // take in a word and setup its count at 1

    /**
     * WordPair one-arg constructor
     * Takes in a word a setup its count at 1
     *
     * @param w String input
     */
    public WordPair(String w) {
        word = w;
        count = 1;
    }

    // getters

    /**
     * Accessor Method which gets the current
     * word as a String
     *
     * @return String word
     */
    public String getWord() {
        return word;
    }

    /**
     * Accessor Method which gets the current
     * count of a word as an int
     *
     * @return int count (frequency of current word)
     */
    public int getCount() {
        return count;
    }

    // common use for count should be to just increment

    /**
     * Increments the instance variable count,
     * the frequency of the current word
     *
     * @return void
     */
    public void increment() {
        count++;
    }

    // provided in case count may be useful to change manually

    /**
     * Mutator Method sets the current count
     *
     * @param c new number for count
     */
    public void setCount(int c) {
        count = c;
    }

    // print word and count

    /**
     * Used to print out the word and count
     * of a WordPair
     *
     * @return String information
     */
    public String toString() {
        return word + " : " + count;
    }

    /**
     * Custom toString method which returns
     * the String word of a WordPair object
     *
     * @return String current word
     */
    public String toString2() {
        return word;
    }

    /**
     * Compares the frequencies of two different
     * WordPairs
     *
     * @param wordPair wordPair to compare with current WordPair
     * @return int larger or smaller frequency
     */
    public int compareTo(WordPair wordPair) {
        if (wordPair.getCount() == this.getCount()) {
            return wordPair.toString2().compareTo(word);
        } else if (wordPair.getCount() > this.getCount()) {
            return 1;
        } else
            return -1;
    }

    /**
     * Determines if the Strings of two WordPair objects
     * are the same
     *
     * @param wordPair wordPair to be compared for equality
     * @return boolean true or false
     */
    public boolean equals(WordPair wordPair) { return word.equals(wordPair.getWord()); }
}
