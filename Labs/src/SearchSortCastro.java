/*

DO NOT REMOVE ANY OF THE GIVEN COMMENTS OTHERWISE ZERO POINTS WILL BE GIVEN
Name:
date:
description:
self-grade: 
Testimony: I have written all the code by myself and did not get any help from unauthorized sources. Name__________

Classes in this assignmnet: Person(code is given), Specialist, Nurse, Kaiser
Kaiser has a list of specialist and nurses

The description for each method in each class is given.

Verify the correctness of your code by checking the output to see if the list of the specialist and nurses are sorted   
 
 
No sample output is provided for this assignmnet. You need to create your own driver adding
nurses and specialist to the list                  
*/
import java.util.*;

public class SearchSortCastro 
{
    // no code here
}

/* Complete code is given */
class Person implements Comparable {
    private String first;
    private String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;

    }

    public Person() {
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String toString() {
        return first + " " + last;
    }

    public boolean equals(Person other) {

        return this.first.equalsIgnoreCase(other.first ) &&  this.last.equalsIgnoreCase(other.last);
    }

    /*
     * Compares two person based on the last name, if they have
     * the same last name, first name will be compared
     */
    public int compareTo(Object p) {
        Person other = (Person) p;
        if (this.last.compareTo(other.last) == 0)
            return this.first.compareTo(other.first);
        else
            return this.last.compareTo(other.last);
    }

}

/*
 * Create a class called Nurse
 * 
 * Attributes:first, last , departmnet, qualification(RN, BSN, MSN), shift(Day,
 * Night, Rotate) , Supervisor which is a person
 * 
 * Must complete the following class
 */
class Nurse extends Person implements Comparable {
    // first and last name will be inherited from the person class
    private String department;
    private String qualifications;
    private String shift;
    private Person supervisor = new Person();

    // constructors
    public Nurse() {
    }

    public Nurse(String department, String qualifications, String shift, Person supervisor) {
        this.department = department;
        this.qualifications = qualifications;
        this.shift = shift;
        this.supervisor = supervisor;
    }

    // Accessor/getter methods
    public String getDepartment() {
        return department;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getShift() {
        return shift;
    }

    public Person getSupervisor() {
        return supervisor;
    }

    // Mutator/setter methods
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setQualifications(String qualifictions) {
        this.qualifications = qualifictions;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    // create toString method
    @Override
    public String toString() {
        String border = "=".repeat(25);
        return String.format("%n%s" + 
                             "%nDepartment: %s" + 
                             "%nQualifications: %s" + 
                             "%nShift: %s" +
                             "%nSupervisor: %s" + 
                             "%n%s", 
                             border, department, qualifications, shift, (supervisor.getFirst() + " " + supervisor.getLast()), border);
    }

    // equals method, returns true if objects match
    public boolean equals(Nurse n) {
        boolean match = false;

        // compares all attributes
        if( (this.getDepartment().equals(n.getDepartment())) &&
            (this.getQualifications().equals(n.getQualifications())) && 
            (this.getShift().equals(n.getShift())) && 
            (this.getSupervisor().equals(n.getSupervisor())) ) {
            match = true;
        }
        return match;
    }

    // create compareTo method based on the department. This will be used to sort the nurses based on the department
    @Override
    public int compareTo(Object o) {
        int compareRating;

        // Type-cast into proper class type
        Nurse n = (Nurse) o;

        // compare departments
        // arg object's department is alphabetically after this object
        if(this.getDepartment().compareTo(n.getDepartment()) > 0) {
            compareRating = -1;
        }

        // arg object's department is alphabetically before this object
        else if(this.getDepartment().compareTo(n.getDepartment()) < 0) {
            compareRating = 1;
        }

        // arg object's department matches this object's department
        else {
            compareRating = 0;
        }
        return compareRating;
    }
}

/*
 * The following class create a Specialist doctor objects
 */
class Specialist extends Person implements Comparable {

    private String speciality;
    private String rating;
    private Person person;

    // constructors
    public Specialist() {
    }    

    public Specialist(String speciality, String rating, Person person) {
        this.speciality = speciality;
        this.rating = rating;
        this.person = person;
    }

    // Accessor/getter methods
    public String getSpeciality() {
        return speciality;
    }

    public String getRating() {
        return rating;
    }

    public Person getPerson() {
        return person;
    }

    // Mutator/setter methods
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // equals
    public boolean equals(Specialist o) {
        return ( (this.speciality == o.speciality) && (this.rating == o.rating) && (this.person.equals(o.person)) );
    }

    /*
     * compares objects of type Doctor based on the speciality
     * if two doctors have the same speciality then must use the compareTo from the
     * Person class
     * 
     * this method is called in the insertion sort
     * this method is similar to the given compareTo method
     */

    public int compareTo(Object o) {   
        int returnVal;
        // Type-cast into proper class
        Specialist s = (Specialist) o;

        // Doctor/specialist objects have the same speciality attribute
        if(this.speciality.equals(s.speciality)) {
            returnVal = this.person.compareTo(s.person); // compare this object and the arg using Person class compareTo
        }

        // speciality attribute is different, return negative valye is arg string is alphabetically before this object's string
        // return postive value if arg string is alphabetically after this object's string
        else {
            returnVal = this.speciality.compareTo(s.speciality);
        }

        return returnVal;
    }

    /*
     * 
     * Compares objects based on the rating of the doctors
     * this compare method should be used in the selction sort.
     */

    public int compareRating(Object o) {
        int returnVal;

        // Type-cast into proper class
        Specialist s = (Specialist) o;

        // ratings are the same, return 0
        if(this.rating.equals(s.rating)) {
            returnVal = 0;
        }

        // ratings differ, return negative value if arg string is alphabetically before this object's string
        // positive value if arg string is alphabetically after this object's string
        else {
            returnVal = this.rating.compareToIgnoreCase(s.rating);
        }

        return returnVal;
    }

    /*
     * This method create a string representing all the attributes for a the Doctor
     * object
     * This method must display a number fo the rating. mening that if the rating is
     * ***** then the toString method should display 5
     **** --> displays 4
     *** --> displays 3
     ** --> displays 2
     * --> displays 1
     */

    public String toString() {
        String border = "=".repeat(25);
        String ratingDisplay = "";

        // properly display rating if the length of the rating string is from 1-5
        if((rating.length() > 0) && (rating.length() < 6)) {
            // display the whole number value of the rating
            for(int i=0; i<rating.length(); i++) {
                ratingDisplay = Integer.toString(i+1);
            }
        }

        // Invalid rating don't display whole number value, not in proper rating range of [1-5]
        else {
            ratingDisplay = "Invalid rating. Rating range is from [1-5] stars.";
        }
        
        return "\n" + border + String.format("%nSpeciality: %s %nRating: %s", speciality, ratingDisplay) + "\n" + border;
    }

    /*
     * this method is used to see if two objects of type doctor are the same.
     * Two objects are the same if they have the same first and last name
     */

    public boolean equals(Object o) {
        Specialist s = (Specialist) o;
        return ( this.person.equals(s) );
    }

}
/*
 * The following class has a list of doctors and a list of nurses
 * Kaiser has a list of specialist and a list of nurses
 */

class Kaiser {
    ArrayList<Specialist> specialists; // list of specialist
    ArrayList<Nurse> nurses; // list of nurses

    /* Constructors: instantiates the arraylist */
    public Kaiser() {
        specialists = new ArrayList<Specialist>();
        nurses = new ArrayList<Nurse>();
    }

    public Kaiser(ArrayList<Specialist> specialists, ArrayList<Nurse> nurses) {
        this.specialists = specialists;
        this.nurses = nurses;
    }

    // Accessor/getter methods
    public ArrayList<Specialist> getSpecialList() {
        return specialists;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    } 
    // *********************************************************************************************************

    /*
     * implement a bubble sort method to sorts the Specialist objects based on the
     * the first name and last name
     * therfore the compareTo method from the Person class must be called.
     */

    public void bubbleSortSpecialist(ArrayList<Specialist> list) {
        for(int i=0; i<list.size()-1; i++) {
            for(int j=0; j<list.size()-1-i; j++) {
                // if the next name in the list is alphabetically before the previous name, then swap
                if(list.get(i).compareTo(list.get(i+1)) < 0) {
                    Specialist temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                }
            }
        }
    }
    // *********************************************************************************************************

    /*
     * addSpecilaist method:
     * gets the attributes for a specialist and adds the specilaist to the end of
     * the list of the specialist
     * refer to the lecture note to see how to add an object to a list to keep the
     * list sorted
     * 
     * 
     */

    public void addSpecilaist(String speciality, String rating, Person person) {
        // create a new specialist object, add to the end of the list
        Specialist newSpecialist = new Specialist(speciality, rating, person);
        specialists.add(newSpecialist);

        // sort list after adding new specialist obj
        bubbleSortSpecialist(specialists);
    }

    // *****************************************************************************************************************
    /*
     * addNurse method adds a nurse to the end of list of the nurses
     * This method gets the attributes for a nurse
     * creates a nurse object
     * adds the nurse to the end of the list
     * 
     */

    public void addNurse(String department, String qualifications, String shift, Person supervisor) {
        // create a new nurse object, add to the end of the list
        Nurse newNurse = new Nurse(department, qualifications, shift, supervisor);
        nurses.add(newNurse);

        // sort list after adding new nurse obj
        insertionSortNurses(nurses);
    }

    // ************************************************************************************************************

    /*
     * deleteSpecialist method : deletes a specialist based on the first and last
     * name
     * 
     * This method gets the first and the last name of a specialist,
     * call the bubbleSortSpecialist to sort the list of the doctors then
     * uses the binary serach to find and delete the given specialist
     * 
     * Must implement binary search binary search
     * 
     */

    public void deleteSpecialist(String first, String last) {
        //
        int firstIndex = 0;
        int lastIndex = specialists.size()-1;
        int targetIndex = -1;
        boolean targetFound = false;
        Specialist removeSpecialist;

        // sort list before searching
        bubbleSortSpecialist(specialists);

        while( (firstIndex <= lastIndex) && (targetFound == false) ) {
            int mid = (firstIndex + lastIndex)/2;

            // mid-point is the target
            if( (specialists.get(mid).getFirst().equals(first)) && 
                (specialists.get(mid).getLast().equals(last)) ) {
                targetIndex = mid;
                targetFound = true;
            }

            // mid-point is less than the target
            else if( (specialists.get(mid).getFirst().compareTo(first) > 0) || (specialists.get(mid).getLast().compareTo(last) > 0) ) {
                firstIndex = mid+1;
            }

            // mid-point is greater than the target
                lastIndex = mid-1;
        }

        // remove the specialist with the given first and last name
        specialists.remove(targetIndex);
    }

    // *******************************************************************************************************************
    /*
     * toStringSpecilaits method: This method creates a string representing the list
     * of all the specialist and returns it
     * 
     */
    public String toStringSpecialists(ArrayList<Specialist> list) {
        String specialistDisplay = "";

        for(int i=0; i<list.size(); i++) {
            specialistDisplay += list.get(i).toString();
        }

        return specialistDisplay;
    }

    // ************************************************************************************************************

    /*
     * toStringNurses method: This method creates a string representing the list of
     * all the nurses and returns it
     * 
     */

    public String toStringNurses(ArrayList<Nurse> list) {
        String nursesDisplay = "";

        for(int i=0; i<list.size(); i++) {
            nursesDisplay += list.get(i).toString();
        }

        return nursesDisplay;
    }

    // ***********************************************************************************************************
    /*
     * This method sort the list of the specialist based on the rating.
     * must use the compareTo method implemented in the specialist class
     * 
     * this method calles the compareRating method to sort all the the doctors based
     * on the rating
     * refer to the lecture notes on selection sort
     */
    public void selectionSortSpecilaist(ArrayList<Specialist> list) {
        // keeps track of the current element to check with the rest
        for(int i=0; i<list.size()-1; i++) {
            Specialist min = list.get(i);
            int index = -1;
            boolean swap = false;

            // compares the current element with the rest of the list
            for(int j=i+1; j<list.size(); j++) {
                // if the rating of the current element is greater than the next element, then swap
                if(min.compareRating(list.get(j)) > 0) {
                    index = j;
                    min = list.get(j);
                    swap = true;
                }
            }
            // swap AFTER finding the minimum value from one iteration
            if(swap) {
                Specialist temp = list.get(i);
                list.set(i, min);
                list.set(index, temp);
            }
        }
    }

    // ***********************************************************************************************

    /*
     * 
     * This method sorts the lists of the nurses based on the departmnet.
     * CompareTo method created in the Nurse class must be used
     */
    public void insertionSortNurses(ArrayList<Nurse> list) {
        for(int i=0; i<list.size()-1; i++) {
            // value and index position of the next element
            int j = i+1;
            Nurse min = list.get(j);


            while( (j>0) && (min.compareTo(list.get(i)) < 0) ) {
                list.set(j, list.get(j-1));
                j--;
            }
            // starting from j=0, first element should be the lowest value
            list.set(j, min);
        }
    }
    // **********************************************************************************************************
}

/*
 * No sample output is provided for this assignmnet
 * Must verfiy the correctness of your output
 */

class Driver5 {  // temporarily changing method name to Driver5 from YourDriver so I can run in vscode
    public static void main(String[] args) {
        // TEMPORARY TEST CODE
        Person p1 = new Person("James", "Doe");
        Person p2 = new Person("Herbert", "Doe");
        Person p3 = new Person("Walter", "Walter");

        Nurse n1 = new Nurse("A21", "UCD Grad", "9am-5pm", p1);
        Nurse n2 = new Nurse("A24", "UCLA Grad", "9pm-5am", p1);
        Nurse n3 = new Nurse("A24", "UCLA Grad", "9pm-5am", p1);

        // testing Specialist class
        Specialist s1 = new Specialist("Eye examinator", "*****", p2);
        Specialist s2 = new Specialist("Eye examinator", "***", p2);
        Specialist s3 = new Specialist("Ear specialist", "****", p3);
        
        // Testing 3 cases for Nurse class equals()
        System.out.println("Testing equals(): comparing the same object, should return true: " + n3.equals(n3));
        System.out.println("Testing equals(): comparing two objects with the same attributes, should return true: " + n3.equals(n2));
        System.out.println("Testing equals(): comparing two different objects, should return false: " + n3.equals(n1));

        // testing Nurse class toString
        System.out.println(n1);
        System.out.println();

        // testing Nurse class compareTo()
        System.out.println("Testing compareTo(): comparing department A21 to A24, should return 1: " + n1.compareTo(n3));
        System.out.println("Testing compareTo(): comparing same objects, should return 0: " + n1.compareTo(n1));
        System.out.println("Testing compareTo(): comparing department A24 to A21, should return -1: " + n3.compareTo(n1));

        // testing Specialist class toString();
        System.out.println(s1);
        System.out.println();

        // testing Specialist class compareTo()
        System.out.println("Testing compareTo(): comparing Specialist object to itself, should return 0: " + s1.compareTo(s1));
        System.out.println("Testing compareTo(): comparing two different objects with the same speciality, should return 0: " + s1.compareTo(s2));
        System.out.println("Testing compareTo(): comparing two different objects, should call Person class compareTo, should return (-) or (+): " + s1.compareTo(s3));

        // --------------------------------------

        // create an object of Kaiser

        // add 5 specialist to the Kaiser object you creted. must use addSpecilaist
        // method

        // create 5 objects of Nurse, add it to the list of the nurses by calling the
        // addNurse method

        // call the different sorting methods you wrote to sort the list of the
        // specialist

        // dislay the sorted list of the specialist by calling the toStringSpecialist
        // method

        // delete a specialist from the list by calling the delete method from the
        // Kaiser class

        // call the sort method to sort the list of the nurses

        // display the list of the nurses by calling the toString method: toStringNurses

    }
}