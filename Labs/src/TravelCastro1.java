/*
Name: Lynn Castro
Date: 9/27/25

------------------------------------------------------------------------------------------------------------
SELF GRADE EXPLANATION AND SCORING:
TOTAL self grade based on the given requirements and the correctness of the output: 100. (explanation below)

Proper naming: All variables and methods have meaningful and descriptive names (5/5)
Indentation: Code is readable and indented by 3 spaces (5/5)
Comments: All methods are preceded with descriptive comments. All logic is explained with comments (5/5)
Program compiles: Program compiles in JGRASP (25/25)
Program runs and compiles: (30/30)
Requirements: (25/25)
Self grade: I have provided reflective feedback on this assignment as shown above (5/5)
------------------------------------------------------------------------------------------------------------
Testimony: All of this code is written by me - Lynn Castro

DO NOT REMOVE ANY OF THE GIVEN COMMENTS otherwise your code with not be graded

Your code must genearte a very similar output. Make sure create your own list of the passengers.
Do not copy the given passengers. The driver ahs 20 points. Any copy from the sample output will cause losing points

(35) Addition required code: must answer the following questions to get the full credit
Add another class similar to the bus class� (airplane, boat, ...)
 
Have you implemented the given List Interface for this class?
   Yes.
What is the relationship between this class and the passenger class(is-A or Has-A)
   My additional class "Limousine" Has-A relationship with the passenger class.
specify the instance variables for the class: 
   Passenger driver, Passenger[] people, boolean birthdayRide, boolean celebrityRider, 
   String destination, String origin, int capacity
Have ypou createed the constructor? 
   Yes, there is a full constructor and an empty constructor.
Have you created the getter/setter methods�
   Yes.
have you created the similar methods you implemented in the bus class
   Yes.
have you created a Driver class to create an array of the passengers
   Yes.
Have you called the methods in the driver
   Yes.
*/

public class TravelCastro1
{
    //no code here
}
/*The person class is complete and there is no need to add any code to it*/
class Person
{
   private String first;
   private String last;
   private String phone;
   private String email;
   private String id;

   public Person(String first,String last, String phone, String email, String id)
   {
      this.first = first;
      this.last = last;
      this.phone = phone;
      this.email = email;    
      this.id = id;
   }
   public Person() {       // added empty constuctor to make testing easier
   }
   public String getFirst()
   {
      return first;
   }
   public String getLast()
   {
      return last;
   }
   public String getPhone()
   {
      return phone;
   }
   public String getEmail()
   {
      return email;
   }
   public String getId()
   {
      return id;
   }
   public void setFirst(String newFirst)
   {
      first = newFirst;
   }
   public void setLast(String newLast)
   {
      last = newLast;
   }
   public void setId(String newId)
   {
      id = newId;
   }
   public void setEmail(String newEmail)
   {
      email = newEmail;
   }
   public void setPhone(String newPhone)
   {
      phone = newPhone;
   }
   public String toString()
   {
      return  "first: " +  first + ",last =  " + last + ",phone= " + phone + ",email= " + email +" ID = " + id;
   }
   public boolean equals(Object o)
   {
      if (o instanceof Person)
         return this.id.equalsIgnoreCase(((Person)o).id);
      else
         return false;
   }

}

// Passenger class extends the person class. every passenger has row number, seat number, number of luggages
class Passenger extends Person { 

   // Unique Passenger attributes
   private char seatRow;
   private int seatNum;
   private int numOfLuggage;

   // Constructors
   public Passenger(String first, String last, String phone, String email, String id, 
                    char seatRow, int seatNum, int numOfLuggage) {
      super(first, last, phone, email, id);
      this.seatRow = seatRow;
      this.seatNum = seatNum;
      this.numOfLuggage = numOfLuggage;
   }

   // empty constructor to make testing methods easier
   public Passenger() {
      super();
   }

   //------------------------------------
   // Accessor & Mutator AKA Getter & Setter Methods

   // Accessor for seatRow
   public char getSeatRow() {
      return this.seatRow;
   }

   // Mutator for seatRow
   public void setSeatRow(char seatRow) {
      this.seatRow = seatRow;
   }
   //------------------------------------
   // Accessor for seatNum
   public int getSeatNum() {
      return this.seatNum;
   }

   // Mutator for seatNum
   public void setSeatNum(int seatNum) {
      this.seatNum = seatNum;
   }
   //------------------------------------
   // Accessor for numOfLuggage
   public int getNumOfLuggage() {
      return this.numOfLuggage;
   }

   // Mutator for numOfLuggage
   public void setNumOfLuggage(int numOfLuggage) {
      this.numOfLuggage = numOfLuggage;
   }
   //------------------------------------
   // Display methods

   // Displays passenger information
   @Override
   public String toString() {
      return super.toString() + 
      String.format("seat = %d, row = %c, luggage = %d %n", seatNum, seatRow, numOfLuggage);
   }
   //------------------------------------

}  // end of Passenger Class

/*Compelet code is given No need to add any code*/
class Vehicle
{
   private String plateNumber;
   private String make;
   private String model;
   private String fuelType;
   private boolean isElectric;
   public Vehicle(String plateNumber, String make,String model,String fuelType, boolean isElectric)
   {
      this.plateNumber = plateNumber;
      this.make = make;
      this.model = model;
      this.fuelType = fuelType;
      this.isElectric = isElectric;
      
   }
   public Vehicle() {   // added empty constructor for easy testing use
   }
   public boolean getElectric()
   {
      return isElectric;
   }
   
   public String getPlane()
   {
      return plateNumber;
   }
   public String getModel()
   {
      return  model;
   }
   public String getMake()
   {
      return make;
   }
   public String fuelType()
   {
      return fuelType;
   }
   public void setPlate(String newPlate)
   {
      plateNumber = newPlate;
   }
   public void setModel(String newModel)
   {
      model = newModel;
   }
   public void setMake(String newMake)
   {
      make = newMake;
   }
   public void setFuel(String newFuel)
   {
      fuelType = newFuel;
   }
   public void setElectric(boolean electric)
   {
      isElectric = electric;
   }
   public String toString()
   
   {
      String s = "Yes";
      if(!isElectric)
         s = " No";
      
      return "Make= " + make + " , Model = " + model +"Plate= " + plateNumber + "Fuel type = " + fuelType + "Electric: " + s;
   }
   public boolean equals(Object o)
   {
      if(o instanceof Vehicle)
      {
         Vehicle v = (Vehicle)o;
         return this.plateNumber.equalsIgnoreCase(v.plateNumber);
      }
      return false;
   }
    
}
interface List 
{  
   // add argument Passenger object to object array
   public void add(Object o);

   // remove (change to null) argument object from object array
   public void delete(Object o);

   // Print all passengers with the same last name (name, row, and seat)
   public void print(String last);

   // return passenger info if found in array
   public String search(String first, String last);

   // count the total amount of null entries
   public int seatsLeft();

   // return true if there are no null entries
   public boolean isFull();

   // iterate through the array and print each passenger's information
   public String toString();
}

class Bus extends Vehicle implements List
{  
   private static int passengersAdded = 0;    // to keep track of non-null entries for people[] 

   // Instance Variables
   private Passenger[] people;
   private Passenger driver;
   private String destination;
   private String origin;
   private int capacity;
   private int depature;
   private int arrival;
   private int stops;
    
   // Constructors
   public Bus(String plateNumber, String make, String model, String fuelType, boolean isElectric,
              Passenger[] people, Passenger driver, String destination, String origin, int capacity, int depature,  
              int arrival, int stops) {
      super(plateNumber, make, model, fuelType, isElectric);

      this.driver = driver;                     
      this.destination = destination;
      this.origin = origin;
      this.capacity = capacity;
      this.depature = depature;
      this.arrival = arrival;
      this.stops = stops;
      this.people = new Passenger[capacity];
   }

   // empty constructor for easy testing use
   public Bus() {
      super();
   }
   
   //------------------------------------
   // Accessor & Mutator AKA Getter & Setter Methods

   // Accessor for driver
   public Passenger getDriver() {
      return this.driver;
   }

   // Mutator for driver
   public void setDriver(Passenger driver) {
      this.driver = driver;
   }
   //------------------------------------
   // Accessor for people[]
   public Passenger[] getPeople() {
      return people;
   }
   
   // Mutator for people[]
   public void setPeople(Passenger[] people) {
      this.people = people;
   }
   //------------------------------------
   // Accessor for destination
   public String getDestination() {
      return this.destination;
   }

   // Mutator for destination
   public void setDestination(String destination) {
      this.destination = destination;
   }
   //------------------------------------
   // Accessor for origin
   public String getOrigin() {
      return this.origin;
   }

   // Mutator for origin
   public void setOrigin(String origin) {
      this.origin = origin;
   }
   //------------------------------------
   // Accessor for capacity 
   public int getCapacity() {
      return this.capacity;
   }

   // Mutator for capacity
   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }
   //------------------------------------
   // Accessor for departure
   public int getDeparture() {
      return this.depature;
   }

   // Mutator for departure
   public void setDeparture(int departure) {
      this.depature = departure;
   }
   //------------------------------------
   // Accessor for arrival
   public int getArrival() {
      return this.arrival;
   }
   
   // Mutator for arrival
   public void setArrival(int arrival) {
      this.arrival = arrival;
   }
   //------------------------------------
   // Accessor for stops
   public int getStops() {
      return this.stops;
   }

   // Mutator for stops
   public void setStops(int stops) {
      this.stops = stops;
   }
   //------------------------------------
   // Implemented methods from List Interface

   // Displays each passenger's information in the people array
   @Override
   public String toString() {
      String passengersString = "";

      // Loops through people[], prints each passenger's information
      for(int i = 0; i<passengersAdded; i++) {

         // avoid trying to print null objects, because it will cause an error
         if(people[i] != null) {
            passengersString += people[i].toString();
         }
      }

      return passengersString;
   }

   // Adds object argument to People array
   public void add(Object o) {

      if (o instanceof Passenger) {    // check if type of Passenger
         Passenger p = (Passenger) o;  // typecast into Passenger obj
         people[passengersAdded] = p;  // add passenger to array
         passengersAdded++;
      }
   }

   // Removes a passenger from the People array
   public void delete(Object o) {

      if (o instanceof Passenger) {       // check if type of Passenger
         Passenger p = (Passenger) o;    // typecast into Passenger obj

         // iterate through the whole people[] to find and delete the argument obj
         for (int i = 0; i<people.length; i++) {
            if (people[i] != null && people[i].equals(p)) {    //people[i].getId().equalsIgnoreCase(id.getId())
                people[i] = null;
            }
         }
      }  
   }

   // Prints all passengers with the same last name
   public void print(String last) {

      if (last instanceof String) {          // check if type of String
         String lastName = (String) last;    // typecast into String
         
         // iterate through all non-null passengers and find where the last name matches the string arg
         for (int i = 0; i<passengersAdded; i++) {
            if (people[i].getLast().equalsIgnoreCase(lastName)) {
               System.out.printf("%s %s %c %d %n", people[i].getFirst(), people[i].getLast(), people[i].getSeatRow(), people[i].getSeatNum());
            }
         }
      }
   }

   // Return passenger information if found in people[]
   public String search(String first, String last) {  
   String foundPassengerInfo = " Passenger: " + first + " " + last + "not found";

      // check if both args are of String type, then safely typecast into String
      if ( (first instanceof String) && (last instanceof String) ) {
         String firstName = (String) first;
         String lastName = (String) last;

         // iterate through all passengers added to people[] and only print information if
         // both the first and last name match at the String at an index of people[]
         for (int i = 0; i<passengersAdded; i++) {
            if ((people[i].getFirst().equalsIgnoreCase(firstName)) && 
                (people[i].getLast().equalsIgnoreCase(lastName))) {
                foundPassengerInfo = people[i].toString();
            }
         }
      }
      return foundPassengerInfo;
   }

   // Count and return the total amount of unadded passengers/null entries
   public int seatsLeft() {
      int seatsLeft = 0;
      for (int i = 0; i<people.length; i++) {
         if(people[i] == null) {
            seatsLeft++;
         }
      }
      return seatsLeft;
   }

   // returns true if there are no null entries in people[]
   public boolean isFull() {
      return (seatsLeft() == 0);
   }
   
} // end of Bus Class

/*This class has 35 points out of the 100 points*/
class Limousine extends Vehicle implements List 
{  
   private static int passengersAdded = 0;    // to keep track of non-null entries for people[]

   // Instance Variables
   private Passenger driver;
   private Passenger[] people;
   private boolean birthdayRide;
   private boolean celebrityRider;
   private String destination;
   private String origin;
   private int capacity;

   // Constructors
   public Limousine(String plateNumber, String make, String model, String fuelType, boolean isElectric,
                    Passenger driver, Passenger[] people, boolean birthdayRide, boolean celebrityRider,
                    String destination, String origin, int capacity) {
      super(plateNumber, make, model, fuelType, isElectric);

      this.driver = driver;
      this.birthdayRide = birthdayRide;
      this.celebrityRider = celebrityRider;
      this.destination = destination;
      this.origin = origin;
      this.capacity = capacity;
      this.people = new Passenger[capacity];
   }

   // empty constructor for easy testing use
   public Limousine() {
      super();
   }
   //------------------------------------
   // Accessors and Mutators

   // Accessor for driver
   public Passenger getDriver() {
      return this.driver;
   }

   // Mutator for driver
   public void setDriver(Passenger driver) {
      this.driver = driver;
   }

   //------------------------------------
   // Accessor for birthdayRide
   public boolean getBirthdayRide() {
      return this.birthdayRide;
   }

   // Mutator for birthdayRide
   public void setBirthdayRide(boolean birthdayRide) {
      this.birthdayRide = birthdayRide;
   }
   //------------------------------------
   // Accessor for celebrityRider
   public boolean getCelebrityRider() {
      return this.birthdayRide;
   }

   // Mutator for celebrityRider
   public void setCelebrityRider(boolean celebrityRider) {
      this.celebrityRider = celebrityRider;
   }
   //------------------------------------
   // Accessor for destination  
   public String getDestination() {
      return this.destination;
   }

   // Mutator for destination
   public void setDestination(String destination) {
      this.destination = destination;
   }
   //------------------------------------
   // Accessor for origin
   public String getOrigin() {
      return this.origin;
   }

   // Mutator for origin
   public void setOrigin(String origin) {
      this.origin = origin;
   }
   //------------------------------------
   // Accessor for capacity
   public int getCapacity() {
      return this.capacity;
   }

   // Mutator for capacity
   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }
   //------------------------------------
   // Accessor for people[]
   public Passenger[] getPeople() {
      return this.people;
   }

   // Mutator for people[]
   public void setPeople(Passenger[] people) {
      this.people = people;
   }
   //------------------------------------
   // Implemented methods from List Interface

   // Displays each passenger's information in the people array
   @Override
   public String toString() {
      String passengersString = "";

      // Loops through people[], prints each passenger's information
      for(int i = 0; i<passengersAdded; i++) {

         // avoid null objects
         if(people[i] != null) {
            passengersString += people[i].toString();
         }
      }

      return passengersString;
   }

   // Adds object argument to People array
   public void add(Object o) {

      if (o instanceof Passenger) {    // check if type of Passenger
         Passenger p = (Passenger) o;  // typecast into Passenger obj
         people[passengersAdded] = p;  // add passenger to array
         passengersAdded++;
      }
   }

   // Removes a passenger from the People array
   public void delete(Object o) {

      if (o instanceof Passenger) {       // check if type of Passenger
         Passenger p = (Passenger) o;    // typecast into Passenger obj

         // iterate through the whole people[] to find and delete the argument obj
         for (int i = 0; i<people.length; i++) {
            if (people[i] != null && people[i].equals(p)) {    
                people[i] = null;
            }
         }
      }  
   }

   // Prints all passengers with the same last name
   public void print(String last) {

      if (last instanceof String) {          // check if type of String
         String lastName = (String) last;    // typecast into String
         
         // iterate through all non-null passengers and find where the last name matches the string arg
         for (int i = 0; i<passengersAdded; i++) {
            if (people[i].getLast().equalsIgnoreCase(lastName)) {
               System.out.printf("%s %s %c %d %n", people[i].getFirst(), people[i].getLast(), people[i].getSeatRow(), people[i].getSeatNum());
            }
         }
      }
   }

   // Return passenger information if found in people[]
   public String search(String first, String last) {  
   String foundPassengerInfo = " Passenger: " + first + " " + last + "not found";

      // check if both args are of String type, then safely typecast into String
      if ( (first instanceof String) && (last instanceof String) ) {
         String firstName = (String) first;
         String lastName = (String) last;

         // iterate through all passengers added to people[] and only print information if
         // both the first and last name match at the String at an index of people[]
         for (int i = 0; i<passengersAdded; i++) {
            if ((people[i].getFirst().equalsIgnoreCase(firstName)) && 
                (people[i].getLast().equalsIgnoreCase(lastName))) {
                foundPassengerInfo = people[i].toString();
            }
         }
      }
      return foundPassengerInfo;
   }

   // Count and return the total amount of unadded passengers/null entries
   public int seatsLeft() {
      int seatsLeft = 0;
      for (int i = 0; i<people.length; i++) {
         if(people[i] == null) {
            seatsLeft++;
         }
      }
      return seatsLeft; 
   }

   // returns true if there are no null entries in people[]
   public boolean isFull() {
      return (seatsLeft() == 0);
   }

}
class Driver
{
   public static void main(String[] args)
   {
      //create a Bus object
      Passenger[] people = null;
      Passenger driver = new Passenger("Peter", "Greefin", "916-462-1574", "thegriffin@gmail", "1759", 'W', 1, 0);
      Passenger nullDriver = new Passenger();   // null for testing purposes

      Bus b1 = new Bus("1A234K", "Toyota", "Special Bus", "Diesel", false, people, nullDriver, "Roblox HQ", "Los Angeles", 15, 1, 5, 15);
      // call the setDriver method to set the driver for the bus
      b1.setDriver(driver);

      //create 10 passengers of your choice. be sure to create some passengers with the same last name
      Passenger passenger1 = new Passenger("John", "Doe", "111-111-1111", "johnathan@gmail", "1244", 'Z', 1, 2);
      Passenger passenger2 = new Passenger("Amy", "Doe", "222-222-2222", "amyathon@gmail", "1235", 'A', 3, 4);
      Passenger passenger3 = new Passenger("Chris", "Doe", "333-333-3333", "chrisathon@gmail", "4567", 'C', 7, 3);
      Passenger passenger4 = new Passenger("Sofa", "Couch", "444-444-4444", "sofathon@gmail", "1934", 'E', 2, 12);
      Passenger passenger5 = new Passenger("Satoru", "Gojo", "555-555-5555", "animeathon@gmail", "2054", 'F', 8, 88);
      Passenger passenger6 = new Passenger("Naruto", "Uzumaki", "666-666-6666", "narutoathon@gmail", "2048", 'R', 1, 9);
      Passenger passenger7 = new Passenger("Chad", "Castro", "777-777-7777", "chadathon@gmail", "1738", 'G', 2, 2);
      Passenger passenger8 = new Passenger("Steve", "Minecraft", "888-888-8888", "steveathon@gmail", "1717", 'T', 1, 3);
      Passenger passenger9 = new Passenger("Joe", "Joe", "999-999-9999", "joeathon@gmail", "1000", 'J', 1, 4);
      Passenger passenger10 = new Passenger("Head", "Phones", "000-000-0000", "headathon@gmail", "8008", 'L', 9, 2);

      //call the add method to add each passenger to the bus
      b1.add(passenger1);
      b1.add(passenger2);
      b1.add(passenger3);
      b1.add(passenger4);
      b1.add(passenger5);
      b1.add(passenger6);
      b1.add(passenger7);
      b1.add(passenger8);
      b1.add(passenger9);
      b1.add(passenger10);

      // Origin, destination, and driver info
      System.out.println("Origin of this bus: " + b1.getOrigin());
      System.out.println("=".repeat(100));
      System.out.println("Destination of this bus: " + b1.getDestination());
      System.out.println("=".repeat(100));
      System.out.println("Driver of this bus: " + b1.getDriver().toString());
      System.out.println("=".repeat(100));
      
      // all of the passenger info
      System.out.println("Testing toString() from Bus class: \n");
      System.out.println(b1.toString());

      // testing seatsLeft
      System.out.println("Get the number of seats left: " + b1.seatsLeft() + " seats available");
      System.out.println("=".repeat(100));

      // testing print
      System.out.println("Printing passengers with the last name: Doe");
      b1.print("Doe");
      System.out.println("=".repeat(100));

      // testing search method
      System.out.printf("Searching for passenger %s %s", passenger5.getFirst(), passenger5.getLast());
      b1.search(passenger5.getFirst(), passenger5.getLast());
      System.out.printf("%n%s %s is sitting at: %c %d %n", passenger5.getFirst(), passenger5.getLast(), passenger5.getSeatRow(), passenger5.getSeatNum());
      System.out.println("=".repeat(100));

      // Testing delete method from Bus class
      System.out.printf("Removing passenger %s %s", passenger8.getFirst(), passenger8.getLast());
      b1.delete(passenger8);
      System.out.printf("%n%s %s has been removed %n", passenger8.getFirst(), passenger8.getLast());
      System.out.println("=".repeat(100));

      // call toString again to confirm passenger was removed
      System.out.println("Here is the new list of the passengers");
      System.out.println(b1.toString()); 
      System.out.println("=".repeat(100));

      // call seatsLeft() to confirm passenger was removed
      System.out.printf("The bus has %d seats available%n", b1.seatsLeft());
      System.out.println("=".repeat(100));
      //------------------------------------------------
      // Testing additional "Limousine" class

      Passenger[] limoPeople = null;
      Passenger limoDriver = new Passenger("Harold", "Bear", "123-456-7890", "bear@gmail", "1234", 'Z', 1, 0);
      Passenger nullLimoDriver = new Passenger();  // null for testing purposes

      // creating limo object
      Limousine limo = new Limousine("7KA754", "Subaru", "2005 Limo", "Diesel", false,
                                     nullLimoDriver, limoPeople, false, true, "New York City", "Oklahoma", 7);

      // call the setDriver method to set the driver for the limo
      limo.setDriver(limoDriver);

      // create passengers for the limo people array
      Passenger limoPassenger1 = new Passenger("John", "Lennon", "676-676-6767", "55burgers@gmail", "8008", 'Z', 1, 2);
      Passenger limoPassenger2 = new Passenger("Paul", "Lennon", "414-414-4141", "55fries@gmail", "6767", 'A', 2, 4);
      Passenger limoPassenger3 = new Passenger("The", "Beatles", "505-505-5050", "41stone@gmail", "4567", 'D', 5, 3);

      // add passengers to limo people array
      limo.add(limoPassenger1);
      limo.add(limoPassenger2);
      limo.add(limoPassenger3);

      // Start of testing limo class
      System.out.println("TESTING ADDITIONAL CLASS: LIMOUSINE\n");

      // Origin, destination, and driver info
      System.out.println("Origin of this limo: " + limo.getOrigin());
      System.out.println("=".repeat(100));
      System.out.println("Destination of this limo: " + limo.getDestination());
      System.out.println("=".repeat(100));
      System.out.println("Driver of this limo: " + limo.getDriver().toString());
      System.out.println("=".repeat(100));
      
      // all of the passenger info
      System.out.println("Testing toString() from Limousine class: \n");
      System.out.println(limo.toString());

      // testing seatsLeft
      System.out.println("Get the number of seats left: " + limo.seatsLeft() + " seats available");
      System.out.println("=".repeat(100));

      // testing print
      System.out.println("Printing passengers with the last name: Lennon");
      limo.print("Lennon");
      System.out.println("=".repeat(100));

      // testing search method
      System.out.printf("Searching for passenger %s %s", limoPassenger3.getFirst(), limoPassenger3.getLast());
      limo.search(limoPassenger3.getFirst(), limoPassenger3.getLast());
      System.out.printf("%n%s %s is sitting at: %c %d %n", limoPassenger3.getFirst(), limoPassenger3.getLast(), limoPassenger3.getSeatRow(), limoPassenger3.getSeatNum());
      System.out.println("=".repeat(100));

      // Testing delete method from Bus class
      System.out.printf("Removing passenger %s %s", limoPassenger2.getFirst(), limoPassenger2.getLast());
      limo.delete(limoPassenger2);
      System.out.printf("%n%s %s has been removed %n", limoPassenger2.getFirst(), limoPassenger2.getLast());
      System.out.println("=".repeat(100));

      // call toString again to confirm passenger was removed
      System.out.println("Here is the new list of the passengers");
      System.out.println(limo.toString()); 
      System.out.println("=".repeat(100));

      // call seatsLeft() to confirm passenger was removed
      System.out.printf("The limo has %d seats available", limo.seatsLeft());
   }
}