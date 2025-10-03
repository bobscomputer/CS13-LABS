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

    // Null constructor for testing
    public Item() {
    }

    // Full constructor
    public Item(String barCode, double price, String name, String description, int quantity) {
        this.barCode = barCode;
        setPrice(price);
        this.name = name;
        this.description = description;
        setQuantity(quantity);
    }
       
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
    
    // Mutator for price, prevents setting a negative value for price var
    public boolean setPrice(double price) {
        boolean priceChanged = false;
        // change price if positive
        if(price > 0) {
            this.price = price;
            priceChanged = true;
        }

        // given price variable is negative, don't change price, return false 
        return priceChanged;
    }
     
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

    // Mutator for quantity, prevents setting a negative value for price var
    public boolean setQuantity(int quantity) {
        boolean quantityChanged = false;

        // change quantity if positive
        if(quantity > 0) {
            this.quantity = quantity;
            quantityChanged = true;
        }

        // given quantity variable is negative, don't change price, return false 
        return quantityChanged;
    }

    //---------------------------------------
    // returns a String of all attributes
    @Override
    public String toString() {
        return String.format("%nItem: %s" +
                             "%nDescription: %s" +
                             "%nBarcode: %s" + 
                             "%nQuantity: %d" + 
                             "%nPrice: $%.2f %n", 
                             name, description, barCode, quantity, price);              
    }

    //***********************************************************************
    // comapres two object's barcodes. returns true if they match.
    @Override
    public boolean equals(Object o) {
        boolean match = false;

        // typecast into Item object
        if(o instanceof Object) {
            Item i = (Item) o;      

            // after safely typecasting, check if object's barcode matches, return true if they match
            if(this.getBarCode() == i.getBarCode()) {
                match = true;
            }
        }
        return match;
    }
    //*********************************************************************************
    // Calculates total price of the item by multiplting price by quantity
    public double getTotal() {
        double totalPrice;
        totalPrice = (double)(price * quantity);
        return totalPrice;
    }
}

class OnlineItem extends Item {
     
    // Instance variables 
    private double weight;      // to calculate shipping costs
    
    //**************************************************************************************************
    /*constructor : make sure to refrence the constructor in the Item class by using the super keyword
    this constructor gets the following as the list of its parameters
    String bar, String name, String description, int quantity, double price, double weight*/
    
    // Null constructor for testing
    public OnlineItem() {
    }

    // Full constructor
    public OnlineItem(String barCode, double price, String name, String description, int quantity, double weight) {
        super(barCode, price, name, description, quantity);
        this.weight = weight;
    }  
    //******************************************************
    // Accessor and Mutator method

    // Accessor for weight, gets weight by multiplying weight by quantity
    public double getWeight() {
        return weight * getQuantity();
    }

    // Mutator for weight
    public void setWeight(double weight) {
        this.weight = weight;
    }
     
    //************************************************************
    // Returns a string of all attributes and the total cost
    @Override
    public String toString() {
        return super.toString() + String.format("Total: $%.2f", getTotal());
    }
}
 
/* this class does not extend any other classes. there is a Has-a relationship between this class and the onlineItem class*/
class Cart {
    
    // Constants & Instance Variables
    public static final double SHIPPING_COST_PER_POUND = 1.50;  // shipping cost per pound
    private double discount;                                    // calculated based on purchased amount
    ArrayList<OnlineItem> list;                                 // = new ArrayList<>(); ???
     
    //*******************************************************************************
    /* constructor: instantiates the ArrayLits list*/

    // Null constructor for testing
    public Cart() {
    }

    // Full constructor
    public Cart(double discount, ArrayList<OnlineItem> list) {
        this.discount = discount;
        this.list = new ArrayList<>();
    }

    //**************************************************
    // Accessor and Mutator Methods
    
    // Accessor for discount
    public double getDiscount() {
        return this.discount;
    }

    // Special Mutator for discount; listed below
    //---------------------------------------
    //getter method getList method that returns the refrence to the list of the items purchased.*/

    // Accessor for list
    public ArrayList<OnlineItem> getList() {
        return this.list;
    }

    //*******************************************************
    /*This remove method removes an item from the ArrayList based on the barcode*/

    // NEED MY OWN EXPLANATION ...
    public boolean remove(String barcode) {
        boolean removedBarcode = false;
        
        // iterate through list to find matching barcode
        for(OnlineItem i : list) {
            // if the barcode is in our list, remove it, return true
            if(i.getBarCode() == barcode) {
                list.remove(i);
                removedBarcode = true;
            }
        }
        // else, given barcode does not exist in list, return false
        return removedBarcode;
    }
    //******************************************************************
    /* This method gets the info for an item such as as barcode,description, quantity,price, weight as its paramter
    create an object of OnlineItem
    add the created objct to the end of the list
    */

    // NEED MY OWN EXPLANATION ...
    public void add(String barcode, double price, String name, String description, int quantity, double weight) {

        // Create a new object with given arguments
        OnlineItem newItem = new OnlineItem(barcode, price, name, description, quantity, weight);

        // add new object to list
        this.list.add(newItem);
    }
    //****************************************************************
    // displays the checkout reciept for all items. includes discounts, tax, and shipping fees 
    public void checkout() {
        double taxOwed;
        double totalCost;               // applies tax, and shipping fees
        double discountedTotalCost;     // applies discount, tax, and shipping fees
        String shippingCostMsg;

        // calculate tax, discount, and shipping fees
        taxOwed = totalPurchaseAmount() * 7.75/100;
        totalCost = totalPurchaseAmount() + shippingCost() + taxOwed;
        discountedTotalCost =  (totalPurchaseAmount() + shippingCost() + taxOwed) - getDiscount();

        // determines what shipping message to display

        // no shipping cost
        if(shippingCost() == 0) {
            shippingCostMsg = "Free shipping";
        }

        // if there is a shipping cost, display the cost into message
        else {
            shippingCostMsg = String.format("Shipping cost: $%.2f", shippingCost()) ;
        }

        System.out.println();
        System.out.println("-".repeat(10) + "Checkout Reciept" + "-".repeat(10));
        System.out.println(toString());                      // displays each item's info
        System.out.printf("%nSubtotal: $%.2f" + 
                          "%nTax: $%.2f" + 
                          "%n%s" +                           // "free shipping" or the shipping cost
                          "%nAmount due: $%.2f" +            // after taxes and shipping, but BEFORE discount
                          "%nDiscount amount: $%.2f" +
                          "%nTotal cost AFTER discount, shipping, and taxes: $%.2f %n",
                          totalPurchaseAmount(), taxOwed, shippingCostMsg, totalCost, getDiscount(), discountedTotalCost);
        System.out.println("-".repeat(36));
    }

    //***************************************************************
    // changes the quantity of a specific item 
    public boolean changeQuantity(String barcode, int quantity) {
        boolean quantityChanged = false;
        String quantityChangedMsg = "item not found";

        // iterate through list to find matching barcode
        for(OnlineItem s : list) {

            // if there is a matching barcode, change the quantity of the matching item, return true
            if(s.getBarCode() == barcode) {
                s.setQuantity(quantity);
                quantityChanged = true;
                quantityChangedMsg = String.format("Updated list. Changed item quantity with the barcode: %s", barcode);
            }
            // else, no matching barcode. don't modify anything, return false
        }
        System.out.println(quantityChangedMsg);
        return quantityChanged;
    }

    //***************************************************************
    /*This toString method creates a String representing all the items in the person's list
    a for loop is needed to go through the list and call the tostring method on each item. 
    Creating a String representing all the items in the list, finally returns the string
    inside the loop: list.get(i).toString()
    */
    
    @Override
    public String toString() {
        String listString = "";

        for(OnlineItem i : list) {
            listString += i.toString() + "\n---------";
        }
        return listString;
    }
    
    // calculates the total cost of all items in the list BEFORE shipping, and discount
    public double totalPurchaseAmount() {
        double totalCost = 0;
        
        // iterate through entire list and add the totals together
        for(OnlineItem i : list) {
            totalCost += i.getTotal();
        }
        return totalCost;
    }
    
    //***************************************************************
    // calculates the total weight of all items in the list
    public double totalWeight() {
        double totalWeight = 0;

        // iterate through entire list and add all the weights together
        for(OnlineItem i : list) {
            totalWeight += i.getWeight();
        }
        return totalWeight;
    }
    
    //******************************************************************
    // calculates shipping cost depending on total price of an order
    public double shippingCost() {
        double shippingCost = 0;
        
        // free shipping for orders >= $75
        if(totalPurchaseAmount() >= 75) {
        }

        // else, apply shipping for orders < $75
        else {
            shippingCost = totalWeight() * SHIPPING_COST_PER_POUND;
        }

        return shippingCost;
    }

    //******************************************************************
    // calculates the discount based on total price
    public double discount() {
        double discount = 0;

        // purchases up to $99 get 5% off
        if(totalPurchaseAmount() <= 99) {
            discount = (double)(totalPurchaseAmount() * 5/100);
        }

        // purchases from $100-$199 get 10% off
        else if((totalPurchaseAmount() >= 100) && (totalPurchaseAmount() <= 199)) {
            discount = (double)(totalPurchaseAmount() * 10/100);
        }

        // purchases from $200-$299 get 15% off
        else if((totalPurchaseAmount() >= 200) && (totalPurchaseAmount() <= 299)) {
            discount = (double)(totalPurchaseAmount() * 15/100);
        }

        // purchases from $300-$399 get 20% off
        else if((totalPurchaseAmount() >= 300) && (totalPurchaseAmount() <= 399)) {
            discount = (double)(totalPurchaseAmount() * 20/100);
        }

        // purchases >= $400 get 25% off
        else {
            discount = (double)(totalPurchaseAmount() * 25/100);
        }
        return discount;
    }
    //******************************************************************
    
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
class OnlineShoppingCartDriver {
   public static void main(String[] args) {
    ArrayList<OnlineItem> list = new ArrayList<>();

      Cart c1 = new Cart(5.50, list);
      c1.add("123456", 12.99, "bacon", "pork product", 2, 1.24); 
      c1.add("123454", 2.99, "gum", "for your chewing needs", 1, 0.53);
      c1.add("127532", 45.99, "Mini-fridge", "a small container to store food and drinks", 1, 30.5); 

      System.out.print(c1.toString());
      c1.checkout();
    }
}