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
 
public class RefinCastro // must change this name to include your last name
{
  // no code here
}

/* Must List all the attributes for a valid address*/ 
class Address {
    
 
}
//must change the line below to : class property implements Comparable 
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
        address = new Address();    // idk if this is right
        this.price = price;
        this.isAvailable = isAvailable;
        this.lotSize = lotSize;
        this.yearBuilt = yearBuilt;
   }

   //getter methods
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

   //setter methods
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
        if(this.address.equals(address)) {
            sameAddress = true;
        }

        return sameAddress;
    }

    /*
   compareTo method compares the prices of the two properties. This method can be used to list
   the properties based on the price from low to high
   */
   @Override
    public int compareTo(Object o) {
        int comparisonInt;

        // type into proper Class type
        Property p = (Property) o;

        // if the object's price is greater than the arg object return 1
        if(this.price > p.price) {
            comparisonInt = 1;
        }

        // if the object's price is less than the arg object return -1
        else if(this.price < p.price) {
            comparisonInt = -1;
        }

        // if the object's price is equal to the arg object return 0
        else {
            comparisonInt = 0;
        }

        return comparisonInt;
    }
   
    /* toString method: creates a String representing the atttributes of a property  */

}

/*The ListNode class is given*/
class ListNode{
   private Property prop;
   private ListNode next;
	
   public ListNode(Property p) {
      this.prop = p;
   }
   public ListNode(Property p, ListNode next) {
      this.prop = p;
      this.next = next;
   }
   public ListNode()
   {
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

/*Extra feature: must add two extra methods to this List interface. */
interface List{
   public void add(int rooms, int baths, double price, double sf, Address address, boolean isAvaiable, double lotSize,int yearBuilt);   
   public void add(int rooms, int baths,  double sf, Address address,double price, boolean isAvaiable, double lotSize,int yearBuilt,int index); 
   public boolean remove(Address address); 
   public int size(); 
   public String toString(); 
   public ArrayList<Property>  search(int room);  
   public ArrayList<Property>  search(int room, int bath);  
   public ArrayList<Property>  search(String zipcode);  
   public ArrayList<Property> search(double p1, double p2);
   public Property search(Address address); 
   public ArrayList<Property> searchYearBuilt(int year); 
   public ArrayList<Property> isAvaiable();  
   
}
/*Must implement the new methods you added in the interface*/
class Redfin implements List
{
   private ListNode head;
   public static int size = 0;
	
   public Redfin() {
      head = null;
      
   }
  // constructor
   public Redfin(Property p) {
      head = new ListNode(p);
      size++;
   }
   /*adds a house to the end of the end of the listlist */
   public void add(int rooms, int baths, double price, double sf, Address address, boolean isAvaiable, double lotSize,int yearBuilt)
   {
   
     //your code
   
   }
   
   /*add a house to the list at the given index*/
   public void add(int rooms, int baths,  double sf, Address address,double price, boolean isAvaiable, double lotSize,int yearBuilt,int index)   {
      //your code    	
   }

/*removes a house from the list with the given address, returns true if the house was found and deleted*/
   public boolean remove(Address address)
   {
      //your code
     return false;
   }

  /*returns the size of the list*/
  	
   public int size()
   {
      return  0;
   }
/*returns a string with the list of all the houses*/
   public String toString() 
   {
      return "";
   }
      
   
  /*this method searches the list to find all the houses with the given number of the rooms
  create an arraylist of all the houses and returns the arraylist*/
 
   public ArrayList<Property>  search(int rooms) {
      
      
      //your code
      return null;  //must change
       
   }
   
   /*searches the list to find all all the houses with the specific number of roooms and bath
   returns an Arraylist of houses*/
   
   
   public ArrayList<Property> search(int rooms, int baths) 
   {
   
       //your code
       return null; //must change
   }
   /*Searches the list to find all the houses at the given zipcode*/
   public ArrayList<Property>  search(String zipcode)
   {
      return null;
   }
   
    
  /* returns the list of all the houses with the price range p1 and p2*/
   public ArrayList<Property>   HouseRange(double p1, double p2)
   {
      return null;
   }
  /*returns the house at the given address*/ 
   
   public Property search(Address address)
   {
      return null;
   }
   /*returns the list of all the houses within the prcie range*/      
   public ArrayList<Property> search(double p1, double p2)
   {
      return null;
   } 
   /*returns the list of all the houses built in a given year*/
   public ArrayList<Property> searchYearBuilt(int year) 
   {
      return null;
   }
   /*returns the list of all the houses in the market*/
    public ArrayList<Property> isAvaiable()
    {
       return null;
    } 
    } 
/* 
Refer to the documnet
Must use if/else, while loop , must provide all the required methods
*/
class YourDriver
{
      public static void main(String[] args)
      {
         Redfin properties = new Redfin();
         //call the populate method to add properties to the list
         populate(properties);
         
         //use a whil loop 
            //display the options
            //prompt the user to select an option
            //based on the selected option call the proper method from the Redfin class(must have 12 different conditions
            //display the result for each option selected
          
         
      }
      /*
      This method fills in the list by creating the Property objects , ading it to the list houses
      refer to the document
      Create 7 different propery object and add it to the list called properties
      */
      public static void populate(Redfin properties)
      {
      }
      
      
      
      /*This method displays the 12 options to the user*/
      

}


 