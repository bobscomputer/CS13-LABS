import java.util.*;
public class exam2practice {
}

class ExamPracticeDriver {
    public static void main(String[] args) {
        // Declarations & Instantiations
        Scanner scan = new Scanner(System.in);
        //MyListNodeClass linkedList = new MyListNodeClass(1); 
        //linkedList.add(2);
        //linkedList.add(3);

        IntLinkedList list = new IntLinkedList(1);
        list.add(2);
        list.add(3);

        // Display intial list
        System.out.printf("Data: %s Size: %d %n", list.toString(), list.getSize());

        /*
        // Reverse the order of the list. (1, 2, 3) to (3, 2, 1) with the given ListNode class from the lecture
        System.out.println("\nExam question, reverse the order. (1, 2, 3) to (3, 2, 1)");

        // copy the first value
        int copy;
        copy = linkedList.getData();

        // swap the values accordingly
        linkedList.setData(linkedList.getNext().getNext().getData());
        linkedList.getNext().getNext().setData(copy);
        System.out.printf("Data: %s Size: %d %n", linkedList.toString(), linkedList.getSize());
        */

        // Testing remove method.
        int copy;
        System.out.println();
        System.out.print("Enter a value in the list to remove: ");
        copy = scan.nextInt();

        System.out.println("Removing: " + copy);
        list.remove(copy);

        System.out.printf("%nData: %s Size: %d %n", list.toString(), list.getSize());

        // Testing adding at an index method.
        int val;
        int index;

        System.out.println();
        System.out.print("Enter a value for the new node: ");
        val = scan.nextInt();

        System.out.println();
        System.out.printf("Enter the index to insert new node [0-%d]: ", list.getSize()-1);
        index = scan.nextInt();

        System.out.printf("Adding %d at index %d", val, index);
        list.add(val, index);

        System.out.printf("%nData: %s Size: %d %n", list.toString(), list.getSize());
    }

    public static void menu() {
        // option for add to end of list
        // option for add at a given index
        // option for remove
        // option to display list data and size
    }
}

// move add, toString, and remove to here..?
class IntLinkedList {
    private MyListNodeClass head;
    private int size = 0;

    public IntLinkedList(int value) {
        this.head = new MyListNodeClass(value);
        size++;
    }

    public int getSize() {
        return this.size;
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

        // if the list is empty
        if(size == 0) {
            curr.setData(data);
            size++;
        }

        // adding to the first index
        if(index == 0) {
            newNode.setNext(head);
            head = newNode;
        }

        // list is not empty
        else {
            // only add the node if the given index is within bounds
            if( (index < size) && (index >= 0) ) {

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
        return displayString;
    }
}

class MyListNodeClass {
    private int data;
    private int size = 0;
    private MyListNodeClass next;

    // Constructors
    public MyListNodeClass(int data) {
        this.data = data;
        size++;
    }

    public MyListNodeClass() {
    }

    public MyListNodeClass(int data, MyListNodeClass next) {
        this.data = data;
        this.next = next;
        size+=2;
    }

    // Accessor Methods
    public int getData() {
        return this.data;
    }

    public MyListNodeClass getNext() {
        return this.next;
    }

    public int getSize() {
        return this.size;
    }

    // Mutator Methods
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(MyListNodeClass next) {
        this.next = next;
    }

    // Add methods
    public void add(int data) {
        MyListNodeClass curr = this;

        // if the list is empty
        if(size == 0) {
            setData(data);
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
        MyListNodeClass curr = this;
        MyListNodeClass prev = curr;
        MyListNodeClass newNode = new MyListNodeClass(data);
        boolean foundIndex = false;

        // if the list is empty
        if(size == 0) {
            setData(data);
            size++;
        }

        // list is not empty
        else {
            // only add the node if the given index is within bounds
            if( (index < size) && (index >= 0) ) {

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
    // wrong for removing first element ...
    public void remove(int data) {
        MyListNodeClass curr = this;
        MyListNodeClass prev = curr;
        boolean foundVal = false;

        // check if list is empty
        if(size == 0) {
            // do nothing
        }

        if(curr.getData() == data) {
            curr = curr.getNext();
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
        MyListNodeClass curr = this;

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
        return displayString;
    }
}
