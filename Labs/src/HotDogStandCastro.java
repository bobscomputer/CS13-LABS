/*
 * Name: Lynn Castro
 * Description: Demonstrating my understanding of UML Class Diagram by creating my own Class.
 * Date: 9/12/25
 * 
 * Proper naming: All variables have meaningful and descriptive names --> 5
 * Indentation: All code is organized by 4 space tabbing --> 5
 * Comments: All data and methods are explained with comments preceding them --> 5
 * Program compiles: Program compiles in JGrasp --> 25
 * Program runs & matches sample output: Program runs in JGrasp, and is similar, but not an exact copy of sample output, but has added features --> 25
 * Requirements: I added two instance variables and two methods, in which the methods utilize the new instance variables. 
 *               Constructor is created, all accessor and mutator methods are provided, all utility methods are created, driver class tests a few methods
 *               and my additional methods. --> 25
 * Self-grade: I have provided reflective commentary on my program --> 5
 * 
 * Self-grade total: 95
 * 
 * Any code submitted based on  the requirmnets from the previous semester will get zero points. 
 * Testimony: All the code is written by myself and I have not copied the code from any resources. Name: Lynn Castro
 *
 * Answer the following questions:
 * 1. what attributes did you add? How is it related to the hotdog class?
 * 
 * I added 2 instances variables: int employees and int hoursWorked. 
 * The employees and hoursWorked variables allow the user to calculate pay per hour, which would affect total income.
 * 
 * 2. what is the method you added? How is it related to the hotdog class
 * 
 * I added a method called EmployeePay(), which calculates the total pay owed to workers based on:
 * minimum wage, number of employees, and number of hours worked for one day.
 * I also added a method called NetIncome(), which calculates the net income after subtracting ingredients cost, taxes, and paying employees
 * The EmployeePay() method uses the data from the HotDogStand class to accurately calculate what the net income is before taxes.
 * The NetIncome() method uses the data and methods from the HotDogStand class to calculate net income, instead of calculating just gross income.
 * 
 */

import java.util.*;

public class HotDogStandCastro {
}

class HotDogStand {
    // Instance Variables
    // added instance variables: employees, hoursWorked
    private int id;
    private int countSold;
    private int employees;
    private int hoursWorked;
    private String owner;
    private String address;

    // Constants
    private final double SELL_PRICE = 3.5;
    private final double BUY_PRICE = 1.5; 
    private final double MINIMUM_WAGE = 16.5;
    private final double TAX = .1;

    //========================================================
    // default full constructor, includes added instance variables
    public HotDogStand(int id, int countSold, int employees, int hoursWorked, String owner, String address) {

        // sets obj variables to arguments in the constructor's parameter
        this.id = id;
        this.countSold = countSold;
        this.employees = employees;
        this.hoursWorked = hoursWorked;
        this.owner = owner;
        this.address = address;

        // sets default values using mutator methods
        setId(id);
        setCountSold(countSold);
        setEmployees(employees);
        setHoursWorked(hoursWorked);
        setOwner(owner);
        setAddress(address);
    }

    //========================================================
    // Accessor & Mutator Methods for each Instance Variable

    //------------------------------------------------------
    // 'id' instance var accessor
    public int getId() {
        return id;
    }
    
    // 'id' var mutator
    public void setId(int id) {
        this.id = id;
    }
    //------------------------------------------------------
    // 'countSold' instance var accessor
    public int getCountSold() {
        return countSold;
    }
    
    // 'countSold' var mutator
    public void setCountSold(int countSold) {
        this.countSold = countSold;
    }
    //------------------------------------------------------
    // 'employees' instance var accessor
    public int getEmployees() {
        return employees;
    }
    
    // 'employees' var mutator
    public void setEmployees(int employees) {
        this.employees = employees;
    }
    //------------------------------------------------------
    // 'hoursWorked' instance var accessor 
    public int getHoursWorked() {
        return hoursWorked;
    }
    
    // 'hoursWorked' var mutator
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    //------------------------------------------------------
    // 'owner' instance var accessor
    public String getOwner() {
        return owner;
    }
    
    // 'owner' var mutator
    public void setOwner(String owner) {
        this.owner = owner;
    }
    //------------------------------------------------------
    // 'address' instance var accessor
    public String getAddress() {
        return owner;
    }
    
    // 'address' var mutator
    public void setAddress(String address) {
        this.address = address;
    }
    //------------------------------------------------------

    //========================================================
    // Utility Methods

    // Increases the total amount (countSold variable) of units sold by the argument given in the parameter
    public void Order(int count) {
        countSold += count;
    }

    // Calculates the total income AFTER subtracting ingredients price for a given station, 
    // before taxes and before paying employees
    public double Income() {
        double income = 0;
        income = (SELL_PRICE * countSold) - (BUY_PRICE * countSold);
        return income;
    }

    // New additional method (1/2)
    // Calculates total pay for ALL employees based on, total employees working and hours worked at a station
    public double EmployeePay() {
        double employeePay;
        employeePay = (double)(employees * MINIMUM_WAGE * hoursWorked);
        return employeePay;
    }

    // New additional method (2/2)
    // Calculates NET pay: after paying taxes, employees, and subtracting cost of ingredients
    public double NetIncome() {
        double netIncome;
        netIncome = ((Income()) - EmployeePay()) * (1 - TAX); // subtracts employee pay from income after subtracting ingredients cost, then subtracts tax
        return netIncome;
    }


    //========================================================
    // Display Methods

    // Displays seller information about one hot dog station
    public String toString() {
        return String.format("%nStation #: %d%nOwner: %s%nAddress: %s%nHot dogs sold: %,d" +
                             "%nIncome after subtracting ingredients cost: $%,.2f%nEmployees at this station: %d" +
                             "%nTotal run-time at this station (per day): %d hours" + 
                             "%nBase pay per hour for employees: $%.2f %n", 
                             id, owner, address, countSold, Income(), employees, hoursWorked, MINIMUM_WAGE);                    
    }

    // Displays information about the methods and data this class contains
    static public void Description() {
        // "=" border
        for(int i=0; i<100; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println("This 'HotDogStand' Class has methods that display and gather the following information for your hot dog stands:" +
                           "\n-Station ID # \n-Owner name \n-Address of station # \n-Total units sold \n-Income after subtracting ingredients cost " + 
                           "(before taxes and before paying employees) \n-Net income (subtracting ingredients cost, after taxes, and after paying employees)" +
                           "\n-Total amount owed for ALL employees (per day) \n-Total work-time of Station id (per day)");

        // "=" border
        for(int i=0; i<100; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}

// testing the created methods in the HotDogStand class
class Driver {
    public static void main(String[] args) {
        // variable data needed for constructor 
        int id;
        int countSold;

        // initializations of above variables, randomly generated numbers using methods NOT in the HotDogStand class
        id = Driver.getRandNum();
        countSold = Driver.HotDogSold();

        // creating new HotDogStand object, testing our created constructor
        HotDogStand stand = new HotDogStand(id, countSold, 5, 12, "Castro", "Roblox Rd" );

        // testing HotDogStand class methods. just a few not all
        HotDogStand.Description();

        // testing toString
        System.out.println("Testing toString()");
        stand.toString();
        System.out.println(stand);

        // testing added methods
        System.out.println("Testing added methods: EmployeePay() & NetIncome()");
        System.out.printf("Total employee pay *per day* for %d employees: $%.2f", 
                          stand.getEmployees(), stand.EmployeePay()); // EmployeePay() is 1/2 added methods
        System.out.printf("%nNet income: $%,.2f", stand.NetIncome()); // NetIncome() is 2/2 added methods
    }

    // randomly generates a 3 digit ID number with unique numbers 
    // turn array into int
    public static int getRandNum() {
        int[] idArray = new int[3];
        int idNum;
        int randNum;
        int count;
        boolean[] uniqueNum = new boolean[10]; // to keep track of used numbers
        Random rand = new Random(); 

        // priming read
        count = 0;
        idNum = 0;

        // fills array with unique numbers
        while(count < 3) {
            randNum = rand.nextInt(1,10); // range is [1-9]

            // if not a duplicate number, add to array
            if(!uniqueNum[randNum]) {
                idArray[count] = randNum;
                uniqueNum[randNum] = true;
                count++;
            }

            // else, duplicate number, generate a new number until a unique number is generated
        }
        
        // turn array into int
            for(int i=0; i<idArray.length; i++) {
                idNum = (idNum*10) + idArray[i];
            }
        return idNum;
    }

    // calculates the total of hotdogs sold for 30 days. each day a number from 120-200 is sold. 
    public static int HotDogSold() {
        int totalSold;
        Random rand = new Random();
        totalSold = 0;

        // randomly generates an amount of hot dogs sold each day for 30 days
        for(int i=0; i<31; i++) {
            totalSold += rand.nextInt(120,200)+1;
        }
        return totalSold;      
    }
}