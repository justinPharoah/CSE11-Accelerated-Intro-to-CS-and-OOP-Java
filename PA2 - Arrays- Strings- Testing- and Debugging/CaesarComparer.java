/**
 * @author Justin Ferrell (cs11sbm)
 * @PID A14437143
 * @date 4/20/18
 * @about This file, CaesarComparer.java, is used
 */

import java.io.*;
import java.util.*;

/**
 * Name: CaesarComparer Class
 * Purpose:
 */
public class CaesarComparer {
    /**
     * The main method to to test Caesar.java
     *
     * @param args Unused
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final int num = 50000;
        String s = "";
        Scanner scanner = new Scanner(new FileReader("odyssey_shortened.txt"));
        while (scanner.hasNext()) {
            s = s + Caesar.encryptStr(scanner.nextLine(), 48);
        }
        if (args[0].equalsIgnoreCase("encryptStr")) {
            Caesar.encryptStr(s, 48);
        }
        if (args[0].equalsIgnoreCase("decryptStr")) {
            Caesar.decryptStr(s, 48);
        }
        if (args[0].equalsIgnoreCase("encryptChArr")) {
            Caesar.encryptChArr(s, 48);
        }
        if (args[0].equalsIgnoreCase("decryptChArr")) {
            Caesar.decryptChArr(s, 48);
        }
        if (args[0].equalsIgnoreCase("encryptSB")) {
            Caesar.encryptSB(s, 48);
        }
        if (args[0].equalsIgnoreCase("decryptSB")) {
            Caesar.decryptSB(s, 48);
        }
    }
}
