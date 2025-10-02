/*
 *  Experimenting with ArrayList class and Collections methods 
 */

import java.util.*;
import java.util.Collections;

public class ArrayListSandbox {
    public static void main(String[] args) {

        ArrayList<String> favSongs = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        // ArrayList add() 
        favSongs.add("Autum Leaves");
        favSongs.add("Stal");
        favSongs.add("Run");
        
        System.out.println("=".repeat(75));
        System.out.println("Testing add()");
        System.out.println(favSongs);
        System.out.println("=".repeat(75));

        // ArrayList set() 
        favSongs.set(0, "Misty");

        System.out.println("Testing set(), changed Autum Leaves to Misty");
        System.out.println(favSongs);
        System.out.println("=".repeat(75));

        // ArrayList remove() 
        favSongs.remove("Stal");

        System.out.println("Testing remove(), Stal should be removed");
        System.out.println(favSongs);
        System.out.println("=".repeat(75));

        // ArrayList get()
        System.out.println("Testing get() --> element at index 1 is: " + favSongs.get(1));
        System.out.println("=".repeat(75));

        // ArayList size()
        System.out.println("Testing size() --> size of this arary is: " + favSongs.size());
        System.out.println("=".repeat(75));

        // Collections sort(), sorts elements in alphabetic order

        // adding more elements to be sorted
        favSongs.add("YUKON");
        favSongs.add("If you do");
        favSongs.add("Valentina");

        System.out.println("Testing COLLECTIONS sort()");
        System.out.println("Before sorting: \n" + favSongs);
        Collections.sort(favSongs);
        System.out.println("\nAfter sorting: \n" + favSongs);
        System.out.println("=".repeat(75));

        // Example of using primitive element type in an ArrayList
        // While also using scanner for inputs
        ArrayList<Integer> intList = new ArrayList<>();
        
        // using scanner for promtps
        for(int i = 0; i<5; i++) {
            System.out.print("Enter an integer value for #" + (i+1) + ": ");
            int num = scan.nextInt();
            intList.add(num);
        }
        System.out.println("\nPrinting the list of values you entered: ");
        System.out.println(intList);
        System.out.println("=".repeat(75));

        System.out.println("Sorting your values from least to greatest: ");
        Collections.sort(intList);
        System.out.println(intList);

        scan.close();
    }
 }
