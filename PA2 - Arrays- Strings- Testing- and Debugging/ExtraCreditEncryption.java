import java.util.*;

public class ExtraCreditEncryption {
    private static Scanner scn = new Scanner(System.in);
    private static char userAnswer;
    private static String userPhrase;
    private static int userInt;

    public static void main(String[] args) {
        userAnswer = '0';
        do {
            System.out.println("MonoAlphabetic Encryption (Enter 1): \n" +
                    "MonoAlphabetic Decryption (Enter 2): \n" +
                    "PolyAlphabetic Encryption (Enter 3): \n" +
                    "PolyAlphabetic Decryption (Enter 4): \n" +
                    "Quit Program (Enter Q)");
            userAnswer = scn.next().charAt(0);
            switch (userAnswer) {
                case '1':
                    System.out.println("Enter a phrase to encrypt: ");
                    userPhrase = readInput(scn);
                    System.out.println("Enter a rotation key: ");
                    userInt = scn.nextInt();
//                    monoAlphabeticEncrypt(userPhrase, userInt);
                    break;
                case '2':
                    System.out.println("Enter a phrase to encrypt: ");
                    userPhrase = readInput(scn);
                    System.out.println("Enter a rotation key: ");
                    userInt = scn.nextInt();
//                    monoAlphabeticDecrypt(userPhrase, userInt);
                    break;
                case '3':
                    System.out.println("Enter a phrase to encrypt: ");
                    userPhrase = readInput(scn);
                    System.out.println("Enter a rotation key: ");
                    userInt = scn.nextInt();
//                    polyAlphabeticEncrypt(userPhrase, userInt);
                    break;
                case '4':
                    System.out.println("Enter a phrase to encrypt: ");
                    userPhrase = readInput(scn);
                    System.out.println("Enter a rotation key: ");
                    userInt = scn.nextInt();
//                    polyAlphabeticDecrypt(userPhrase, userInt);
                    break;
                case 'q':
                    System.out.println("Enter a phrase to encrypt: ");
                    userPhrase = readInput(scn);
                    System.out.println("Enter a rotation key: ");
                    userInt = scn.nextInt();
                    System.out.println("\nCypher Program Ended. Exiting...");
                    break;
                default:
                    break;
            }
        } while (("" + userAnswer).toLowerCase().equals("q"));
    }

//    private static String monoAlphabeticEncrypt(String toEncrypt, int rotation) {
//        String
//    }
//
//    private static String monoAlphabeticDecrypt(String toDecrypt, int rotation) {
//
//    }
//
//    private static String polyAlphabeticEncrypt(String toEncrypt, int rotation) {
//
//    }
//
//    private static String polyAlphabeticDecrypt(String toDecrypt, int rotation) {
//
//    }

    //Helper methods
    private static String readInput(Scanner scanner) {
        String inputText = "";

        while (scanner.hasNext()) {
            inputText = inputText.concat(scanner.next());
        }
        return inputText;
    }
}
