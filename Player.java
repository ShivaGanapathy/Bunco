/**
 * Represents a single player for the game Bunco
 *
 * @author Shiva Ganapathy
 * @author Atiya Rulianto
 */

public class Player {

    /** Number of sides the dice being used*/
    private static int numberofSides;

    /** Name of a player*/
    private String playerName;

    /** Total score a player has*/
    private int totalScore;

    /** Current score a player has for a round*/
    private int roundScore;

    /** Total amount of rounds won*/
    private int roundsWon;

    /** Total of little Buncos a player had*/
    private int littleBunco;

    /** Total of big Buncos a player had*/
    private int bigBunco;

    /**
     * Constructor for creating one player for the Bunco game
     *
     * @param playerName name of the player
     * @param sides number of sides the dice being used has
     * @throws IllegalStateException when sides is less than 6 or greater than 26
     */
    public Player(String playerName, int sides) {
        if (sides < Bunco.DICE_MIN || sides > Bunco.DICE_MAX) {
            throw new IllegalStateException("Invalid dice type");
        }

        this.playerName = playerName;
        this.totalScore = 0;
        this.roundScore = 0;
        this.roundsWon = 0;
        this.littleBunco = 0;
        this.bigBunco = 0;
        this.numberofSides = sides;
    }

    /**
     * Returns player's name
     * @return player's name
     */
    public String getName() {
        return playerName;
    }

    /**
     * Returns a player's round score
     * @return a player's round score
     */
    public int getRoundScore() {
        return roundScore;
    }

    /**
     * Updates the current score a player has during a round
     *
     * @param roundPoints number of points a player gains in a round
     */
    public void addRoundScore(int roundPoints) {
        roundScore += roundPoints;
        totalScore += roundPoints;
    }

    /**
     * Updates the current number of big buncos a player has
     *
     */
    public void addBigBunco() {
        bigBunco += 1;
    }

    /**
     * Updates the current number of little buncos a player has
     *
     */
    public void addLittleBunco() {
        littleBunco += 1;
    }

    /**
     * Updates the current number of rounds won a player has
     *
     */
    public void addRoundsWon() {
        roundsWon += 1;
    }

    /**
     * Resets the number of points a player has in a round
     */
    public void resetRoundScore() {
        roundScore = 0;
    }

    /**
     * Converts the player information to a String
     * @return String of player information
     */
    @Override
    public String toString() {
        String s = "";
        s += "~~~~~~~~~~~~~~~~~~~~";
        s += "Player Summary for " + this.playerName + ": \n";
        s += "Total points: " + this.totalScore + "\n";
        s += "Total Rounds Won: " + this.roundsWon + "\n";
        s += "Total Big Buncos: " + this.bigBunco + "\n";
        s += "Total Little Buncos: " + this.littleBunco + "\n";
        return s;
    }
}