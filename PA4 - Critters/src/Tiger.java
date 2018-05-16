/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date May 11, 2018
 * @about File: Tiger.java
 *      Defines the functionality for the Tiger.
 *      Tiger extends Critter and eats, fights, and directions
 */

import java.awt.Color;
import java.util.Random;

/**
 * Tiger class
 * Tiger is a type of Critter that:
 *      Eat if hungry
 *      Attack with Scratch if hungry, Pounce if not
 *      Move randomly every three directions
 */
public class Tiger extends Critter {
    private int hunger;
    private Color tigerColor;
    private Direction tigerDirection;
    private Random randNum;
    private int moveCount = 0;
    private int random = 0;
    private Direction [] directions = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};


    /**
     * One-arg constructor for the Tiger class
     * @param hunger How hungry the Tiger is
     */
    public Tiger(int hunger) {
        this.hunger = hunger;
        tigerColor = Color.YELLOW;
        tigerDirection = Direction.NORTH;
        randNum = new Random();
    }

    /**
     * Overrides the Critter eat method
     * The Tiger will eat if still hungry
     * and will not eat after they eat their fill
     *
     * @return Whether or not Tiger will eat
     */
    @Override
    public boolean eat() {
        if (hunger > 0){
            hunger--;
            return true;
        } else return false;
    }

    /**
     * Overrides the Critter fight method
     * Determines the attack method of the Tiger
     * Attacks with Scratch if hungry
     * Attacks with Pounce if not hungry
     *
     * @param opponent the Tiger's current enemy
     * @return the method of Attack the Tiger uses
     */
    @Override
    public Attack fight(String opponent) {
        return hunger > 0 ? Attack.SCRATCH : Attack.POUNCE;
    }

    /**
     * Overrides the Critter getColor method
     * Determines the color of the Tiger
     *
     * @return Tiger color
     */
    @Override
    public Color getColor() {
        return tigerColor;
    }

    /**
     * Overrides the Critter getMove method
     * Determines how the Tiger will move
     * Tiger randomly changes direction every 3 directions
     *
     * @return direction the Tiger will move
     */
    @Override
    public Direction getMove() {
        if(moveCount > 2){
            tigerDirection = directions[randNum.nextInt(directions.length)];
            moveCount = 0;
        }
        moveCount++;
        return tigerDirection;
    }

    /**
     * Overrides the Critter toString method
     * Determines the Tiger's string representation
     * Tiger represented by its hunger
     *
     * @return Tiger's string
     */
    @Override
    public String toString() {
        return String.valueOf(hunger);
    }
}
