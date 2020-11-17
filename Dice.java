import java.util.*;

/**
 * Represents a single dice for the game Bunco
 *
 * @author Shiva Ganapathy
 * @author Atiya Rulianto
 */

public class Dice {

    /** Number of sides the dice being used has*/
    private int numberofSides;

    /**
     * Constructor for the dice class that sets the type of die being used
     *
     * @param numberofSides the number of sides the dice being used has
     * @throws IllegalStateException when the dice type is invalid
     */
    public Dice(int numberofSides) {
        if (numberofSides < Bunco.DICE_MIN || numberofSides > Bunco.DICE_MAX) {
            throw new IllegalStateException("Invalid dice type");
        }

        this.numberofSides = numberofSides;
    }

    /**
     * Getter method for the number of sides on the dice
     *
     * @return the number of sides on the dice
     */
    public int getNumberOfSides() {
        return numberofSides;
    }

    /**
     * Represents the dice being rolled
     *
     * @return the side the dice rolled on
     */
    public int rollDice() {
        Random r = new Random();
        int rolledSide = r.nextInt(numberofSides) + 1;
        return rolledSide;
    }
}