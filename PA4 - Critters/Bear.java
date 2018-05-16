/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date May 11, 2018
 * @about File name: Bear.java
 *      Defines the functionality for the Bear.
 *      Bear extends Critter and eats, fights, and moves
 */

import java.awt.Color;

/**
 * Bear class
 * Bear is a type of Critter that:
 *      Eat if it has not eaten since it has fought
 *      Attacks with Scratch only
 *      Move in a zig-zag pattern
 */
public class Bear extends Critter {
    private boolean grizzly;
    private boolean eatBehavior;
    private Attack attackType;
    private Direction currentDirection;
    private String bearString;
    private int directionCount;

    /**
     * One-arg constructor for the Bear class
     *
     * @param grizzly bear is a grizzly bear or a polar bear
     */
    public Bear(boolean grizzly) {
        this.grizzly = grizzly;
        eatBehavior = true;
        attackType = Attack.SCRATCH;
        directionCount = 0;
        bearString = "B";
    }

    /**
     * Overrides the Critter eat method
     * The Bear will always eat
     *
     * @return Whether or not Bear will eat
     */
    @Override
    public boolean eat() {
        return eatBehavior;
    }

    /**
     * Overrides the Critter fight method
     * Bear always attacks with Scratch
     *
     * @param opponent The Bear's opponent
     * @return Bears attack method
     */
    @Override
    public Attack fight(String opponent) {
        return attackType;
    }

    /**
     * Overrides the Critter getColor method
     * Determines the color of the Bear
     *
     * @return Bear color
     */
    @Override
    public Color getColor() {
        return grizzly ? new Color(190, 110, 50) : Color.WHITE;
    }

    /**
     * Overrides the Critter getMove method
     * Determines how the Bear will move
     * Bear moves in a zig-zag, South-East pattern
     *
     * @return direction the Bear will move
     */
    @Override
    public Direction getMove() {
        if (directionCount == 0) {
            currentDirection = Direction.SOUTH;
            directionCount = 1;
        } else {
            currentDirection = Direction.EAST;
            directionCount = 0;
        }
        return currentDirection;
    }

    /**
     * Overrides the Critter toString method
     * Determines the Bear's string representation
     *
     * @return Bear's string representation
     */
    @Override
    public String toString() {
        return bearString;
    }
}
