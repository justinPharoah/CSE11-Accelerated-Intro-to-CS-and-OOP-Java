/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date May 11, 2018
 * @about File name: Lion.java
 *      Defines the functionality for the Lion.
 *      Lion extends Critter and eats, fights, and directions
 */

import java.awt.Color;

/**
 * Tiger class
 * Tiger is a type of Critter that:
 *      Eat if it has not eaten since it has fought
 *      Attacks with Roar if against a Bear, Pounce otherwise
 *      Move in a square pattern
 */
public class Lion extends Critter {
    private boolean hasFought;
    private Color lionColor;
    private String lionString;
    private Direction lionDirection;
    private int moveCount = 0;
    private int squareMoves = 0;

    public static final int LION_MOVES = 5;
    private Direction [] directions = {Direction.SOUTH, Direction.WEST, Direction.NORTH, Direction.EAST};



    /**
     * No-arg default Constructor for the Lion class
     */
    public Lion() {
        lionColor = Color.RED;
        hasFought = false;
        lionString = "L";
        lionDirection = Direction.SOUTH;
    }

    /**
     * Overrides the Critter eat method
     * The Lion will eat
     * if it has not eaten since it has fought
     *
     * @return Whether or not Lion will eat
     */
    @Override
    public boolean eat() {
        if (hasFought) {
            hasFought = false;
            return true;
        } else return false;
    }

    /**
     * Overrides the Critter fight method
     * Determines the attack method of the Lion
     * Attacks with Roar if facing a bear
     * Attacks with Pounce otherwise
     *
     * @param opponent the Lion's current enemy
     * @return the method of Attack the Lion uses
     */
    @Override
    public Attack fight(String opponent) {
        hasFought = true;
        return opponent.equals("B") ? Attack.ROAR : Attack.POUNCE;
    }

    /**
     * Overrides the Critter getColor method
     * Determines the color of the Lion
     *
     * @return Lion color
     */
    @Override
    public Color getColor() {
        return lionColor;
    }

    /**
     * Overrides the Critter getMove method
     * Determines how the Lion will move
     * Lion directions in a square pattern
     * Turns every five directions
     *
     * @return direction the Lion will move
     */
    @Override
    public Direction getMove() {
        squareMoves = LION_MOVES * directions.length - 1;
        if(moveCount > squareMoves) moveCount = 0;
        moveCount++;
        return directions[(moveCount-1) / LION_MOVES];
    }

    /**
     * Overrides the Critter toString method
     * Determines the Lion's string representation
     *
     * @return Lion's string representation
     */
    @Override
    public String toString() {
        return lionString;
    }
}
