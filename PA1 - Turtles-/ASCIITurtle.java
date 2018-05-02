
/**
 * A simple "Turtle" class that draws text "art" to the screen
 */
public class ASCIITurtle {
    // The current symbol to be drawn
    private char symbol;

    /**
     * Make a new ASCIITurtle with the default symbol *
     */
    public ASCIITurtle() {
        symbol = '*';
    }

    /**
     * Make a new ASCIITurtle with the specified symbol
     *
     * @param s The symbol to be drawn
     */
    public ASCIITurtle(char s) {
        symbol = s;
    }

    /**
     * Draw numSymbols number of the current symbol
     */
    public void draw(int numSymbols) {
        for (int i = 0; i < numSymbols; i++) {
            System.out.print(symbol);
        }
    }

    /**
     * Move the cursor to the right by numSpaces
     */
    public void makeSpace(int numSpaces) {
        for (int i = 0; i < numSpaces; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Move the cursor to the next line
     */
    public void newline() {
        System.out.print("\t\n");
    }

    /**
     * Change the symbol drawn
     *
     * @param newSymbol The new symbol
     */
    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }

    /////////////////// student-defined methods ///////////////////////

    /**
     * drawCenteredLine - Draws a centered (in a 40-char width field)
     * line of the given length and the given symbol.
     *
     * @param length
     * @param symbolToUse
     *
     * @return void
     */
    public void drawCenteredLine(int length, char symbolToUse) {
        final int numSpaces = 40 - length; //total number of spaces within the line

        setSymbol('|');
        draw(1);
        if (length % 2 == 0) { //even number of symbols to draw
            makeSpace(numSpaces / 2);
            setSymbol(symbolToUse);
            draw(length);
            makeSpace(numSpaces / 2);
        } else { //odd number of symbols to draw
            makeSpace(numSpaces / 2); //if numSpaces is 25, will draw 12 spaces
            setSymbol(symbolToUse);
            draw(length);
            makeSpace((numSpaces / 2) + 1); //if numSpaces is 25, will draw 13 spaces
        }
        setSymbol('|');
        draw(1);
        newline();
    }
}
