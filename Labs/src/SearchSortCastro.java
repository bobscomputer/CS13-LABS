/*
DO NOT REMOVE ANY OF THE GIVEN COMMENTS OTHERWISE ZERO POINTS WILL BE GIVEN
Name: Lynn Castro
date: 11/2/25
description: demonstrating my understanding of bubble sort, selection sort, insertion sort, and binary search algorithms
-----------------------------------------------------------
self-grade (explanation provided below!): 100/100
PROPER-NAMING: Every method and variable has short and descriptive names. (5/5)
INDENTATION: Code is organized and indented by 4 spaces.
COMMENTS: All logic is preceded with a comment description
PROGRAM COMPILES: Program compiles in JGRASP
PROGRAM RUNS & FOLLOWS OUTPUT DIRECTIONS: Program runs in JGRASP and follows the given driver class directions (5/5)
REQUIREMENTS: I implemented everything given from the instructions in Canvas and from the given file comments (5/5)
SELF GRADE PROVIDED: 5/5
-----------------------------------------------------------

Testimony: I have written all the code by myself and did not get any help from unauthorized sources. Name: Lynn Castro

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

// Nurse class, has String attributes of department, qualifications, and shift and a Person object attribute called supervisor.
// Also has compareTo() that compares the departments of two nurse objects, equals() that compares each attribute of two nurse objects, and overrided toString method
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

    // compares the departments of two nurse objects
    @Override
    public int compareTo(Object o) {
        int compareRating;

        // Type-cast into proper class type
        Nurse n = (Nurse) o;

        // compare departments
        // arg object's department is alphabetically after this object
        if(this.getDepartment().compareTo(n.getDepartment()) > 0) {
            compareRating = 1;
        }

        // arg object's department is alphabetically before this object
        else if(this.getDepartment().compareTo(n.getDepartment()) < 0) {
            compareRating = -1;
        }

        // arg object's department matches this object's department
        else {
            compareRating = 0;
        }
        return compareRating;
    }
}

// Specialist class, has String attributes of specialtiy and rating and a Person attribute called person.
// 
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

    // Compares speciality, if the two objects have the same speciality, 
    // then method uses compareTo() from the person class to compare first and last names.
    public int compareSpeciality(Object o) {   
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

    // Compares the ratings of specialists/doctors
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

    // creates a string representation of all the attributes a doctor has
    // rating must have a total character length of [1-5], or else it will display a warning.
    // turns the string rating into a whole number value: *** --> 3.
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
        
        return "\n" + border + String.format("%nFull name: %s %s %nSpeciality: %s %nRating: %s", person.getFirst(), person.getLast(), speciality, ratingDisplay) + "\n" + border;
    }

    // compares to specialist/doctor objects using the equals method from the person class
    public boolean equals(Object o) {
        Specialist s = (Specialist) o;
        return ( this.person.equals(s) );
    }

}

// Kaiser class, contains a list of specialist/doctor and a list of nurses
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

    // uses a bubble sort algorithm to sort specialists objects based on first and last name
    public void bubbleSortSpecialist(ArrayList<Specialist> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.size()-1-i; j++) {

                // if the next name in the list is alphabetically before the previous name, then swap
                if(list.get(j+1).getPerson().compareTo(list.get(j).getPerson()) < 0) {
                    Specialist temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
    // *********************************************************************************************************

    // creates a new specialist obj with the given args, adds the new obj to the end of the list, then sorts the list
    public void addSpecilaist(String speciality, String rating, String first, String last) {
        // create a newPerson for new specialist obj
        Person newPerson = new Person(first, last);

        // create a new specialist object, add to the end of the list
        Specialist newSpecialist = new Specialist(speciality, rating, newPerson);
        specialists.add(newSpecialist);

        // sort list after adding new specialist obj
        bubbleSortSpecialist(specialists);
    }

    // *****************************************************************************************************************

    // creates a new nurse obj with the given args, then adds the new obj to the end of the list
    public void addNurse(String department, String qualifications, String shift, String first, String last) {
        // create a newPerson for new nurse obj
        Person supervisor = new Person(first, last);

        // create a new nurse object, add to the end of the list
        Nurse newNurse = new Nurse(department, qualifications, shift, supervisor);
        nurses.add(newNurse);
    }

    // ************************************************************************************************************

    // deletes a specialist/doctor from the list from a given first and last name.
    // sorts the list, uses binary search algorithm to locate the specialist/doctor, 
    // then deletes the doctor at the target index
    public void deleteSpecialist(String first, String last) {
        // declarations & instantiations
        int firstIndex = 0;
        int lastIndex = specialists.size()-1;
        int targetIndex = -1;
        boolean targetFound = false;
        Person targetPerson = new Person(first, last);

        //temp?
        int compareVal;

        // sort list before searching
        bubbleSortSpecialist(specialists);

        while( (firstIndex <= lastIndex) && (targetFound == false) ) {
            int mid = (firstIndex + lastIndex)/2;
            compareVal = targetPerson.compareTo(specialists.get(mid).getPerson());

            // mid-point is the target, remove specialist
            if(compareVal == 0) {
                targetIndex = mid;
                specialists.remove(targetIndex);
                targetFound = true;
            }

            // mid-point is greater than the target, search left side
            else if( ( compareVal < 0) ) {
                lastIndex = mid-1;
            }
            
            // mid-point is less than the target, search right side
            else {
                firstIndex = mid+1;
            }
        }
    }
    // *******************************************************************************************************************

    // creates a string representation of all the specialists/doctors in the list
    public String toStringSpecialists(ArrayList<Specialist> list) {
        String specialistDisplay = "";

        for(int i=0; i<list.size(); i++) {
            specialistDisplay += list.get(i).toString() + "\n";
        }

        return specialistDisplay;
    }

    // ************************************************************************************************************

    // creates a string representation of all the nurses in the list
    public String toStringNurses(ArrayList<Nurse> list) {
        String nursesDisplay = "";

        for(int i=0; i<list.size(); i++) {
            nursesDisplay += list.get(i).toString() + "\n";
        }

        return nursesDisplay;
    }

    // ***********************************************************************************************************

    // sorts specialist by their RATING using a selection sort algorithm
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

    // sorts the nurses in the list by DEPARTMENT using a insertion sort algorithm
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

class YourDriver { 
    public static void main(String[] args) {
        // border to organize print statments
        String border = "-".repeat(70);

        // create an object of Kaiser
        ArrayList<Specialist> specialists = new ArrayList<>();
        ArrayList<Nurse> nurses = new ArrayList<>();
        Kaiser kaiser = new Kaiser(specialists, nurses);

        // add 5 specialist to the Kaiser object you creted. must use addSpecilaist method
        kaiser.addSpecilaist("Family Medicine", "***", "Quen", "Blackwell");
        kaiser.addSpecilaist("Surgery", "****", "John" , "Doe");
        kaiser.addSpecilaist("Neurology", "**", "Trisha", "Paytas");
        kaiser.addSpecilaist("Plastic Surgery", "*****", "Edna", "Mode");
        kaiser.addSpecilaist("Critical Care", "***", "Jean", "Gunnhildr");

        // create 5 objects of Nurse, add it to the list of the nurses by calling the addNurse method
        kaiser.addNurse("A20", "Psychiatric Mental Health NP", "7am-7pm", "Freddy", "Fazbear");
        kaiser.addNurse("A28", "Family NP", "5am-5pm", "William", "Afton");
        kaiser.addNurse("A19", "Public Health", "12am-12pm", "Michael", "Afton");
        kaiser.addNurse("A32", "Nursing Education", "7am-7pm", "Vanessa", "Shelly");
        kaiser.addNurse("A12", "Health Informatics", "7am-7pm", "Bob", "Shod");

        // call the different sorting methods you wrote to sort the list of the specialist
        kaiser.selectionSortSpecilaist(specialists);

        // dislay the sorted list of the specialist by calling the toStringSpecialist method
        System.out.println(border + "\nList of specialists sorted in ascending order of RATING: \n" + kaiser.toStringSpecialists(specialists));
        kaiser.bubbleSortSpecialist(specialists);
        System.out.println(border + "\nList of specialists sorted by LAST NAME: \n" + kaiser.toStringSpecialists(specialists));

        // delete a specialist from the list by calling the delete method from the Kaiser class
        kaiser.deleteSpecialist("John", "Doe");
        System.out.println(border + "\nList of specialists after deleting John Doe: \n" + kaiser.toStringSpecialists(specialists));

        // display the list of the nurses by calling the toString method: toStringNurses
        System.out.println(border + "\nList of nurses before sorting: \n" + kaiser.toStringNurses(nurses));

        kaiser.insertionSortNurses(nurses);
        System.out.println(border + "\nList of nurses after sorting by DEPARTMENT: \n" + kaiser.toStringNurses(nurses));
    }
}