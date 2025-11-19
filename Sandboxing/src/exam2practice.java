import java.util.*;
public class exam2practice {
}

class ExamPracticeDriver {
    public static void main(String[] args) {
        // Declarations & Instantiations
        Scanner scan = new Scanner(System.in);
        
        menu(scan);
    }

    public static void menu(Scanner scan) {
        IntLinkedList list = new IntLinkedList();
        Scanner scan2 = new Scanner(System.in);
        String input;
        String border = "-".repeat(50) + "\n";
        boolean quit = false;
        int val;
        int copy;
        int index;

        while(quit != true) {
            menuDisplay();
            input = scan.nextLine();

            switch (input) {
                case "q":
                case "Q":
                    scan.close();
                    System.out.println("Thanks for testing! Exiting program ...");
                    quit = true;
                    break;

                // option for add to end of list
                case "1":
                    System.out.print("Enter a value for the new node: ");
                    val = scan2.nextInt();
                    list.add(val);

                    System.out.printf("%nAdded %d to the list", val);
                    System.out.printf("%nData: %s %n%s", list.toString(), border);
                    break;

                // option for add at a given index
                case "2":
                    System.out.println();
                    System.out.print("Enter a value for the new node: ");
                    val = scan2.nextInt();

                    System.out.println();
                    System.out.printf("Enter the index to insert new node [0-%d]: ", list.getSize());
                    index = scan2.nextInt();

                    System.out.printf("Adding %d at index %d", val, index);
                    list.add(val, index);

                    System.out.printf("%nData: %s %n%s", list.toString(), border);
                    break;

                // option for remove
                case "3":
                    System.out.println();
                    System.out.print("Enter a value in the list to remove: ");
                    val = scan2.nextInt();

                    System.out.println("Removing: " + val);
                    list.remove(val);

                    System.out.printf("%nData: %s %n%s", list.toString(), border);
                    break;

                // option to display list data and size
                case "4":
                    System.out.printf("%nData: %s %n%s", list.toString(), border);
                    break;

                default:
                    System.out.println("Invalid input. Please try again." + "\n" + border);
                    break;
            }
        }
    }

    public static void menuDisplay() {
        System.out.printf("Enter [1-4] to select the following options OR enter 'Q' or 'q' to exit the program. %n" +
                          "%n[1]  Add a value to the end of list" + 
                          "%n[2]  Add a value at an index" + 
                          "%n[3]  Remove a value in the list" + 
                          "%n[4]  Display list information" + 
                          "%n > ");
    }
}

class IntLinkedList {
    private MyListNodeClass head;
    private int size = 0;

    // Constructors
    public IntLinkedList(int value) {
        this.head = new MyListNodeClass(value);
        size++;
    }

    public IntLinkedList() {
        this.head = new MyListNodeClass();
    }

    // Accessor methods
    public int getSize() {
        return this.size;
    }

    public int getData() {
        return this.head.getData();
    }

    public MyListNodeClass getNext() {
        return this.head.getNext();
    }

    // Mutator methods
    public void setData(int value) {
        this.head.setData(value);
    }

    // Add methods
    // add to end of list
    public void add(int data) {
        MyListNodeClass curr = head;

        // if the list is empty
        if(size == 0) {
            curr.setData(data);
            size++;
        }

        // list is not empty
        else {
            MyListNodeClass newNode = new MyListNodeClass(data);
            
            // traverse until the end of the list
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }

            // add new node to the end of the list
            curr.setNext(newNode);
            size++;
        }
    }

    // adds a node at a given index
    public void add(int data, int index) {
        MyListNodeClass curr = head;
        MyListNodeClass prev = curr;
        MyListNodeClass newNode = new MyListNodeClass(data);
        boolean foundIndex = false;
        boolean empty = false;

        // if the list is empty
        if(size == 0) {
            head = newNode;
            size++;
            empty = true;
        }

        // adding to the first index, but list is not empty
        else if( (index == 0) && (empty == false) ) {
            newNode.setNext(head);
            head = newNode;
            size++;
        }

        // adding to the last index
        else if( (index == size) && (empty == false) ) {
            // traverse until the end of the list
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }

            // add new node to the end of the list
            curr.setNext(newNode);
            size++;
        }

        // list is not empty
        else {
            // only add the node if the given index is within bounds
            if( (index < size) && (index > 0) ) { 

                // traverse the list for the node before the given index
                while( (curr.getNext() != null) && (foundIndex == false) ) {
                    for(int i=0; i<index-1; i++) {
                        curr = curr.getNext();
                    }
                    
                    // get the previous and current nodes, then exit the loop
                    prev = curr;
                    curr = curr.getNext(); 
                    foundIndex = true;
                }

                // copy the current node
                MyListNodeClass copy = curr;

                // set the previous node next address to the new node
                prev.setNext(newNode);

                // set the new node next address to the current node
                newNode.setNext(copy);
                size++;
            }

            // invalid index input
            else {
               System.out.printf("%nIndex '%d' is out of bounds", index);
               return; 
            }
        }
    }

    // remove methods
    public void remove(int data) {
        MyListNodeClass curr = head;
        MyListNodeClass prev = curr;
        boolean foundVal = false;

        // check if list is empty
        if(size == 0) {
            // do nothing
        }

        if(head.getData() == data) {
            head = head.getNext();
            size--;
            foundVal = true;
            //return;
        }

        // value is not at the first node
        else {
            // search for the given value in the list
            while( (curr.getNext() != null) && (foundVal == false) ) {

                // keep searching until the curr node equals the given arg
                if(curr.getNext().getData() != data) {
                    curr = curr.getNext(); // previous node before given arg
                }

                // next node equals the given arg
                else {
                    foundVal = true;
                }
            }

            prev = curr;
            // remove the value if found
            if(foundVal) {
                prev.setNext(curr.getNext().getNext());
                size--;
            }

            else {
                System.out.printf("%nValue: %d is not in the list", data);
            }
        }
    }

    // toString
    @Override
    public String toString() {
        String displayString = "[";
        MyListNodeClass curr = head;

        // list is empty
        if(size == 0) {
            displayString = "Nothing to display because list is empty";
        }

        else {
            while(curr.getNext() != null) {
                displayString += curr.getData() + ", ";
                curr = curr.getNext();    
            }
            // avoids adding a comma after the last node 
            displayString += curr.getData() + "]";
        }

        displayString += String.format("%nSize: %d", getSize());
        return displayString;
    }
}

class MyListNodeClass {
    private int data;
    private MyListNodeClass next;

    // Constructors
    public MyListNodeClass(int data) {
        this.data = data;
    }

    public MyListNodeClass() {
    }

    public MyListNodeClass(int data, MyListNodeClass next) {
        this.data = data;
        this.next = next;
    }

    // Accessor Methods
    public int getData() {
        return this.data;
    }

    public MyListNodeClass getNext() {
        return this.next;
    }

    // Mutator Methods
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(MyListNodeClass next) {
        this.next = next;
    }
}
