import java.util.*;

// Code for a menu that runs code when an option is selected by the user.
public class OptionsMenuTemplate {

    /*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        menuSelect(scan);
    }
    */

    // calls methods or runs code when an option is selected
    public static void menuSelect(Scanner scan) {
        String border = "-".repeat(45); // spacer to keep outputs organized
        boolean quit = false;
        String input;

        while(!quit) {
            menuDisplay();
            input = scan.nextLine();

            switch (input) {
                // user quit
                case "q":
                case "Q":
                    scan.close();
                    System.out.println("\nThanks for testing! Exiting program ...");
                    quit = true;
                    break;
                // option 1 ...
                case "1":  
                    // code here...
                    System.out.println("Option 1...");
                    break;
                // user entered a key not in the listed options
                default:
                    System.out.println("\nInvalid input. Please try again.");
                    break;
            }
        }
    }

    // Displays the options
    public static void menuDisplay() {
        String border = "-".repeat(45);
        System.out.printf("%s%n" +
                          "Enter [1-3] to select the following options OR " + 
                          "%nEnter 'Q' or 'q' to exit the program. %n" +
                          "%n[1]  Option 1" + 
                          "%n[2]  N/A" + 
                          "%n[3]  N/A" + 
                          "%n >> ", border);
    }
}
