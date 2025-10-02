/*description
Date: 10/1/25
Testimony: The following program is written by me, Lynn Castro.
----------------------------------------------------------------
                SELF-GRADE SCORE AND EXPLANATION
Self grade: 

Proper naming:
Indentation:
Comments:
Program compiles:
Program runs and simiarly matches provided output:
Requirements met:
Self-grade provided: 
----------------------------------------------------------------

DO NOT REMOVE ANY OF THE COMMENTS

(30 points)Additonal required methods
Must answer the following questions otherwise no points will be given 
Method 1: 
what does the method do?
Is the return type an ArrayList
How does it add functionality to the cart class
How many lines of code does it have

Method 2: 
what does the method do?
Is the return type an ArrayList
How does it add functionality to the cart class
How many lines of code does it have



Implement the classes in the given order
*/
import java.util.*;
public class OnlineStoreCastro1 {
   // no code
}

class Item {
    // Instance Variables
    private String barCode;
    private double price;       // specialized set method to avoid non-negative
    private String name;
    private String description;
    private int quantity;       // specialized set method to avoid non-negative

    
     //**********************************************************************************
     /*constructor: call the methods setPrice and setQuantity implemented in this class to make sure that the user
     is not giving any negative values for the quantity or the price*/ 
       
       
       
       
    //*******************************************************
    // Accessor and Mutator Methods

    // Accessor for barCode
    public String getBarCode() {
        return this.barCode;
    }

    // Mutator for barCode
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    //---------------------------------------
    // Accessor for price
    public double getPrice() {
        return this.price;
    } 
    
    // Mutator for price
    /*setPrice(double price) this method sets the price of the item, if the price is negative returns false and the price will not be changed
    , otherwise this method sets the price to the new price and returns true
    Conditional statments must be used in this method*/
     
    //---------------------------------------
    // Accessor for name
    public String getName() {
        return this.name;
    }

    // Mutator for name
    public void setName(String name) {
        this.name = name;
    }
    //---------------------------------------
    // Accessor for description
    public String getDescription() {
        return this.description;
    }

    // Mutator for description
    public void setDescription(String description) {
        this.description = description;
    }
    //---------------------------------------
    // Accessor for quantity
    public int getQuantity() {
        return this.quantity;
    }

    /*setQuantity(int amount)this method sets the quantity for the item, if the quantity is negative returns false and the quantity will not be changed, 
    otherwise this method sets the quantity to the paramter and returns true
    Conditional statments must be used in this method*/
     

    //---------------------------------------
    /*This method creates a string representng all the attributes of the object and returns it*/
    @Override
    public String toString() {
        return "";              // write the code dumbass
    }

    //***********************************************************************
    /*This equal method compares two objects of type Item. Since the parameter for this method is of type Object , instanceof and type casting is needed.
    conditional statement is needed in this method. if the object other is of type Item, type cast it then compare the barcodes and return the result.
    If the object other is not of type Item return false*/
    
    
    
    
        
    //*********************************************************************************
    /*This method finds the total cost for the item by multiplying the price and the quantity purchased, then returns the result*/
}
 

class OnlineItem extends Item {
     
    // Instance variables 
    private double weight;      // to calculate shipping costs
    
    //**************************************************************************************************
    /*constructor : make sure to refrence the constructor in the Item class by using the super keyword
    this constructor gets the following as the list of its parameters
    String bar, String name, String description, int quantity, double price, double weight*/
  
  
  
      
          
    //******************************************************
    //getwight method , this method should return the weight of the item multiply to the quantity purchased oer item
        
     
        
     
    //************************************************************
    /*This method creates a string representing all the attributes of an OnlineItem. Since some of the attributes are declared in the Item
    class then super.toString() must be called.
    also make sure to call the getTotal() method from the item class to show the cost as well
    returning : super.toString() + getTotal(); */
     
     
     
     
}
 
/* this class does not extend any other classes. there is a Has-a relationship between this class and the onlineItem class*/
class Cart {
    
    // Constants & Instance Variables
    public static final double SHIPPING_COST_PER_POUND = 1.50;  // shipping cost per pound
    private double discount;                                    // calculated based on purchased amount
    ArrayList<OnlineItem> list;                                 // = new ArrayList<>(); ???
     
    //*******************************************************************************
    /* constructor: instantiates the ArrayLits list*/    
        
    
     
     
          
    //**************************************************
    //getter method getList method that returns the refrence to the list of the items purchased.*/
     
     
     
     
         
    //*******************************************************
    /*This remove method removes an item from the ArrayList based on the barcode*/
          
     
     
     
     
     
     
         
    //******************************************************************
    /* This method gets the info for an item such as as barcode,description, quantity,price, weight as its paramter
    create an object of OnlineItem
    add the created objct to the end of the list
     
    */
     
      
      
      
      
        
    //****************************************************************
     
    /*This checkout method calculate the total purchase, shipping cost, tax and the total amount due . it should include the followings
    1. display the checking out message , refer to the sample output
    2. call the method totalPurchaseAmount() to figure our the total amount of money owed 
    3. call the discount() method to set the value for the instance ariable discount 
    4. if total money spending is >= 75 the shipping is free otherwise must call the method shipping cost()
    5. call the toString method to display the items in the arrayList . toString method must have been implemented in this class
    6. display total money owed
    7. display the total tax = 7.75/100 * money owed
    8. display the total after discount
    9. displaying either the shipping cost or display "Free shipping"; 
    10 finally display amount due = money owed + tax + shipping cost(might be zero) 
    you can use String .format method to get rid off the decimal pints or printf
    */
     
     
     
     
     
     
     
     
     
    //**************************************************
    /*this changeQuantity method allows the user to change  the quantity of a particular item in the list
    this method gets the barcode of the item, finds the item in the list
    and then change the quantity of the item  to the new given quantity.  
     
    A for loop is needed  
    loop thriugh the ArrayList, find the item with the given barcode, if the item is at the index i then
     
    list.get(i).setQuantity(quantity) 
    System.out.println("Updated itemlist.get(i)  // printing the updata item        
       
    method returns true if the item is found
    else display "item not found" and returns false    */  
       
       
       
                    
     
    //***********************************************************************************
    /*This toString method creates a String representing all the items in the person's list
    a for loop is needed to go through the list and call the tostring method on each item. 
    Creating a String representing all the items in the list, finally returns the string
    inside the loop: list.get(i).toString()
    */
    
    
    
    
    //**************************************
    /*
    method totalPurchasedAmount finds out the total money the person owed, not including the tax and the shipping and the discount
    This code should be used somewhere in your code: 
    loop through the list
    get the total for each item at the index i by list.get(i).getTotal()
    add the caclculated total to a variable that holds the total cost for the items in the list 
    */
    
    
    
    
    
    
    
    
    
    //***************************************************************
    /*Returns the weight of the all the items in the arraylist, 
    need a for loop and the code: list.get(i).getWeight();
    should be used in the for loop along with some additional codes    
    */
    
    
    
    
    
    
    
    
    //******************************************************************
    /*
    This method shippingCost  calculates the shipping cost for all the items in the cart. shipping is free for the purchase of $75 or more.
    if the total money owed is less than 75$ then the shipping cost must be calculated based on the weight of all the items in the list
    do the following steps:
    1. call the method totalPurchaseAmount(), if the amount returned is >= 75 then return 0
    2. otherwise  call the method totalWeight()
    3. return the result of step 2 * SHIP_RATE
     
     
     
     
     
     
     
    */
    /* This method discount()  sets the variable discount based on the following
    
    Purchases up to 99 gets 5% discount discount = totalPurchaseAmount(); * 5/100
    Purchase 100 -199 gets 10% discount
    purchase 200 - 299 get 15% discount
    Purchase 300 - 399 gets 20% discount
    purchase above 400 gets 25% discount

    
    */
    
    /*additional method 1: must have at leat 5 lines of code excluding the {}. 
    no print/println. Must return an ArrayList. Must have at least two parameters
    Must have a loop. Must be called in the driver
    */
    
    
    
    /*additional method 2: must have at leat 5 lines of code or more excluding the {}.
    no print/println. Must return an ArrayList. Must have at least two parameters
    Must have a loop
    Must be called in the driver
    */
      
}
 
//*********************************************************************
/*
once you implemet all three classes above, uncomment the following driver and test your code. 
Your code must generate the exact output that is provided.
refer to the sample output while coding this class
*/
class OnlinShoppingCartDriver {
   public static void main(String[] args) {
      //your code
   }
}