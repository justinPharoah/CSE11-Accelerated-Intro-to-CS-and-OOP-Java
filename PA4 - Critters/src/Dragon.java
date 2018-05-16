/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date May 11, 2018
 * @about File name: Dragon.java
 *      Defines the functionality of a Dragon
 *      Dragon extends Critter and eats, fights, and moves
 */

import java.awt.Color;
import java.util.Random;

/**
 * Dragon class
 * Dragon is a type of Critter that:
 *      Eats whenever it encounters food
 *      First attacks randomly, then uses Roars against Bears,
 *          Pounces against Lions, and Scratches otherwise
 *      Changes color: Black if eaten even times, White if odd
 *      Moves in a diamond like rotation
 */
public class Dragon extends Critter {
    private Attack dragonAttack;
    private Color dragonColor;
    private Direction dragonDirection;
    private String dragonString;
    private Random randNum;
    private int eatCount;
    private String previousOpponent = "";
    private int turnCount;

    /**
     * No-arg default constructor for the Dragon class
     */
    public Dragon() {
        randNum = new Random();
        dragonAttack = chooseAttack();
        dragonColor = Color.BLACK;
        dragonDirection = Direction.WEST;
        dragonString = "D";
        eatCount = 0;
        turnCount = 0;
    }

    /**
     * Overrides the Critter eat method
     * The Dragon always eats,
     * and also keeps track of how much it eats
     *
     * @return if the Dragon will eat
     */
    @Override
    public boolean eat() {
        eatCount++;
        return true;
    }

    /**
     * Overrides the Critter fight method
     * Determines the attack method of the Dragon
     * Attacks with Roar if previous opponent was a Bear
     * Attacks with Pounce if previous opponent was a Lion
     * Attacks with Scratch otherwise
     *
     * @param opponent Used to keep track of previous opponent
     * @return Form of attack
     */
    @Override
    public Attack fight(String opponent) {
        switch (previousOpponent) {
            case "":
                break;
            case "B":
                dragonAttack = Attack.ROAR;
                break;
            case "L":
                dragonAttack = Attack.POUNCE;
                break;
            default:
                dragonAttack = Attack.SCRATCH;
                break;
        }
        previousOpponent = opponent;
        return dragonAttack;
    }

    /**
     * Overrides the Critter getColor method
     * Dragon is Black if it has eaten an even number of times
     * White if it has eaten an odd number of times
     *
     * @return Dragon's color
     */
    @Override
    public Color getColor() {
        dragonColor = eatCount % 2 == 0 ? Color.BLACK : Color.WHITE;
        return dragonColor;
    }

    /**
     * Overrides the Critter getMove method
     * Moves in a diamond-like pattern as defined in lab writeup
     *
     * @return Direction the Dragon will move in
     */
    @Override
    public Direction getMove() {
        if (turnCount < 10) {
            if (turnCount % 2 == 0) {
                dragonDirection = Direction.WEST;
            } else {
                dragonDirection = Direction.SOUTH;
            }
            turnCount++;
        } else if (turnCount < 20) {
            if (turnCount % 2 == 0) {
                dragonDirection = Direction.SOUTH;
            } else {
                dragonDirection = Direction.EAST;
            }
            turnCount++;
        } else if (turnCount < 30) {
            if (turnCount % 2 == 0) {
                dragonDirection = Direction.EAST;
            } else {
                dragonDirection = Direction.NORTH;
            }
            turnCount++;
        } else if (turnCount < 40) {
            if (turnCount % 2 == 0) {
                dragonDirection = Direction.NORTH;
            } else {
                dragonDirection = Direction.WEST;
            }
            turnCount++;
        } else {
            turnCount = 0;
        }
        return dragonDirection;
    }

    /**
     * Overrides the Critter toString method
     * Determines the String representation for the Dragon
     *
     * @return Dragon's String representation
     */
    @Override
    public String toString() {
        return dragonString;
    }

    /**
     * Helper method
     * Chooses a random attack for the Dragon to use
     *
     * @return randomized method of Attack
     */
    private Attack chooseAttack() {
        int random = randNum.nextInt(3) + 1;
        switch (random) {
            case 1:
                return Attack.ROAR;
            case 2:
                return Attack.SCRATCH;
            case 3:
                return Attack.POUNCE;
            default:
                return Attack.FORFEIT;
        }
    }
}
