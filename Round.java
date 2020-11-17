import java.util.*;

/**
 * Represents a round being played
 *
 * @author Shiva Ganapathy
 * @author Atiya Rulianto
 */

public class Round {
    /** Clubs stored as a character value*/
    public static final int BIG_BUNCO = 5;
    
    /** Clubs stored as a character value*/
    public static final int LITTLE_BUNCO = 3;

    /** An array for all the players in a game*/
    private Player[] players;

    /** The first dice being used*/
    private Dice dice1;

    /** The second dice being used*/
    private Dice dice2;

    /** The third dice being used*/
    private Dice dice3;

    /**
     * This is a constructor for the round that sets the 3 dice and all the
     * players included
     *
     * @param players Array of players in the game
     * @param dice1 first dice used
     * @param dice2 second dice used
     * @param dice3 third dice used
     */
    public Round(Player[] players, Dice dice1, Dice dice2, Dice dice3) {
        this.players = players;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.dice3 = dice3;
    }

    /**
     * Method called when a game is started
     */
    public void game() {
        for (int i = 0; i < dice1.getNumberOfSides(); i++) {
            System.out.println("\nRound " + (i + 1));
            System.out.println("~~~~~~~~~");
            for (int j = 0; j < players.length; j++) {
                //roll all three dice
                boolean turn = true;
                while (turn) {
                    Scanner scnr = new Scanner(System.in);
                    System.out.print(players[j].getName() + ": Type anything to start rolling.");
                    scnr.next();
                    int[] results = new int[] {
                        dice1.rollDice(), dice2.rollDice(), dice3.rollDice()
                    };
                    String s = players[j].getName() + ": Rolled a ";
                    s += results[0] + " " + results[1] + " " + results[2];
                    System.out.println(s);

                    turn = addPoints(results, i + 1, players[j]);
                }

            }
            roundSummary(players);


        }
    }

    /**
     * Adds points the player after each round
     *
     * @param results Array of the sides rolled by the dice
     * @param round the current round the players are on
     * @param player the current player who is in the game
     * @return boolean of whether the turn is still active
     * @throws IllegalStateException when the round is below 0
     */
    public boolean addPoints(int[] results, int round, Player player) {

        if (round < 0) {
            throw new IllegalStateException("Cannot have a round below 1");
        }

        int first = results[0];
        int second = results[1];
        int third = results[2];
        int points = 0;

        //if it is a bunco of some sort
        if ((first == second) && (second == third)) {
            //if it is a big bunco
            if (first == round) {
                System.out.println("Big Bunco! \n");
                points += BIG_BUNCO;
                player.addBigBunco();
            }
            //if it is a little bunco
            else {
                System.out.println("Little Bunco! \n");
                points += LITTLE_BUNCO;
                player.addLittleBunco();
            }
        }
        //if it is not a bunco
        else {
            if ((first == round)) {
                points += 1;
            }
            if ((second == round)) {
                points += 1;
            }
            if ((third == round)) {
                points += 1;
            }
        }

        if (points == 0) {
            System.out.println("Next Turn! \n");
            return false;
        } else {
            System.out.println("Roll Again! \n");
            player.addRoundScore(points);
            return true;
        }
    }

    /**
     * Displays points each player has at the end of a round and finds winner
     * @param players array of all the players in a game
     */
    public void roundSummary(Player[] players) {
        String s = "(Round Summary - ";
        boolean tie = false;
        int index = 1;
        int max = 0;
        for (int i = 0; i < players.length; i++) {
            s += players[i].getName() + ":" + players[i].getRoundScore() + " ";
            if (players[i].getRoundScore() > max) {
                index = i;
                max = players[i].getRoundScore();
                tie = false;
            } else if (players[i].getRoundScore() == max) {
                tie = true;
            }
            players[i].resetRoundScore();
        }
        s += ")\n";
        if (!tie) {
            players[index].addRoundsWon();
            s += players[index].getName() + " Wins The Round.";
        } else {
            s += " No Winner This Round.";
        }
        System.out.println(s);

    }
}