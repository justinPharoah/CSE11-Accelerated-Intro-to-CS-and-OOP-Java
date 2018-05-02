/**
 * DrawCenteredLineTest Class
 * Tests the DrawCenteredLine method in ASCIITurtle.java
 *
 * Filename: DrawCenteredLineTest.java
 * Created by: cs11sbm
 * Date: April 10, 2018
 */
public class DrawCenteredLineTest {
    //The line below is magic, you don't have to understand it (yet)
    public static void main(String[] args) {
        //Create a new ASCIITurtle below
        ASCIITurtle myTurtle = new ASCIITurtle();

        myTurtle.drawCenteredLine(10, '&'); //tests even lengths
        myTurtle.drawCenteredLine(15, '$'); //tests odd lengths
        myTurtle.drawCenteredLine(40, '*'); //tests maximum length
        myTurtle.drawCenteredLine(0, '@'); //tests minimum length
    }
}
