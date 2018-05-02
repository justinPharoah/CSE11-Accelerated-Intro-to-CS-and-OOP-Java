public class Warmup {
    public static void main(String[] args) {
        // Make a new turtle with the default symbol (*)
        ASCIITurtle myTurtle = new ASCIITurtle();

//        myTurtle.draw(3);
//        myTurtle.makeSpace(2);
//        myTurtle.draw(5);
//        myTurtle.newline();
//        myTurtle.setSymbol('0');  // enclose characters in single quotes
//        myTurtle.makeSpace(3);
//        myTurtle.draw(4);

        //Code modification as specified at the start of PA1
        myTurtle.setSymbol('-');
        myTurtle.draw(5);
        for (int i = 0; i < 2; i++) {
            myTurtle.newline();
            myTurtle.setSymbol('*');
            myTurtle.draw(1);
            myTurtle.makeSpace(3);
            myTurtle.draw(1);
        }
        myTurtle.newline();
        myTurtle.setSymbol('-');
        myTurtle.draw(5);
    }

}
