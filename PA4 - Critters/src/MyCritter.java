/**
 * @author Justin Ferrell - cs11sbm
 * @PID A14437143
 * @date May 11, 2018
 * @about File name: MyCritter.java
 *      Defines the functionality for Thanos.
 *      Thanos extends Critter and eats, fights, and moves
 */

import java.awt.*;
import java.util.Random;

/**
 * Dragon class
 * Dragon is a type of Critter that:
 *      Eats whenever it encounters food
 *      Attacks based on the opponents it faces and
 *      Changes color: Black if eaten even times, White if odd
 *      Moves in a diamond like rotation
 */
public class MyCritter extends Critter { //I AM THANOS
    private Attack thanosAttack;
    private Direction thanosDirection;
    private Color thanosColor;
    private String thanosString;
    private Random randNum;

    /**
     * No-arg default constructor for the MyCritter class
     */
    public MyCritter() {
        randNum = new Random();
        thanosAttack = randomAttack();
        thanosColor = new Color(109, 54, 120);
        thanosString = "0";
    }

    /**
     * Overrides the Critter eat method
     * Thanos never eats
     * He is immortal and kills all, eats none
     *
     * @return if Thanos will eat
     */
    @Override
    public boolean eat() {
        return false;
    }

    /**
     * Overrides the Critter fight method
     * Determines the attack method of the Dragon
     * Attacks each opponent with what it is weakest against
     * Attacks bots with a random attack
     *
     * @param opponent Thanos' current opponent
     * @return Attack Thanos will use
     */
    @Override
    public Attack fight(String opponent) {
        if (Character.isDigit(opponent.charAt(0))) opponent = "T";

        switch (opponent) {
            case "B":
                thanosAttack = Attack.ROAR;
                break;
            case "L":
                thanosAttack = Attack.SCRATCH;
                break;
            case "D":
                thanosAttack = Attack.ROAR;
                break;
            case "T":
                try {
                    int num = Integer.parseInt(opponent);
                    thanosAttack = num > 0 ? Attack.ROAR : Attack.SCRATCH;
                } catch (NumberFormatException nfe) {
                    thanosAttack = randomAttack();
                }
                break;
            default:
                thanosAttack = randomAttack();
                break;
        }
        return thanosAttack;
    }

    /**
     * Overrides the Critter getColor method
     *
     * @return Thanos' color
     */
    @Override
    public Color getColor() {
        return thanosColor;
    }

    /**
     * Overrides the Critter getMove method
     * Thanos hunts down all of its enemies using the
     * Critter getNeighbor method
     * Uses random movements if nothing is around him
     * Thanos has no mercy
     *
     * @return Direction Thanos will move in
     */
    @Override
    public Direction getMove() {
        String northEnemy = getNeighbor(Direction.NORTH);
        String southEnemy = getNeighbor(Direction.SOUTH);
        String eastEnemy = getNeighbor(Direction.EAST);
        String westEnemy = getNeighbor(Direction.WEST);

            if (northEnemy.equals("B")) {
                thanosDirection = Direction.NORTH;
            } else if (southEnemy.equals("B")) {
                thanosDirection = Direction.SOUTH;
            } else if (eastEnemy.equals("B")) {
                thanosDirection = Direction.EAST;
            } else if (westEnemy.equals("B")) {
                thanosDirection = Direction.WEST;
            } else if (northEnemy.equals("L")) {
                thanosDirection = Direction.NORTH;
            } else if (southEnemy.equals("L")) {
                thanosDirection = Direction.SOUTH;
            } else if (eastEnemy.equals("L")) {
                thanosDirection = Direction.EAST;
            } else if (westEnemy.equals("L")) {
                thanosDirection = Direction.WEST;
            } else if (northEnemy.equals("D")) {
                thanosDirection = Direction.NORTH;
            } else if (southEnemy.equals("D")) {
                thanosDirection = Direction.SOUTH;
            } else if (eastEnemy.equals("D")) {
                thanosDirection = Direction.EAST;
            } else if (westEnemy.equals("D")) {
                thanosDirection = Direction.WEST;
            } else thanosDirection = randomMove();

        return thanosDirection;
    }

    /**
     * Overrides the Critter toString method
     * Determines the String representation for Thanos
     * Thanos is '0' because he is smart asf and
     * disguises himself as a Tiger that isn't hungry
     * because Thanos figured out that being '0' works
     * best against the Hard bot
     *
     * @return Thanos' String representation
     */
    @Override
    public String toString() {
        return thanosString;
    }

    /**
     * Helper method
     * Chooses a random attack when necessary for Thanos
     *
     * @return randomized form of Attack
     */
    private Attack randomAttack() {
        int random = randNum.nextInt(3) + 1;
        switch (random) {
            case 1:
                return Attack.ROAR;
            case 2:
                return Attack.SCRATCH;
            case 3:
                return Attack.POUNCE;
            default:
                return Attack.ROAR;
        }
    }

    /**
     * Helper method
     * Chooses a random move when necessary for Thanos
     *
     * @return randomized direction
     */
    private Direction randomMove() {
        int random = randNum.nextInt(4) + 1;
        switch (random) {
            case 1:
                return Direction.NORTH;
            case 2:
                return Direction.SOUTH;
            case 3:
                return Direction.EAST;
            case 4:
                return Direction.WEST;
            default:
                return Direction.CENTER;
        }
    }
}
