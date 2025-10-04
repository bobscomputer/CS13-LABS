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
     // constructors, avoids negative values for price and quantity: 

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
        return String.format("%nItem: %54s" +
                             "%nDescription: %47s" +
                             "%nBarcode: %51s" + 
                             "%nQuantity: %50d" + 
                             "%nPrice: $%52.2f %n", 
                             name, description, barCode, quantity, price);              
    }

    //***********************************************************************
    // comapres two object's barcodes. returns true if they match.
    @Override
    public boolean equals(Object o) {
        boolean match = false;

        // typecast into String object
        if(o instanceof Object) {
            String i = (String) o;      

            // after safely typecasting, check if object's string matches, return true if they match
            if(this.getBarCode().equals(i)) {
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
    //constructors
    
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
 
class Cart {
    
    // Constants & Instance Variables
    public static final double SHIPPING_COST_PER_POUND = 1.50;  // shipping cost per pound
    private double discount;                                    // calculated based on purchased amount
    ArrayList<OnlineItem> list;                                 
     
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
    // Removes an item from the list based on a given barcode string
    public boolean remove(String barcode) {
        boolean removedBarcode = false;
        
        // iterate through list to find matching barcode
        for(int i = 0; i<list.size(); i++) {

            // if the barcode is in our list, remove it, return true
            if(list.get(i).equals(barcode)) {
                list.remove(i);
                removedBarcode = true;
            }
        }
        // else, given barcode does not exist in list, return false
        return removedBarcode;
    }
    //******************************************************************
    // adds a new OnlineItem object to the end of the list
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
        System.out.printf("%nSubtotal: %50.2f" + 
                          "%nTax: %55.2f" + 
                          "%nShipping: %50s" +                           // "free shipping" or the shipping cost
                          "%nAmount due: %48.2f" +            // after taxes and shipping, but BEFORE discount
                          "%nDiscount amount: %43.2f" +
                          "%nTotal cost AFTER discount, shipping, and taxes: %12.2f %n",
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
            if(s.getBarCode().equals(barcode)) {
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
    // creates a string of attributes from OnlineItem from the ArrayList
    @Override
    public String toString() {
        String listString = "";

        // create a string for all items in the list
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
    // additional method 1: 
    // applies a tariff to all items or one item; tariffFee must be >= 1, 
    // example) if fee is 25% --> 1.25
    public ArrayList<OnlineItem> tariffList(boolean tariffAll, double tariffFee) {
        int currentListSize = getList().size();
        int randItem;
        Random rand = new Random();

        // applies tariff fee to all items based on the given tariff fee
        if((tariffAll) && tariffFee >= 1) {
            for(int i = 0; i<currentListSize; i++) {
                list.get(i).setPrice(list.get(i).getPrice() * tariffFee);
            }
        }

        // I wanted to get a user prompt for which item to be tariffed, but to avoid print, this uses random() instead
        // applies tariff fee to one random item based on the given tariff fee
        else if((tariffAll == false) && tariffFee >= 1) {
            randItem = rand.nextInt(0, currentListSize+1);
            list.get(randItem).setPrice(list.get(randItem).getPrice() * tariffFee);
        }

        return list;
    }

    //******************************************************************
    // additional method 2:
    // clones the entire cart or one item based on args in parameter 
    public ArrayList<OnlineItem> cloneCart(boolean cloneAll, int numClones) {
        int currentListSize = getList().size();
        int randItem;
        Random rand = new Random();

        // clones all items based by the given arg amount
        if(cloneAll && numClones > 0) {
            for (int i = 0; i<numClones; i++) {
                for (int j = 0; j<currentListSize; j++) {
                    list.add(list.get(j));
                }
            }
        }

        // I wanted to get a user prompt for which item to be cloned, but to avoid print, this uses random() instead
        // clones one random item based on the given arg amount
        else if ((cloneAll == false) && numClones > 0) {
            randItem = rand.nextInt(0, currentListSize+1);
            list.add(list.get(randItem));
        }

        return list;
    }
} // end of Cart
 
//*********************************************************************
class OnlineShoppingCartDriver {
   public static void main(String[] args) {
    ArrayList<OnlineItem> list = new ArrayList<>();

        Cart c1 = new Cart(5.50, list);
        c1.add("123456", 12.99, "bacon", "pork product", 2, 1.25); 
        c1.add("123454", 2.99, "gum", "for your chewing needs", 1, 0.09);
        c1.add("127532", 45.99, "Mini-fridge", "a small container to store food and drinks", 1, 30.5); 

        // Testing toString()
        System.out.println("*".repeat(20) + " Calling toString " + "*".repeat(20));
        System.out.print(c1.toString());
        System.out.println();

        // Testing remove()
        System.out.println("*".repeat(4) + " Testing remove(). Removing bacon: Barcode = 123456 " + "*".repeat(4));
        c1.remove("123456");
        // Display updated list
        System.out.print(c1.toString());
        System.out.println();

        // Testing add()
        System.out.println("*".repeat(12) + " Testing add(). Adding 32 oz. Pepsi " + "*".repeat(12));
        c1.add("126767", 7.99, "32 oz. Pepsi", "party size pepsi", 3, 2.3);
        // Display updated list
        System.out.print(c1.toString());
        System.out.println();

        // Changing quantity
        System.out.println("*".repeat(13) + " Updating quantity of gum to '5' " + "*".repeat(14));
        c1.getList().get(0).setQuantity(5);
        // Display updated list
        System.out.print(c1.getList().get(0).toString());
        System.out.println();

        // Testing checkout()
        System.out.println("*".repeat(20) + " Testing checkout() " + "*".repeat(20));
        c1.checkout();
        System.out.println();


        //-------------------------------------------
        // Testing additional methods
        System.out.println("*".repeat(15) + " Testing additional methods: tariffList() and cloneCart() " + "*".repeat(15));

        System.out.println("\nTesting tariffList()."); 
        System.out.println("This method takes a boolean and double value." +
                           "\nIt applies the given tariff fee to either all items in the list or one random item.\n");

        // Testing additional method #1: tariffList()
        System.out.println("Applying tariff to all items with a tariff fee of 35% (1.35). tariffList(true, 1.35)");
        c1.tariffList(true, 1.35);      

        // Display updated list
        System.out.println("Showing updated reciept ... using checkout() not toString()");
        c1.checkout();
    
        // Testing additional method #2: cloneCart()
        System.out.println("*".repeat(20) + " Testing cloneCart() " + "*".repeat(20)); 
        System.out.println("This method takes a boolean and an int value." +
                           "\nIt clones either all items and adds them to the list or clones one random item.\n" + 
                           "The int arg determines how many times to clone an item.");

        System.out.printf("%nList size before cloning: %d. ", c1.getList().size());
        System.out.println("\nCloning all items once. cloneCart(true, 1)");
        c1.cloneCart(true, 1);           

        // Display updated list
        System.out.printf("%nList size after cloning: %d. ", c1.getList().size());
        System.out.println("\nShowing updated reciept ... using checkout() not toString()");
        c1.checkout();
    }
}