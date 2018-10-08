/**
 * @author Justin Ferrell (cs11sbm)
 * @PID A14437143
 * @date 4/20/18
 * @about This file, Caesar.java, is a program that
 *      implements three different methods of
 *      executing a Caesar encryption and decryption.
 */

import java.io.*;
import java.util.*;

/**
 * Name: Caesar Class
 * Purpose: Executes three different methods of
 *      Caesar Encryption and Decryption:
 *      Strings, char arrays, String Builders
 */
public class Caesar {

    /**
     * Helper method that takes in a single character
     * and rotates it the given rotation. Only executes
     * the rotation on alphabetic characters.
     *
     * @param a char to be rotated
     * @param rotation number of rotations
     * @return char that has been rotated
     */
    private static char letterOperation(char a, int rotation) {
        char encryptVal = a;

        if (encryptVal >= 'a' && encryptVal <= 'z') {
            int postModVal = (encryptVal % 26) - ('a' % 26) + (rotation % 26);
            postModVal = postModVal >= 0 ? postModVal % 26 : (postModVal % 26) + 26;
            encryptVal = (char) ('a' + postModVal);
        } else if (encryptVal >= 'A' && encryptVal <= 'Z') {
            int postModVal2 = (encryptVal % 26) - ('A' % 26) + (rotation % 26);
            postModVal2 = postModVal2 >= 0 ? postModVal2 % 26 : (postModVal2 % 26) + 26;
            encryptVal = (char) ('A' + postModVal2);
        } else return a;

        return encryptVal;
    }

    /**
     * Encrypts a String, given a rotation, using Strings
     *
     * @param s String to be encrypted
     * @param rotation number of rotations
     * @return String that has been encrypted
     */
    public static String encryptStr(String s, int rotation) {
        String encryptedStr = "";
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            encryptedStr += "" + letterOperation(temp, rotation);
        }
        return encryptedStr;
    }

    /**
     * Decrypts a String, given a rotation, using Strings
     *
     * @param s String to be decrypted
     * @param rotation number of rotations
     * @return String that has been decrypted
     */
    public static String decryptStr(String s, int rotation) {
        String decryptedStr = "";
        rotation = 26 - rotation;
        char temp;

        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            decryptedStr += "" + letterOperation(temp, rotation);
        }

        return decryptedStr;
    }

    /**
     * Encrypts a String, given a rotation, using char Arrays
     *
     * @param s String to be encrypted
     * @param rotation number of rotations
     * @return String that has been encrypted
     */
    public static String encryptChArr(String s, int rotation) {
        String encryptedStr;
        char[] encryptArray = s.toCharArray();
        char[] resultArray = new char[encryptArray.length];

        for (int i = 0; i < encryptArray.length; i++) {
            resultArray[i] = letterOperation(encryptArray[i], rotation);
        }

        encryptedStr = String.copyValueOf(resultArray);
        return encryptedStr;
    }

    /**
     * Decrypts a String, given a rotation, using char Arrays
     *
     * @param s String to be decrypted
     * @param rotation number of rotations
     * @return String that has been decrypted
     */
    public static String decryptChArr(String s, int rotation) {
        String decryptedStr;
        rotation = 26 - rotation;
        char[] decryptArray = s.toCharArray();
        char[] resultArray = new char[decryptArray.length];

        for (int i = 0; i < decryptArray.length; i++) {
            resultArray[i] = letterOperation(decryptArray[i], rotation);
        }

        decryptedStr = String.copyValueOf(resultArray);
        return decryptedStr;
    }

    /**
     * Encrypts a String, given a rotation, using String Builders
     *
     * @param s String to be encrypted
     * @param rotation number of rotations
     * @return String that has been encrypted
     */
    public static String encryptSB(String s, int rotation) {
        StringBuilder encryptedStr = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            encryptedStr.replace(i, i + 1, "" + letterOperation(encryptedStr.charAt(i), rotation));
        }

        return encryptedStr.toString();
    }

    /**
     * Decrypts a String, given rotation, using String Builders
     *
     * @param s String to be decrypted
     * @param rotation number of rotations
     * @return String that has been decrypted
     */
    public static String decryptSB(String s, int rotation) {
        StringBuilder decryptedStr = new StringBuilder(s);
        rotation = 26 - rotation;

        for (int i = 0; i < s.length(); i++){
            decryptedStr.replace(i, i + 1, "" + letterOperation(decryptedStr.charAt(i), rotation));
        }

        return decryptedStr.toString();
    }
}
