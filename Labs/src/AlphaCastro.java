/*
Name: Lynn Castro
Description
date: 8/30/2025
===============================================================
Self-grade with explanations: 

Proper naming: 5, all method names and variables are meaningful, short, and descriptive
Indentation: 5, 4 spacing indention, code is readable and organized
Comments: 5, all comments clearly explain each method/variable and their purpose
Program compiles: 5, compiles in JGRASP
program runs and the output matches the provided output: 5, runs in JGRASP, output matches provided output
Requirements: 5, all methods have been implemented and work, including rightShift()
Self-grade: 100
===============================================================
Testimony: I have written the code by myself without any help from the unauthorized resources. - Lynn Castro
*/
import java.util.*;
public class AlphaCastro {

    public static void main(String[] args) {
        // variables used in main method
        char[] charList = new char[5];
        int shift = 3;

        //calls method that describes the program
        desc();
        
        //calls the populate method and passes the declared array
        populate(charList);

        //calls the print method and passes the declared array
        print(charList);
        System.out.println();
        
        //calls the rightShift method
        rightShift(charList, shift);
      
        //display the shifted array
        System.out.println();
        System.out.println("After calling rightShift()");
        print(charList);
        
   } // end of main

    // Uses a sequential search algorithim to confirm that there are no duplicate inputs in the array
    // true = input is in array, false = input is not in array
    public static boolean search(char[] letters, char input) {
        for(int i=0; i<letters.length; i++) {
            if(input == letters[i]) {
                return true;
            }
        }
        return false;  
    }

    // Prompts user for a valid input, which is a singular character (a-z) OR (A-Z)
    // If user input is invalid, prompts user until a valid input is given
    public static char validateInput(Scanner kb) {
        String input="";
        char firstLetter =' '; 
        boolean done = false;

        // while no input yet
        while(!done)   {
            System.out.print("Enter a letter a-z or A-Z: \n");
            input = kb.nextLine();

        // prompt user until a single letter is given
        while(input.length()>1) {
            System.out.print("You must enter a single letter\n");
            System.out.print("Enter a letter a-z or A-Z: \n");
            input = kb.nextLine();
        }

        // default input to upper case, store the input in firstLetter
        input = input.toUpperCase();
        firstLetter = input.charAt(0);  

        //if the firstLetter is between A and Z
        if( ((firstLetter >= 'A') && (firstLetter <= 'Z')) || ((firstLetter >= 'a') && (firstLetter <= 'z')) ) {
            done = true;
        }
        // input is not between A-Z, ask user for a valid letter
        else {
            System.out.print("You did not enter a valid letter\n");
            }
        }
        return firstLetter;
   }

    // fills the array with valid inputs using validateInput()
    // and checks if a letter is stored in the array or not
    public static void populate(char[] letters)  {
        Scanner kb = new Scanner(System.in);

        // gets a valid letter
        for(int i=0; i<letters.length; i++) {
            char letter;
            letter = validateInput(kb);
            boolean letterFound; 
            letterFound = search(letters, letter);

            // if the variable 'letterFound' is false, the letter was not found in the array
            if(letterFound==false) {
                letters[i] = letter;
                System.out.println("The letter was added to the array");
                System.out.println("You have " +  (i+1) + " in the array");
            }
            // letter is found, tell user to try again
            else {
                System.out.println("you already entered this letter Try again");
                i--;
            }
       }
   }

    // displays the array of chars in the format {A,B,C,D,E}
    // without using Arrays.toString
    public static void print(char[] letters) {
        int count = 0;
        
        System.out.print("Here is the list of the distinct letters you entered: {");
        // for the last element in the array don't print another comma
        for(int i=0; i<letters.length; i++) {   
            if(count == letters.length-1) {
                System.out.print(letters[i]);
            }
            
            // add a comma after the element if not the last element/character
            else {
            System.out.print(letters[i] + ", ");
            count++; 
            }
        }
        System.out.print("}");
   }

    // Describes how the program works. Uses a loop to print the star border
    public static void desc()  { 
        String descString = "\nYou will be asked to enter letters. " +
                            "Uppercase and lowercase will be\n" +
                            "considered the same.\n" +
                            "The program will filter out repeated letters and display the" +
                            " distinct letters\nentered by the user.\n";

        System.out.println();
        // (1/2) for loop to display border of stars
        for(int i=0; i<84; i++) {
           System.out.print("*");
        }

        System.out.print(descString);

        // (2/2) for loop to display border of stars
        for(int i=0; i<84; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // Shifts characters in an array to the right by a given (shift) amount.
    public static void rightShift(char[] letters, int shift) {
        char[] temp = new char[letters.length];
        int count = 0;

        // moves characters to be shifted to their shifted index place in a temp array 
        if(count < shift) {
           for(int i=shift; i<letters.length; i++) { 
               temp[i] = letters[count];
               count++;
           }
        }
        
        // moves remaining characters to the skipped indices
        for(int i=0; i<shift; i++) { 
            temp[i] = letters[count];
            count++;
        }
        
        // returns shifted elements back to original array
        for(int i=0; i<letters.length; i++) {
            letters[i] = temp[i];
        }
        temp = null;
   }
}