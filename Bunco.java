import java.util.*;

/**
 * Manages the play for the dice game Bunco
 *
 * @author Shiva Ganapathy
 * @author Atiya Rulianto
 */

public class Bunco {
    /** Minimum Dice Value*/
    public static final int DICE_MIN = 6;
    
    /** Maximum Dice Value*/
    public static final int DICE_MAX = 26;

    /**
     * Main method where the Bunco game is played
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Time to play Bunco! \n");
        System.out.println("How many people are playing?");
        int players = 0;

        try {
            players = scnr.nextInt();
        } catch (Exception e) {
            System.out.print("Invalid input");
            System.exit(1);
        }

        if (players < 1 || players > 10) {
            System.out.println("You can't have that many players!");
            System.exit(1);
        }

        System.out.print("How many sides do your dice have?");
        int dice = 0;
        try {
            dice = scnr.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Input");
            System.exit(1);
        }

        if (dice < DICE_MIN) {
            System.out.println("Your dice needs at least six sides!");
            System.exit(1);
        } else if (dice > DICE_MAX) {
            System.out.println("Your dice should have a maximum of 26 sides!");
            System.exit(1);
        }

        Player[] arr = new Player[players];
        for (int i = 0; i < players; i++) {
            System.out.print("Player " + (i + 1) + ": Enter your name: ");
            String name;
            name = scnr.next();
            int invalidName = 0;
            try {
                invalidName = Integer.parseInt(name);
                System.out.println("Invalid Name");
                System.exit(1);
            } catch (Exception e) {
                arr[i] = new Player(name, dice);
            }
        }

        Dice dice1 = new Dice(dice);
        Dice dice2 = new Dice(dice);
        Dice dice3 = new Dice(dice);
        Round play = new Round(arr, dice1, dice2, dice3);
        play.game();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}