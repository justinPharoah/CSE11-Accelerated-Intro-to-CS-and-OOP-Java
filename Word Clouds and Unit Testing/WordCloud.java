/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date 4/27/2018
 * @about This file contains
 */

import java.util.*;
import java.io.*;

/**
 * WordCloud class
 */
public class WordCloud {

    // The ArrayList to store the words and their associated counts
    ArrayList<WordPair> list;
    Map<String, Integer> mapList;

    /**
     * Default no-arg constructor
     * Initializes the ArrayList list
     */
    public WordCloud() {
        list = new ArrayList<>();
        mapList = new HashMap<>();
    }

    /**
     * Reads in all the unique words from the given source file
     * and properly updates the list and tracks each words frequency
     *
     * @param filename String filename
     * @throws IOException Error handling the file
     */
    public void getWordsFromFile(String filename) throws IOException {
        Scanner scnr = new Scanner(new File(filename));
        while (scnr.hasNext()) {
            String currentWord = scnr.next();
            if(mapList.containsKey(currentWord)) {
                int count = mapList.get(currentWord);
                mapList.put(currentWord, count + 1);
            } else {
                mapList.put(currentWord, 1);
            }
        }

        ArrayList<String> wordList = new ArrayList<>(mapList.keySet());
        Collections.sort(wordList);

        for (String word : wordList) {
            WordPair wp = new WordPair(word);
            list.add(wp);
            Integer freq = mapList.get(word);
            list.get(list.indexOf(wp)).setCount(freq);
        }
    }

    /**
     * Accessor method used by the tester file
     * to access WordCloud's ArrayList
     *
     * @return ArrayList containing the read in WordPairs
     */
    public ArrayList<WordPair> getList() {
        return list;
    }

    /**
     * Searches the ArrayList list for a specified word
     * and returns that words frequency
     *
     * @param word word to find in the list
     * @return int frequency of the searched for word
     */
    public int findWordCount(String word) {
        WordPair toFind = new WordPair(word);
        WordPair lowCaseToFind = new WordPair(word.toLowerCase());
        if (list.isEmpty() || !list.contains(toFind)) {
            return 0;
        } else {
            /* Ensures that the word count is case insensitive
             * (i.e. the count for apple is the count of (apple + Apple)
             */
            int count = list.get(list.indexOf(toFind)).getCount();
            int lowCaseCount = list.get(list.indexOf(lowCaseToFind)).getCount();
            return count + lowCaseCount;
        }
    }

    /**
     * Removes any commonly used words from the list
     * specified by a read in file.
     *
     * Uses a lamda expression (functionals) to filter out
     * any common words in the read in file.
     *
     * @param omitFilename String filename
     * @throws IOException Error handling the file
     */
    public void removeCommon(String omitFilename) throws IOException {
        Scanner scnr = new Scanner(new File(omitFilename));
        while (scnr.hasNext()) {
            WordPair toRemove = new WordPair(scnr.next());
            list.removeIf(n -> n.equals(toRemove)); // functional - removes words if they are found in omitFilename
        }
    }

    /**
     * Finds the top n occurring words with lengths >= length
     * and returns it in an ArrayList. First occurring word
     * with specified count is used in event of a tie.
     *
     * Uses lambda expressions (functionals) to remove any
     * words not within the specified constraints, and then
     * uses a loop to find the top n occurrences.
     *
     * @param n top n occurring words to find
     * @param length length that all words should be
     * @return ArrayList with the top n occurrences
     */
    public ArrayList<WordPair> topNWords(int n, int length) {
        ArrayList<WordPair> topNList = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>(mapList.keySet());

        temp.removeIf(i -> i.length() < length); //functional - removes words shorter than length
        temp.sort(Comparator.comparingInt(String::length));

        if (temp.isEmpty()) { //returns null if list is empty
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                String currWord = temp.get(i);
                WordPair wp = new WordPair(currWord);
                topNList.add(wp);
                Integer freq = mapList.get(currWord);
                topNList.get(i).setCount(freq);
            }
        }

        return topNList;
    }

    /**
     * Finds the top n occurring words in the list with the
     * starting character = beginsWith and returns it as an ArrayList.
     * The first occurring word is used in the event of a tie
     *
     * Uses lambda expressions (functionals) to remove words not
     * within the specified constraints, and then uses a loop
     * to find the top n occurrences
     *
     * @param n top n occurring words to find
     * @param beginsWith character that all words should begin with
     * @return ArrayList with the top n occurrences
     */
    public ArrayList<WordPair> topNWords(int n, char beginsWith) {
        ArrayList<WordPair> temp = list;
        ArrayList<WordPair> topNList = new ArrayList<>();
        temp.removeIf(i -> i.toString2().charAt(0) != beginsWith); //functional - removes all words not beginning with beginsWith

        if (temp.isEmpty()) { //returns null if list is empty
            return null;
        } else {
            temp.sort(WordPair::compareTo); //sorts the list into increasing frequencies of words beginning with beginsWith
            int i = 0;
            while (topNList.size() <= n){
                if (!topNList.contains(temp.get(i))) {
                    topNList.add(temp.get(i)); //adds words with top n frequencies to resulting list
                }
                i++;
            }
        }

        return topNList;
    }

    /**
     * Takes an ArrayList of WordPairs and if printToFile is true,
     * will output the list to a file myOutput.out.
     * If printToFile is false, will output the list to the console
     *
     * @param wordList List of WordPairs to be outputted
     * @param printToFile boolean determines what to do with the list
     * @throws IOException Error handling the file
     */
    public void printWords(ArrayList<WordPair> wordList, boolean printToFile) throws IOException {
        //Complete this method TODO
        PrintWriter pw = new PrintWriter(new FileWriter("myOutput.out"));
        if (!printToFile) {

        } else {
            for (WordPair wp : wordList) {
                pw.println(wp.toString());
            }
        }
        pw.close();
    }
}
