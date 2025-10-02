/*
DO NOT DELETE THE FOLLOWING COMMENTS
Name: Lynn Castro
Description: Demonstrating my understanding of superclasses and subclasses by creating subclasses of a superclass
Date: 9/19/25

Testimony: I have written the code by myself without any help from the unauthorized resources. - Lynn Castro

Must answer the following question otherwise points wil be deducted
Additional required code(40 points): Add another relevant sport of your choice to the heirarchy of the classes with is-a relatopnship
Answer the followng questions:

1. what is the name of the sport you selected
    -Volleyball
2. what are the attributes that are specific to this sport(At least 4)
    -Int aces, int blocksMade, int recievesMade, int recieveAttempts, int blockAttempts
3. did you provide a costructor for your class
    -Yes
4. did you provide getter and setter for your class
    -Yes
4. did you provide the toString method and equlas method.
    -Yes
5. add two methods other than the methods mentioned above to add functionality to the code
     a. explain method 1: successfulRecievesRate() calculates the Volleyball player's recieves accuracy
     b. explain method 2: successfulBlocksRate() calculates the Volleyball player's block accuracy
6. did you create objects of this class in the main method
    -Yes
7. did you call all the methods on the object you created
    -Yes
8. did you display the result of the method calls 
    -Yes
9. None of the methods can have print/println other than the toString method
    -Yes

Selfgrade: must be based on the output, requirements, additional required codes. Anything less than 100 must be explained.
Explanations such as "needs more commnets", "needs improvment", " I think ..." are not accepted
------------------------------------------------------------
Proper naming: 5/5
Indentation: 5/5
Comments: 5/5
Program compiles: 25/25
Program runs and the output matches the provided output: 30/30
Requirements: 24/25, my additional methods are similar, but calculate different things
Selfgrade 5/5
------------------------------------------------------------

Sample output : Ignore the blue line on the right side
your output must be the exact same line by line, plus the output of the new class you added. 

Calling the tostring method
***************************************************
Name: Alex Rodriguez
Number: 123
Email: alex@google.com
Phone: 222-222-2222
Year hired: 2015
Games played: 1Salary: 195000.0
Minutes played: 20
field Goals Made: 0
field Goals Attempted: 4
Assists: 3
Steals: 5
Rebounds: 3
blocksMade: 1
Fouls: 4

Calling the getter methods
*********************************************************
Is Alex Rodriguez fouled out? Alex Rodriguez is not fouled out. he has 4 fouls
How old is Alex Rodriguez? Alex Rodriguez is 28 years old.
Is Alex Rodriguez at the retire age? Alex Rodriguez is not at the retired age
How many blocksMade does Alex Rodriguez has? 1
How many minutes has Alex Rodriguez has played? 20
What is Alex Rodriguez email address? alex@google.com
What is Alex Rodriguez phone number? 222-222-2222
How many years Alex Rodriguez has played? 10
how many field goal attempts does Alex Rodriguez have? 4
how many assists does Alex Rodriguez have? 3

*************************************************
Calling the setter methods
The object has been modified

Calling the tostring method after calling the setter methods
****************************************
Name: Alex Rodriguez
Number: 123
Email: Rod@yahoo.com
Phone: 222-222-2222
Year hired: 2015
Games played: 2
Salary: 195000.0
Minutes played: 20
field Goals Made: 0
field Goals Attempted: 4
Assists: 7
Steals: 5
Rebounds: 3
blocksMade: 3
Fouls: 7

************************************
Calling the getter methods

Is Alex Rodriguez fouled out? Alex Rodriguez is fouled out. he has 7 fouls
*/

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SportLynnCastro {
    // no code here
}

// Superclass
class Player {
    // Class Attributes, public for subclasses to use
    String playerName;
    String playerEmail;
    String playerPhone;
    double playerSalary;
    int playerNumber;
    int gamesPlayed;
    int birthYear;
    int joinYear;

    //-----------------------------------------------
    // Default Constructor
    public Player(String playerName, String playerEmail, String playerPhone, double playerSalary, 
                  int playerNumber, int gamesPlayed,  int birthYear, int joinYear) {
        
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerPhone = playerPhone;
        this.playerSalary = playerSalary;
        this.playerNumber = playerNumber;
        this.gamesPlayed = gamesPlayed;
        this.birthYear = birthYear;
        this.joinYear = joinYear;
    }

    //-----------------------------------------------
    // Accessor & Mutator Methods

    // Accessor for playerName
    public String getPlayerName() {
           return playerName;
    }

    // Mutator for playerName
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    //-----------------------------------------------
    // Accessor for playerEmail
    public String getPlayerEmail() {
        return playerEmail;
    }

    // Mutator for playerEmail
    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }
    //-----------------------------------------------
    // Accessor for playerSalary
    public double getPlayerSalary() {
        return playerSalary;
    }

    // Mutator for playerSalary
    public void setPlayerSalary(double playerSalary) {
        this.playerSalary = playerSalary;
    }
    //-----------------------------------------------
    // Accessor for playerNumber
    public int getPlayerNumber() {
        return playerNumber;
    }

    // Mutator for playerNumber
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    //-----------------------------------------------
    // Accessor for gamesPlayed
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    // Mutator for gamesPlayed
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    //-----------------------------------------------
    // Accessor for playerPhone
    public String getPlayerPhone() {
        return playerPhone;
    }

    // Mutator for playerPhone
    public void setPlayerPhone(String playerPhone) {
        this.playerPhone = playerPhone;
    }
    //-----------------------------------------------
    // Accessor for birthYear
    public int getBirthYear() {
        return birthYear;
    }

    // Mutator for birthYear
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    //-----------------------------------------------
    // Accessor for joinYear
    public int getJoinYear() {
        return joinYear;  
    }

    // Mutator for joinYear
    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }
    //-----------------------------------------------
    // Utility Methods

    // increments total games played by 1
    public void totalGamesPlayed() {
        gamesPlayed++;
    }

    // get current year
    public int getCurrentYear() {
        int currentYear;

        Instant currInstant = Instant.now();
        ZonedDateTime zonedDate = currInstant.atZone(ZoneId.systemDefault());
        currentYear = zonedDate.getYear();

        return currentYear;
    }

    // calculates the total years a player has played their sport
    public int yearsPlayed() {
        int yearsPlayed;
        yearsPlayed = getCurrentYear() - joinYear;
        return yearsPlayed;
    }

    // calculates the player's age
    public int getAge() {
        int yearsPlayed;
        yearsPlayed = getCurrentYear() - birthYear;
        return yearsPlayed;
    }
    //-----------------------------------------------
    // Display Methods

    @Override
    // returns a string of all the player's attributes, overrided toString()
    public String toString() {
        return String.format("%nName: %s %nNumber: %d %nEmail: %s %nPhone: %s " +
                             "%nYear hired: %d %nGames played: %d %nSalary: %.2f", 
                             playerName, playerNumber, playerEmail, playerPhone,
                             joinYear, gamesPlayed, playerSalary);
    }
}   // end of Player

// Subclass, has unique class attribues and methods
class BasketballPlayer extends Player {

    // Attributes for BasketballPlayer Class, private because they are special/unique to this Class
    private int minutesPlayed;
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;
    private int assistsMade;
    private int stealsMade;
    private int reboundsMade;
    private int blocksMade;
    private int foulsMade;

    //-----------------------------------------------
    // Default Constructor
    public BasketballPlayer(String playerName, String playerEmail, String playerPhone, double playerSalary, 
                            int playerNumber, int gamesPlayed,  int birthYear, int joinYear, 
                            int minutesPlayed, int fieldGoalsMade, int fieldGoalsAttempted, int assistsMade, 
                            int stealsMade, int reboundsMade, int blocksMadeMade, int foulsMade) {
        
        // uses superclass constructor to set this object's following attributes
        super(playerName, playerEmail, playerPhone, playerSalary, 
              playerNumber, gamesPlayed, birthYear, joinYear); 

        // to set the unique attributes for this class
        this.minutesPlayed = minutesPlayed;
        this.fieldGoalsMade = fieldGoalsMade;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.assistsMade = assistsMade;
        this.stealsMade = stealsMade;
        this.reboundsMade = reboundsMade;
        this.blocksMade = blocksMadeMade;
        this.foulsMade = foulsMade;
    }

    //-----------------------------------------------
    // Accessor & Mutator Methods
    
    // Accessor for minutesPlayed
    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    // Mutator for minutesPlayed 
    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }
    //-----------------------------------------------
    // Accessor for fieldGoalsMade
    public int getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    // Mutator for fieldGoalsMade
    public void setFieldGoalsMade(int fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    //-----------------------------------------------
    // Accessor for fieldGoalsAttempted
    public int getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    // Mutator for fieldGoalsAttempted
    public void setFieldGoalsAttempted(int fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }
    //-----------------------------------------------
    // Accessor for assistsMade
    public int getAssistsMade() {
        return assistsMade;
    }

    // Mutator for assistsMade
    public void setAssistsMade(int assistsMade) {
        this.assistsMade = assistsMade;
    }
    //-----------------------------------------------
    // Accessor for stealsMade
    public int getStealsMade() {
        return stealsMade;
    }

    // Mutator for stealsMade
    public void setStealsMade(int stealsMade) {
        this.stealsMade = stealsMade;
    }
    //-----------------------------------------------
    // Accessor for reboundsMade
    public int getReboundsMade() {
        return reboundsMade;
    }

    // Mutator for reboundsMade
    public void setReboundsMade(int reboundsMade) {
        this.reboundsMade = reboundsMade;
    }
    //-----------------------------------------------
    // Accessor for blocksMade
    public int getBlocksMade() {
        return blocksMade;
    }

    // Mutator for blocksMade
    public void setBlocksMade(int blocksMade) {
        this.blocksMade = blocksMade;
    }
    //-----------------------------------------------
    // Accessor for foulsMade
    public int getFoulsMade() {
        return foulsMade;
    }

    // Mutator for foulsMade
    public void setFoulsMade(int foulsMade) {
        this.foulsMade = foulsMade;
    }
    //-----------------------------------------------
    // Display Methods

    @Override
    // returns a string of all the player's attributes + specialized attributes, overrided toString()
    public String toString() {
        return super.toString() +
               String.format("%nMinutes played: %d" +
                             "%nField Goals made: %d" + 
                             "%nField Goals Attempted: %d" +
                             "%nAssists: %d" +
                             "%nSteals: %d" +
                             "%nRebounds: %d" +
                             "%nBlocks made: %d" +
                             "%nFouls: %d", 
                             minutesPlayed, fieldGoalsMade, fieldGoalsAttempted, assistsMade, 
                             stealsMade, reboundsMade, blocksMade, foulsMade);

    }

    //-----------------------------------------------
    // Specialized Methods

    // checks if player has fouled out. if player has 6 or more fouls, return true
    public String foulsOut() {
        boolean fouled;
        String fouledStatus = " not fouled out";

        fouled = (foulsMade>=6);   
        // changes foul status String if fouled is true
        if (fouled) {
            fouledStatus = " fouled out";
        }

        // else, not fouled out, don't change String
        return fouledStatus;
    }

    // checks if player is retired, returns true if player is >= retired age
    public String retiredAge() {
        boolean retired;
        String retiredStatus = " not at the retired age";
        final int RETIRED_AGE = 40;

        retired = (getAge() >= RETIRED_AGE);
        // changes retired status String if retired is true
        if (retired) {
            retiredStatus = " is at the retired age";
        }

        // else, not fouled out, don't change String
        return retiredStatus;
    }

    // additional method, calculates true shooting percentage based on:
    // (required argument) # of free throw attempts, # of field goal attempts, and # of field goals scored/made    
    public double getTrueShootingPercentage(int freeThrowAttempts) {
        double shootingPerc;
        shootingPerc = (double)(fieldGoalsMade)/(2 * (fieldGoalsAttempted + 0.44 * freeThrowAttempts)) * 100;

        return shootingPerc;
    }
}   // end of BasketballPlayer

// MY CREATED CLASS, Subclass, has unique class attribues and methods
class Volleyball extends Player {

    // Unique Attributes for Volleyball Class
    private int aces;
    private int blocksMade;
    private int recievesMade;
    private int recieveAttempts;
    private int blockAttempts;

    // Volleyball Constructor
    public Volleyball(String playerName, String playerEmail, String playerPhone, double playerSalary, 
                      int playerNumber, int gamesPlayed,  int birthYear, int joinYear,
                      int aces, int blocksMade, int recievesMade, int recieveAttempts, int blockAttempts) {

        // uses superclass constructor to set this object's following attributes
        super(playerName, playerEmail, playerPhone, playerSalary, playerNumber, 
              gamesPlayed, birthYear, joinYear);

        // to set the unique attributes for this class
        this.aces = aces;
        this.blocksMade = blocksMade;
        this.recievesMade = recievesMade;
        this.recieveAttempts = recieveAttempts;
        this.blockAttempts = blockAttempts;
    }
    //-----------------------------------------------
    // Accessor & Mutator Methods

    // Accessor for aces
    public int getAces() {
        return aces;
    }

    // Mutator for aces
    public void setAces(int aces) {
        this.aces = aces;
    }
    //-----------------------------------------------
    // Accessor for blocksMade
    public int getblocksMade() {
        return blocksMade;
    }

    // Mutator for blocksMade
    public void setblocksMade(int blocksMade) {
        this.blocksMade = blocksMade;
    }
    //-----------------------------------------------
    // Accessor for recievesMade
    public int getRecievesMade() {
        return recievesMade;
    }

    // Mutator for recievesMade
    public void setRecievesMade(int recievesMade) {
        this.recievesMade = recievesMade;
    }
    //-----------------------------------------------
    // Accessor for recieveAttempts
    public int getRecievesAttempts() {
        return recieveAttempts;
    }

    // Mutator for recievesMade
    public void setRecievesAttemps(int recieveAttempts) {
        this.recieveAttempts = recieveAttempts;
    }
    //-----------------------------------------------
    // Accessor for blockAttempts
    public int getBlockAttempts() {
        return blockAttempts;
    }

    // Mutator for blockAttempts
    public void setBlockAttempts(int blockAttempts) {
        this.blockAttempts = blockAttempts;
    }
    //-----------------------------------------------
    // Display Methods

    @Override
    // returns a string of all the player's attributes + specialized attributes, overrided toString()
     public String toString() {
         return super.toString() + String.format("%nAces scored: %d" +
                                                 "%nBlocks made: %d" + 
                                                 "%nBlock attempts (unsuccessful): %d" +
                                                 "%nSuccessful recieves: %d" +
                                                 "%nRecieve attempts (unsuccessful): %d",    
                                                 aces, blocksMade, blockAttempts, recievesMade, recieveAttempts);
    }
    //-----------------------------------------------
    // Equivalence

    @Override
    // returns true if all attributes of both objects are the same
    public boolean equals(Object obj) {
        boolean result = false;
        final double TOL = 0.0001;  // equals tolerance

        // first, check whether the objects are of the same type
        if ( (obj instanceof Volleyball) )  {
            // typecase into intended object type
            Volleyball c = (Volleyball) obj;
            
            // check field-by-field on ALL fields
            result = (c.getPlayerName().equals(this.playerName) && 
                      c.getPlayerEmail().equals(this.playerEmail) &&
                      c.getPlayerPhone().equals(this.playerPhone) &&
                      (Math.abs(c.getPlayerSalary() - this.playerSalary) <= TOL) &&
                      c.getPlayerNumber() == this.playerNumber &&
                      c.getGamesPlayed() == this.gamesPlayed &&
                      c.getBirthYear() == this.birthYear &&
                      c.getJoinYear() == this.joinYear &&
                      c.getAces() == this.aces &&
                      c.getblocksMade() == this.blocksMade &&
                      c.getRecievesMade() == this.recievesMade &&
                      c.getRecievesAttempts() == this.recieveAttempts &&
                      c.getBlockAttempts() == this.blockAttempts);
         }
         
        // else, not of the same type, no need to check further   

        return result;
    }
    //-----------------------------------------------
    // Additional (2) Methods

    // calculates the player's successful recieves percentage based on:
    // successful recieve attempts divded by unsuccessful attempts + successful attempts
    public double successfulRecievesRate() {
        double accuracy;
        accuracy = (double) recievesMade/(recieveAttempts + recievesMade) * 100;
        return accuracy;
    }

    // calculates the player's successful block percentage based on:
    // successful block attempts divded by unsuccessful attempts + successful attempts
    public double successfulBlocksRate() {
        double accuracy;
        accuracy = (double) blocksMade/(blockAttempts + blocksMade) * 100;
        return accuracy;
    }
}   // end of Volleyball 


// Testing some, not all of our class code
class Driver {   
    public static void main(String[] args) {
        // superclass constructor
        BasketballPlayer b1 = new BasketballPlayer("Alex Rodriguez", "alex@google.com", "222-222-2222", 195000.0, 
                                                   123, 1, 1997, 2015, 20, 0, 4, 3, 5, 3, 1, 4);
        // self-created subclass
        Volleyball v1 = new Volleyball("Laila", "myemail@email.com", "(676) 767-6767", 
                                       15000.75, 25, 70, 2001, 2010, 20, 15, 67, 32, 10);

        // Testing Basketball class

        // testing toString
        System.out.println("Calling the toString method\n");
        System.out.print("***************************************************");
        System.out.println(b1.toString());
        System.out.println("***************************************************");

        // testing getter methods
        System.out.println("Calling the Getter methods\n");
        System.out.print("***************************************************");
        System.out.printf("%nIs %s fouled out? %s is%s. He has %d fouls", b1.getPlayerName(), b1.getPlayerName(), b1.foulsOut(), b1.getFoulsMade());
        System.out.printf("%nHow old is %s ? %s is %d years old.", b1.getPlayerName(), b1.getPlayerName(), b1.getAge());
        System.out.printf("%nIs %s at the retire age? %s is%s.", b1.getPlayerName(), b1.getPlayerName(), b1.retiredAge());
        System.out.printf("%nHow many blocksMade does %s has? %d", b1.getPlayerName(), b1.getBlocksMade());
        System.out.printf("%nHow many minutes has %s has played? %d", b1.getPlayerName(), b1.getMinutesPlayed());
        System.out.printf("%nWhat is %s email address? %s", b1.getPlayerName(), b1.getPlayerEmail());
        System.out.printf("%nWhat is %s phone number? %s", b1.getPlayerName(), b1.getPlayerPhone());
        System.out.printf("%nHow many years %s has played? %d", b1.getPlayerName(), b1.yearsPlayed());
        System.out.printf("%nHow many field goal attempts does %s have? %d", b1.getPlayerName(), b1.getFieldGoalsAttempted());
        System.out.printf("%nHow many assists does %s have? %d", b1.getPlayerName(), b1.getAssistsMade());
        System.out.println();
        System.out.println("***************************************************");

        // testing setter methods
        System.out.print("Calling the setter methods\n");
        b1.setPlayerEmail("Rod@yahoo.com");
        b1.setGamesPlayed(2);
        b1.setAssistsMade(7);
        b1.setBlocksMade(3);
        b1.setFoulsMade(7);
        System.out.println("The object has been modified");
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("Calling the tostring method after calling the setter methods");
        System.out.println(b1.toString());
        System.out.println("***************************************************");

        // calling getter method again
        System.out.println("Calling the getter methods");
        System.out.printf("%nIs %s fouled out? %s is%s. He has %d fouls", b1.getPlayerName(), b1.getPlayerName(), b1.foulsOut(), b1.getFoulsMade());
        System.out.println();

        // testing Volleyball class
       System.out.println("***************************************************");
        System.out.println("Testing additional subclass, Volleyball class");
        System.out.println();

        // testing toString
        System.out.println("Calling the toString method");
        System.out.print("***************************************************");
        System.out.println(v1.toString());
        System.out.println("***************************************************");

        // testing accessor & mutator methods for Volleyball class
        System.out.println("Testing getter and setter method");
        System.out.println();
        System.out.println("Volleyball class birth year: " + v1.getBirthYear()); 
        v1.setBirthYear(2000); 
        System.out.println("Volleyball class birth year AFTER calling mutator method: " + v1.getBirthYear()); 
        System.out.println();

        // Additional Method (1/3): testing successfulRecievesRate
        System.out.println("Testing additional methods from Volleyball Class & Basketball Class: successfulRecievesRate, successfulBlocksRate, getShootingPercentage");
        System.out.printf("Volleyball class: Your recieves accuracy is: %.2f%%", v1.successfulRecievesRate());
        System.out.println();

        // Additional Method (2/3): testing successfulBlocksRate
        System.out.printf("Volleyball class: Your block accuracy is: %.2f%%", v1.successfulBlocksRate());
        System.out.println();

        // BASKETBALL CLASS Additional Method (3/3): testing getShootingPercentage
        System.out.printf("Basketball class: Your shooting percentage is: %.2f%%", b1.getTrueShootingPercentage(15));
        System.out.println(); 
    }                
}