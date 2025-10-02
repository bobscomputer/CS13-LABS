/* 
 * Name:       Lynn Castro
 * 
 * Course:     CS-13, Fall 2025
 *
 * Date:       09/07/25
 *
 * Filename:   GameCastro.java
 *
 * Purpose:    Demonstrate understanding of Random class, Scanner class, Conditions, 
 *             loops, Math class, printf, and type casting by creating a game.
 * 
 * Proper naming: All variable and method names are descriptive and meaningful > 5
 * Indentation: Code is organized and readable > 5
 * Comments: All methods and general flow of program is explained with a comment > 5
 * Program compiles: Program compiles in JGrasp > 25
 * Program runs and matches provided output: Program runs in JGrasp > 30
 * Requirements: Program follows all requirements except some method comments from the shell were removed/changed > 20
 * Self grade: I included a self-grade in the header > 5
 * Total self grade score: 95/100
 */

import java.util.*;
public class GameCastro {
    public static void main(String [] args) {
        Start();
    } // end of main

    // getting random digitSize value from 3-6 inclusively
    public static int GetDigitSize(Random rand) {
        int digitSize;

        digitSize = rand.nextInt(3,7); // 3-6 inclusively
        return digitSize;
    }

    // gets 2 random int values based on a given digit size
    public static int BigNumbers(Random rand, int digitSize) {
        int bigNumber = 0;

        // for digit size of 3
        if(digitSize == 3) {
            bigNumber = rand.nextInt(100, 999); // 100-999

        }

        // for digit size of 4
        else if(digitSize == 4) {
            bigNumber = rand.nextInt(1000, 9999); // 1000-9999
        }

        // for digit size of 5
        else if(digitSize == 5) {
            bigNumber = rand.nextInt(10000, 99999); // 10000-99999
        }

        // for digit size of 6
        else {
            bigNumber = rand.nextInt(100000, 999999); // 100000-999999
        }

        return bigNumber;
    }

    // Compares two int values to check for matching digit values
    public static int CountMatched(int n1, int n2) {
        int matchTotal;
        int counter;
        String matchedNumbers = "Digits matched: ";

        // container variables for comparing
        String stringHolder1 = Integer.toString(n1);
        String stringHolder2 = Integer.toString(n2);
        int [] arrayHolder1 = new int[stringHolder1.length()];
        int [] arrayHolder2 = new int[stringHolder2.length()];
        // keeps track of matched values to prevent repeats, indices 0-9 represent digits 0-9
        boolean [] matchedValues = new boolean[10]; 

        // initialize counter value before updating in for loop
        counter = 0;

        // gets each digit from both numbers and inserts each digit into an array
        for(int i = arrayHolder1.length-1; i >= 0; i--) {

            // gets last digit, 6th digit
            if(counter==0) {
                arrayHolder1[i] = (n1 % 10);
                arrayHolder2[i] = (n2 % 10);
                counter++;
            }

            // gets second to last digit, 5th digit
            else if (counter==1) {
                arrayHolder1[i] = (n1 / 10) % 10;
                arrayHolder2[i] = (n2 / 10) % 10;
                counter++;
            }

            // gets third to last digit, 4th digit
            else if (counter==2) {
                arrayHolder1[i] = (n1 / 100) % 10;
                arrayHolder2[i] = (n2 / 100) % 10;
                counter++;
            }

            // gets fourth to last digit, 3th digit
            else if (counter==3) {
                arrayHolder1[i] = (n1 / 1000) % 10;
                arrayHolder2[i] = (n2 / 1000) % 10;
                counter++;
            }

            // gets fifth to last digit, 2nd digit
            else if (counter==4) {
                arrayHolder1[i] = (n1 / 10000) % 10;
                arrayHolder2[i] = (n2 / 10000) % 10;
                counter++;
            }

            // gets first digit, 1st digit
            else if (counter==5) {
                arrayHolder1[i] = (n1 / 100000);
                arrayHolder2[i] = (n2 / 100000);
                counter++;
            }
        }
        counter = 0; // reset counter

        matchTotal = 0; // initialize matchTotal before updating in for loop

        // compares each element from the arrays to find a matching digit, prevents repeat matches
        // ex) if '2' appears twice in both digits, only count '2' as ONE match
        for(int i=0; i<arrayHolder1.length; i++) {
            for(int j=0; j<arrayHolder2.length; j++) {
                    // match found
                    if ( (arrayHolder1[i] == arrayHolder2[j]) && (!matchedValues[arrayHolder2[j]]) ) {
                        matchedValues[arrayHolder2[j]] = true;
                        matchTotal++;
                        matchedNumbers += arrayHolder2[j] + " ";  
                    }

                    // else, no match, do nothing
            }
        } 
        
        // display matched results
        System.out.println(matchTotal + " total matches");
        System.out.println(matchedNumbers);
        return matchTotal;
    }

    // starts the execution of the game/program
    public static void Start() {
        int totalScore = 0; 
        int round = 0;
        Scanner kb = new Scanner(System.in);   
        Random rand = new Random();
        String answer = "";
        boolean more = true;

        //
        Directions();
        System.out.print("\nWhat is your name? > ");
        String name = kb.nextLine();
        System.out.println("\nHello " + name + ", lets start playing!\n");

        //
        while(more) {
            System.out.print("Hit enter to play or press q/Q to quit > ");
            answer = kb.nextLine();

            // check if user quit, entered 'q'
            if(answer.equalsIgnoreCase("q")) {
            more = false; 
            }

            // else, play game, keep track of total rounds played and total score from all rounds played
            else {
            totalScore += Game(); 
            round++;
            System.out.println();
            }
        }

        // user quits, display game results from all rounds
        System.out.println();
        // check if user won: scored 1000 or more points
        if(totalScore>=1000) {
            System.out.printf("You won!!! %nYou played %d round(s) and accumulated %,d point(s)!", round, totalScore);
        }

        // user did not win
        else {
            System.out.printf("You lost :[ better luck next time! %nYou played %d round(s) and accumulated %,d point(s)", 
            round, totalScore);
        }
        System.out.println();
        System.out.println("Goodbye! Come back soon to play again!"); 

    }

    // This method must display the prize won for each digit matched
    public static int Prize(int matched) {
        int prize = 0;
        int totalPrize = 0;
        String prizeString = "";
        Random rand = new Random();
        
        System.out.print("Amount scored for each match: ");

        if(matched>0) {
            for(int i=0; i<matched; i++) {
                prize = rand.nextInt(100, 201); // 100-200, inclusive
                System.out.print(prize + " ");
                totalPrize += prize;

            }
        }

        return totalPrize;
    }
    
    // runs one round of the program using our created methods
    // methods included: GetDigitSize(), BigNumbers(), and Prize()
    // returns total score for one round
    public static int Game() {
        int score;
        int digitSize;
        int n1, n2, matchedTotal;
        Random rand = new Random();

        // Get two big, random numbers with digit size varying from 3-6 inclusively
        digitSize = GetDigitSize(rand);
        n1 = BigNumbers(rand, digitSize);
        n2 = BigNumbers(rand, digitSize);

        // Gets matched numbers
        System.out.println();
        System.out.println("You got: " + n1 + ", " + n2);
        matchedTotal = CountMatched(n1, n2);

        // Gets prize
        score = Prize(matchedTotal);
        System.out.println("Your prize for this round is: " + score + " point(s)!");

        return score;
    }

    // describes the game
    public static void Directions() {
        System.out.println();
        // border
        for(int i=0; i<101; i++) {
            System.out.print("=");
        }
        System.out.println();

        System.out.println("You are playing a number matching game! All numbers, " + 
                           "including your prize total is randomly generated! " + 
                           "\nThis program generates and compares two random large numbers ranging from 3-6 digits long. \nFor each" +
                           " matching digit, you will gain points ranging from 100-200 in value. " +
                           "\nWin by scoring 1,000 or more points!!!" +
                           "\nYou can continue playing by hitting enter or quit by hitting 'q'");

        // border
        for(int i=0; i<101; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

} // end of class