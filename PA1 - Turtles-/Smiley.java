public class Smiley {
    public static void main(String[] args) {
        // Make a new turtle with the default symbol (*)
        ASCIITurtle myTurtle = new ASCIITurtle();

        // draw the smiley face as instructed in the PSA instructions.

        //Draws the first line of the face (hair)
        myTurtle.makeSpace(3);
        myTurtle.setSymbol('|');
        myTurtle.draw(3);

        //Draws the second line of the face (forehead)
        myTurtle.newline();
        myTurtle.makeSpace(2);
        myTurtle.setSymbol('*');
        myTurtle.draw(5);

        //Draws the third line of the face (sides of the face, eyes)
        myTurtle.newline();
        myTurtle.draw(1);
        myTurtle.makeSpace(1);
        myTurtle.setSymbol('x');
        myTurtle.draw(1);
        myTurtle.makeSpace(3);
        myTurtle.draw(1);
        myTurtle.makeSpace(1);
        myTurtle.setSymbol('*');
        myTurtle.draw(1);

        //Draws the fourth line of the face (sides of the face, nose)
        myTurtle.newline();
        myTurtle.draw(1);
        myTurtle.makeSpace(3);
        myTurtle.setSymbol('>');
        myTurtle.draw(1);
        myTurtle.makeSpace(3);
        myTurtle.setSymbol('*');
        myTurtle.draw(1);

        //Draws the fifth line of the face (sides of the face, mouth)
        myTurtle.newline();
        myTurtle.makeSpace(1);
        myTurtle.draw(1);
        myTurtle.setSymbol('\\');
        myTurtle.draw(1);
        myTurtle.setSymbol('_');
        myTurtle.draw(3);
        myTurtle.setSymbol('/');
        myTurtle.draw(1);
        myTurtle.setSymbol('*');
        myTurtle.draw(1);

        //Draws the sixth line of the face (chin)
        myTurtle.newline();
        myTurtle.makeSpace(3);
        myTurtle.draw(3);
    }
}
