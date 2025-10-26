import java.util.*;
/*

MUST COMPLETE THE COMMENTS BELOW
Name:
Description
Date:
Self grade: self grade without an explanation will get 0/5
testimony: I have written the code by myself and did not use unauthorized resourse. 

  
 
 

I am aware that If the instructor finds that the submitted code is from previos semester, I will get zero points for it.Name________

DO NOT DELETE ANY OF THE GIVEN COMMENTS
*/
import java.util.Scanner;

public class RefinCastro {
    // no code here
}

class Address implements Comparable<String> {
    // instance variables
    String name;
    int zipcode;

    // constructor
    public Address(String name, int zipcode) {
        this.name = name;
        this.zipcode = zipcode;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getZipcode() {
        return zipcode;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    // compares 2 street addresses, returns an int val
    // returns 1 if the object's name is alphabetically after the arg's name
    // returns -1 if the object's name is alphabetically before the arg's name
    // returns 0 if the object's name is equal to the arg's name
    public int compareTo(String o) {
        return (this.name).compareTo(o);
    }

    // compares name and zipcode, returns a boolean val
    public boolean equals(Object o) {
        boolean sameAddress = false;

        // type cast into proper class type
        Address a = (Address) o;
        if ((this.name.equals(a.name)) && ((this.zipcode) == a.getZipcode())) {
            sameAddress = true;
        }

        return sameAddress;
    }

    // string of address' attributes
    public String toString() {
        return String.format("%nZipcode: %d %nAddress: %s", getZipcode(), getName());
    }

}

// must change the line below to : class property implements Comparable
class Property implements Comparable<Object> {

    // instance variables
    private int rooms;
    private int baths;
    private double sf; // square feet of the property
    private Address address;
    private double price;
    private Boolean isAvailable;
    private double lotSize;
    private int yearBuilt;

    // constructor:
    public Property(int rooms, int baths, double sf, Address address, double price,
            boolean isAvailable, double lotSize, int yearBuilt) {
        this.rooms = rooms;
        this.baths = baths;
        this.sf = sf;
        this.address = address;
        this.price = price;
        this.isAvailable = isAvailable;
        this.lotSize = lotSize;
        this.yearBuilt = yearBuilt;
    }

    // getter methods
    public int getRooms() {
        return rooms;
    }

    public int getBaths() {
        return baths;
    }

    public double getSf() {
        return sf;
    }

    public Address getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public double getLotSize() {
        return lotSize;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    // setter methods
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public void setSf(double sf) {
        this.sf = sf;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    // Compares two properties and returns a boolean value
    public boolean equals(Address address) {
        boolean sameAddress = false;

        // compares this object's address with the argument address
        if (this.address.equals(address)) {
            sameAddress = true;
        }

        return sameAddress;
    }

    /*
     * compareTo method compares the prices of the two properties. This method can
     * be used to list
     * the properties based on the price from low to high
     */
    @Override
    public int compareTo(Object o) {
        int comparisonInt;

        // type into proper Class type
        Property p = (Property) o;

        // if the object's price is greater than the arg object return 1
        if (this.price > p.price) {
            comparisonInt = 1;
        }

        // if the object's price is less than the arg object return -1
        else if (this.price < p.price) {
            comparisonInt = -1;
        }

        // if the object's price is equal to the arg object return 0
        else {
            comparisonInt = 0;
        }

        return comparisonInt;
    }

    // creates a string representing all Property attributes
    public String toString() {
        String borderFmt = "=".repeat(25);

        return "\n" + borderFmt +
                String.format("%nRooms: %d" +
                        "%nBaths: %d" +
                        "%nSquare Feet: %.1f" +
                        "%nPrice: $%,.2f" +
                        getAddress().toString(),
                        getRooms(), getBaths(), getSf(), getPrice())
                + "\n" + borderFmt;
    }
}

/* The ListNode class is given */
class ListNode {
    private Property prop;
    private ListNode next;

    public ListNode(Property p) {
        this.prop = p;
    }

    public ListNode(Property p, ListNode next) {
        this.prop = p;
        this.next = next;
    }

    public ListNode() {
    }

    public Property getHouse() {
        return prop;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}

/* Extra feature: must add two extra methods to this List interface. */
// Extra feature 1:
// Extra feature 2:
interface List {
    public void add(int rooms, int baths, double price, double sf, Address address, boolean isAvaiable, double lotSize,
            int yearBuilt);

    public void add(int rooms, int baths, double sf, Address address, double price, boolean isAvaiable, double lotSize,
            int yearBuilt, int index);

    public boolean remove(Address address);

    public int size();

    public String toString();

    public ArrayList<Property> search(int room);

    public ArrayList<Property> search(int room, int bath);

    public ArrayList<Property> search(String zipcode);

    public ArrayList<Property> search(double p1, double p2);

    public Property search(Address address);

    public ArrayList<Property> searchYearBuilt(int year);

    public ArrayList<Property> isAvaiable();

}

/* Must implement the new methods you added in the interface */
// Extra feature 1:
// Extra feature 2:
class Redfin implements List {
    private ListNode head;
    public static int size = 0;

    // constructors
    public Redfin() {
        head = null;
    }

    public Redfin(Property p) {
        head = new ListNode(p);
        size++;
    }

    // adds a property to the end of the list
    public void add(int rooms, int baths, double price, double sf, Address address, boolean isAvaiable, double lotSize,
            int yearBuilt) {
        // make a new property object with the given parameters
        Property a = new Property(rooms, baths, sf, address, price, isAvaiable, lotSize, yearBuilt);

        // make a copy of the head node
        ListNode curr = head;

        if (curr == null) {
            head = new ListNode(a);
            size++;
            return; // to get out of the method
        }

        // adding to an exisiting node with a size > 0
        else {
            ListNode newNode = new ListNode(a);
            // locate the last node, which will have a null pointer
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            // set the current last node to point to the new last node
            curr.setNext(newNode);
            size++;
        }
    }

    // add a house to the list at the given index
    public void add(int rooms, int baths, double sf, Address address, double price, boolean isAvaiable, double lotSize,
            int yearBuilt, int index) {
        // make a new property object with the given parameters
        Property a = new Property(rooms, baths, sf, address, price, isAvaiable, lotSize, yearBuilt);

        // make a new node with the new property object
        ListNode newNode = new ListNode(a);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return; // to get out of the method
        }

        else {
            // make a copy of the head node
            ListNode curr = head;

            // traverse through list until node BEFORE the given index node is found
            int i = 0;
            while ((curr.getNext() != null) && (i < index - 1)) {
                curr = curr.getNext();
            }

            // insert the new node by setting the new node's next reference to the current
            // node at the given index
            newNode.setNext(curr.getNext());
            // then set the current node, which is at the index before the given index, next
            // reference to the new node
            curr.setNext(newNode);
            size++;
        }
    }

    // removes a house from the list with the given address, 
    // returns true if the house was found and deleted
    public boolean remove(Address address) {
        boolean removedAddress = false;        
        int index = 0;

        // if there is nothing in the list, there is nothing to remove
        if (head == null) {
        }

        else {
        // search through each node
            while ( (head != null) && (index < size - 1) ) {
                ListNode prev = head;
                ListNode curr = head.getNext();
                // if the next node is the matching address, then change the references
                if (curr.getHouse().equals(address)) {
                    prev.setNext(curr.getNext()); // previous skips to next
                    curr.setNext(null);   // remove the next node, make it null
                    size--;
                    removedAddress = true;
                }
                prev = prev.getNext();
                index++;
            }
        }

        return removedAddress;
    }

    // returns the size of the list
    public int size() {
        return size;
    }

    // returns a string with the list of all the houses
    public String toString() {
        String fmtString = "";
        ListNode curr = head;

        // if the list is empty, there is no data to display
        if (head == null) {
        }

        // traverse through entire list and call the toString() of each property object
        while (curr != null) {
            fmtString += curr.getHouse().toString();
            curr = curr.getNext();
        }

        return fmtString;
    }

    /*
     * this method searches the list to find all the houses with the given number of
     * the rooms
     * create an arraylist of all the houses and returns the arraylist
     */

    public ArrayList<Property> search(int rooms) {

        // your code
        return null; // must change

    }

    /*
     * searches the list to find all all the houses with the specific number of
     * roooms and bath
     * returns an Arraylist of houses
     */

    public ArrayList<Property> search(int rooms, int baths) {

        // your code
        return null; // must change
    }

    /* Searches the list to find all the houses at the given zipcode */
    public ArrayList<Property> search(String zipcode) {
        return null;
    }

    /* returns the list of all the houses with the price range p1 and p2 */
    public ArrayList<Property> HouseRange(double p1, double p2) {
        return null;
    }
    /* returns the house at the given address */

    public Property search(Address address) {
        return null;
    }

    /* returns the list of all the houses within the prcie range */
    public ArrayList<Property> search(double p1, double p2) {
        return null;
    }

    /* returns the list of all the houses built in a given year */
    public ArrayList<Property> searchYearBuilt(int year) {
        return null;
    }

    /* returns the list of all the houses in the market */
    public ArrayList<Property> isAvaiable() {
        return null;
    }
}

/*
 * Refer to the documnet
 * Must use if/else, while loop , must provide all the required methods
 */
class YourDriver {
    public static void main(String[] args) {
        Redfin properties = new Redfin();

        // ===================================================
        // JUST TESTING IMPLEMENTED METHODS AS I GO
        Address a1 = new Address("2543 Roblox Way", 123465);
        Address a2 = new Address("1234 Minecraft Way", 123465);
        Address a3 = new Address("1224 Fortnite Way", 123465);
        Address a4 = new Address("1224 Persona Way", 123465);

        Property p1 = new Property(4, 3, 10555.0, a1, 300777.99, false, 777, 2009);
        //Property p2 = new Property(7, 2, 1075.0, a2, 1000.99, false, 25, 2010);

        Redfin redfin = new Redfin(p1);

        // Testing Redfin methods

        // testing add(), 2 versions 
        //redfin.add(7, 2, 599.99, 300.0, a4, true, 47, 2020);  // works for adding a new node to the front :)
        redfin.add(7, 2, 1075.0, a2, 1000.99, false, 25, 2010, 1);  // works @ a given index:)
        System.out.println(redfin.toString()); 
        
        // testing size
        System.out.println("size of list: " + redfin.size());

        // testing remove
        redfin.remove(a2);  // works :)
        System.out.println(redfin.remove(a3) + "\n" + redfin.toString()); // trying to remove an address  not in the list works :) returns false 

        //System.out.println(p1.toString());    // testing toString


        // ===================================================

        // call the populate method to add properties to the list
        // populate(properties); // UNCOMMENT AFTER TESTING!!!!!!!!!

        // use a whil loop
        // display the options
        // prompt the user to select an option
        // based on the selected option call the proper method from the Redfin
        // class(must have 12 different conditions
        // display the result for each option selected

    }

    /*
     * This method fills in the list by creating the Property objects , ading it to
     * the list houses
     * refer to the document
     * Create 7 different propery object and add it to the list called properties
     */
    public static void populate(Redfin properties) {
    }

    /* This method displays the 12 options to the user */

}