/*
Name: Lynn Castro
Date: 11/26/2025
Description:
========================================================
TOTAL Self grade score: /100 (explanation below)

EXPLANATIONS...
Proper naming: (/5)
Indendation: (/5)
Comments: s(/25)
Program compiles: (/30)
Program runs & the output is similar to provided output: (/25)
Requirements: (/25)
Self grade: (/5)
========================================================
I have written the code by myself and have not copied it from ay resources. Name: Lynn Castro
Codes without recursive implementation will get zero points.
Codes without the additional  methods will not be graded. 

additional  required methods: 
[!] Must add two additional recursive method using the following data structure (30 points)

1. first method must get a linkList of String objects as its parameter and must return a linklist. 
   This method must perform a new function. This method must be unique and not similar to the given methods. 

2. Second method must get an Arraylist of double as a paramter and must return an array of double. 
   This method must perform a new function. This method must be unique and not similar to the given methods.
3. the additional methods must be called in the driver

Must answer the following questions
List the extra added methods:
1. method 1: what does the method do? Why is this functionality important?
2. Method 2: what does the method do and why is this functionality important?

Please do not delete any of the given commnets throughout the code
*/

import java.util.*;
import java.lang.*;

public class RecursiveCastro {
    // no code here
}

// must write code to test all the methods to make sure it is working
// correctly.(20 points)
/*
 * Must call all the recursive methods including the new added methods by you.
 * Must have enough code to initalize the lists and test the methods.
 * This Driver cannot be similar to the given driver in any ways.
 * You must intilaize your list in your own way and not copying any codes from
 * the given driver
 * 
 */

class YourDriver17 {
    public static void main(String[] args) {
        // For testing printReverse();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // For testing palindrome()
        LinkedList<Character> list2 = new LinkedList<>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        list2.add('b');
        list2.add('a');

        // For testing ascci()
        String ascciiString = "abcdef";

        // For testing fib()
        LinkedList<Integer> list3 = new LinkedList<>();

        // For testing listReverse
        LinkedList<Character> list4 = new LinkedList<>();
        list4.add('H');
        list4.add('e');
        list4.add('l');
        list4.add('l');
        list4.add('o');
        list4.add('!');

        LinkedList<Character> list5 = new LinkedList<>();

        // For testing equalsReverse()
        LinkedList<Character> list6 = (LinkedList<Character>) list4.clone();

        // For testing longest()
        LinkedList<String> list7 = new LinkedList<>();
        list7.add("Hello World");
        list7.add("Bonjour");
        list7.add("Aloha");
        list7.add("Greetings");

        // Testing methods ----------------------------
        String border = "=-".repeat(15);

        // testing printReverse() ... works! :)
        System.out.printf("%s %s %s %n", border, "Reversing a list", "=-".repeat(25));
        System.out.println(list + " reversing...");
        Recursive.printReverse(list);

        // testing palindrome() ...  works :)
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Is the list a palindrome?", "=-".repeat(21));
        System.out.println("Is " + list2 + " a palindrome? > " + Recursive.palindrome(list2));

        // testing asccii ... works :)
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Asccii code", "=-".repeat(28));
        System.out.println("Getting asccii codes from '" + ascciiString + "' > " + Recursive.asccii(ascciiString));

        // testing fib ... works :)
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Fibonacci series", "=-".repeat(25));

        Recursive.fib(list3, 8);
        System.out.println("Fibonacci series starting with '1, 1' > " + list3);
        
        // testing listReversed() ... works :)
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Reversing a list", "=-".repeat(25));

        System.out.print(list4 + " Reversed list > ");
        Recursive.listReversed(list4, list5);
        System.out.print(list5);
        System.out.println();

        // testing equalsReverse() ... works :)
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Do two lists equal in reverse order?", "=-".repeat(15));
        System.out.println(list6);
        System.out.println(list5);
        System.out.println("Do the 2 lists match in reverse order > " + Recursive.equalsReverse(list6, list5));

        // testing longest ... works :)
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Whats the longest string in the list?", border);

        System.out.println(list7);
        System.out.println("Longest string in the list is > " + Recursive.longest(list7, ""));

        // testing findAvg() ... works
        System.out.println();
        System.out.printf("%s %s %s %n", border, "Whats the average number in the list?", border);
        System.out.println(list3 + " ...Average for list > " + Recursive.findAvg(list3, 0, list3.size()));

        // Testing additional methods!
        System.out.println();
        System.out.println("=*".repeat(50));
        System.out.println("Additional method #1...");
        System.out.println("Additional method #2...");

        System.out.println("=*".repeat(50));
        // end of code for my driver
    }
}
// Do not delete the given driver 

/* TEMPORARILY changed name from Driver to Driver16 so I can run in vscode
class Driver16 {
    public static void main(String[] args) {

        /// ********************************************************
        LinkedList list = new LinkedList();
        // filling the link list with some letters
        for (char i = 'a'; i < 'm'; i++) {
            list.add(((String) (i + "")));
        }
        // testing the palindrom method
        System.out.print(list + " is palindrome?  ");
        System.out.println(Recursive.palindrome(list));
        System.out.println("\n***********************************************\n");

        // ***********************************************************************
        // creating a palindorm list to check the palindrom method
        LinkedList list2 = new LinkedList();
        for (char i = 'a'; i <= 'm'; i++) {
            list2.add(((String) (i + "")));
        }
        for (char i = 'm'; i >= 'a'; i--) {
            list2.add(((String) (i + "")));
        }
        System.out.print(list2 + " is palindrome?  ");
        System.out.println(Recursive.palindrome(list2));
        System.out.println("\n**************************************************\n");

        // *******************************************************************************

        // testing the asccii method
        System.out.println("\ntesting ascci metod");
        String s = "What goes around comes around";
        System.out.println("The list of the asccii code in the string " + s + " is \n" + Recursive.asccii(s));
        System.out.println("\n*****************************************************\n");

        // *********************************************************************************

        // testing the longest method to find the longest word in the list
        // filling in the array list
        LinkedList myList = new LinkedList();
        myList.add("Computers");
        myList.add("Philosophy");
        myList.add("building materials");
        myList.add("Costco warehouse");
        System.out.println("\ntesting longest string in the list of string" + myList.toString());

        System.out.println("The longest string is the list " + myList.toString() +
                " is " + Recursive.longest(myList, ""));
        System.out.println("\n*******************************************************\n");
        // *********************************************************
        // testing the equlas method to see if two list are equals in the reverse order

        LinkedList m1 = new LinkedList();
        for (char i = 'a'; i <= 'm'; i++) {
            m1.add(((String) (i + "")));
        }
        LinkedList m2 = new LinkedList();
        for (char i = 'm'; i >= 'a'; i--) {
            m2.add(((String) (i + "")));
        }
        System.out.println(m1);
        System.out.println(m2);
        // System.out.println(m1);
        // System.out.println(m2);
        System.out.println("Are the two list equalin the reverse order: " + Recursive.equalsReverse(m1, m2));
        for (char i = 'a'; i <= 'm'; i++) {
            m1.add(((String) (i + "")));
        }
        for (char i = 'm'; i >= 'a'; i--) {
            m2.add(((String) (i + "")));
        }

        m1.add("z");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println("Are the two list equal in the reverse order: " + Recursive.equalsReverse(m1, m2));
        System.out.println("\n*********************************************************\n");

        // ********************************************************************************

        // testing the average method

        System.out.println("\ntesting the avg of the integers in a link list");
        LinkedList list3 = new LinkedList();
        Random rand = new Random();
        for (int i = 1; i <= 5; i++)
            list3.add((Integer) (rand.nextInt(20) + 1));
        int sum = 0;
        System.out.println(list3);
        System.out.print("The average is: ");
        System.out.println(Recursive.findAvg(list3, sum, list3.size()));
        System.out.println("**********************************");
        // *******************************************************
        // Calling the fib method
        LinkedList fibList = new LinkedList();
        System.out.println("The list of the first 12 fibinaci numbers: ");
        Recursive.fib(fibList, 12);
        System.out.println(fibList);
        System.out.println("***************************");

        // ***********************************
        // Testin the reverse method
        LinkedList reverse = new LinkedList();
        System.out.println(fibList);
        Recursive.listReversed(fibList, reverse);
        System.out.println("The reverse list is: ");
        System.out.println(reverse);
        System.out.println("\n************************************************************\n");

        // *******************************
        // calling the additional methods

    }
} // end of (given) driver class */

/*
 * In this program you must use the following methods from the LinkedList class
 * getFirst
 * removeFirst
 * getLast
 * removeLast
 * size
 * get(index)
 * No loop can be used with any of the methods. methods with loop will get zero
 * points.
 */

class Recursive {
    /*
     * This method gets a link list of integer values and returns a a new list in
     * the reverse order of the original list
     * Must implement it recursively
     */
    public static void listReversed(LinkedList list, LinkedList reversed) {
        // base case when the size of the list is zero(this case will end the recursive call
        if(list.isEmpty()) {
            return;
        }

        // add the last element of the list to the reverse list
        reversed.add(list.getLast());

        // remove the last element from the list
        list.removeLast();

        // call the listReverse with the two lists as the paramters
        listReversed(list, reversed);
    }

    /*
     * write a method to create the fibinaci series recursively
     * fibonaci series for the first 8 numbers is: 1 1 2 3 5 8 13 21
     * This method must be implemented recursively
     * max represents the number of the fibbonaci numbers that must be created
     */
    public static void fib(LinkedList list, int max) {
        int sum;

        // base case is if max is equal to zero
        if(max == 0) {
            return;
        }

        // if the list is empty
        if(list.isEmpty()) {
            // add 1 to the list
            list.add(1);
            // add 1 to the list
            list.add(1);
            max-=2; // because we ignore the values we add
        }

        // find the sum of the last two numbers in the list, add the result to the list.
        // You might have to type cast to Integer 
        sum = (int) list.get(list.size()-2) + (int) list.getLast();
        list.add(sum);

        // decrement max by 1
        max--;

        // call the fib with the list and max
        fib(list, max);
    }

    /*
     * This method prints the content of a the link list in the reverse order
     * recursively
     */
    public static void printReverse(LinkedList list) {
        // base case is when the size of the list is zero
        if (list.isEmpty()) {
            return;
        }

        // print the last element in the list
        System.out.print(list.getLast());

        // remove the last element from the list
        list.removeLast();

        // call the printReverse method and pass the list
        printReverse(list);
    }

    /*
     * This method returns true if the list is palindrome
     * must be implemented recursively
     * no loop can be used. This method must be implemented using the LinkedList
     * objects
     */
    public static boolean palindrome(LinkedList list) {
        // base case if the size of the list is 1 or 2 return true
        if( (list.size() == 1) || (list.size() == 2) ) {
            return true;
        }

        // check the equality of the first and last element in the list and store the
        // result in a boolen variable called b
        boolean b = list.getFirst().equals(list.getLast());

        // added these two lines outside of given instructions 
        list.removeFirst();
        list.removeLast();

        return b && palindrome(list);
    }

    /*
     * This method gets a string and finds the sequence of the asccii codes in the
     * given string
     * for example if The the string is "abcdef" then the return must be
     * " 97 98 99 100 101 102"
     */
    public static String asccii(String s) {
        int code;
        byte[] asciiCodes;

        // if the length of the string is 0 return "";
        if(s.length() == 0) {
            return "";
        }

        // get the ascii code of the first letter in the string and store it int
        // variable called code
        asciiCodes = s.getBytes();
        code = asciiCodes[0];

        // remove the first letter from the String s by using the substring method
        s = s.substring(1);

        return code + " " + asccii(s);
    }

    /*
     * This method gets a linkedlist and a string, return the longets string in the
     * list
     * This method must be implemented recursively
     * no loop can be used
     */
    public static String longest(LinkedList list, String longest) {
        // if the list size is zero return longest
        if(list.isEmpty()) {
            return longest;
        }

        // get the first element in the list by using the getFirst method and store it
        // in a variable called s
        String s = (String) list.getFirst();

        // if s is longer than longest
        if(s.length() > longest.length())
        {
            // set longest to s
            longest = s;

            // remove the first element from the list using removeFirst method
            list.removeFirst();
        }

        // else
        {
            // remove the first element
            list.removeFirst();
        }

        return longest(list, longest);
    }

    /*
     * This method compares two Link list to see if they conatin the same values in
     * the reversse order
     * 1 2 3 4 5
     * 5 4 3 2 1
     * should return true for the two list otherwise should return false
     */
    public static Boolean equalsReverse(LinkedList list1, LinkedList list2) {
        // if the two list don't have the same size return false
        if(list1.size() != list2.size()) {
            return false;
        }

        // if the size of either of the list is zero return true
        // idk why instructions say to return true, it should return false.
        if( (list1.isEmpty()) || (list2.isEmpty()) ) {
            return true; 
        }

        // get the first element in the list 1
        String s1 = String.valueOf(list1.getFirst());

        // get the last element in the list 2
        String s2 = String.valueOf(list2.getLast());

        // if the first and last element are not equal return false
        if(!(s1.equals(s2))) {
            return false;
        }

        // remove the first element from the list 1
        list1.removeFirst();

        // remove the last element from the list 2
        list2.removeLast();

        return true && equalsReverse(list1, list2);
    }

    /*
     * this method finds the average of the integers in a list recursively.
     * non-recursive solutions are not acceptable
     */
    public static int findAvg(LinkedList list, int sum, int size) {
        // if the size of the list is zero return sum/size
        if(list.isEmpty()) {
            return sum/size;
        }

        // add the first element to the sum
        sum += (int) list.getFirst();

        // remove the first element
        list.removeFirst();

        return findAvg(list, sum, size);
    }

    // additionl method 1
    

    // addditional method 2

} // end of class
