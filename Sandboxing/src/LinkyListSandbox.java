// Experimenting with LinkedLists

import java.util.Iterator;
import java.util.LinkedList;

class LinkyListSandbox {
    public static void main(String [] args) {
        LinkedList<String> listy = new LinkedList<String>();
        LinkedList<String> listy2 = new LinkedList<String>();

        listy.add("Spongebob");
        listy.add("Chad");
        listy.add("Naruto");

        listy2.add("FaZe");
        listy2.add(listy.get(1));   // points to "Chad" from 'listy' list
        

        //listy.remove();              // removes first element [Chad, Naruto]
        //listy.add(1, "Tanjiro");     // [Spongebob, Tanjiro, Chad, Naurto]

        System.out.println("1) " + listy);
        System.out.println("2) " + listy.get(2));   // testing get(int index)

        listy.addAll(listy2);   // adds all of listy2 to listy
        System.out.println("3) " + listy);

        // searching for some data in the list; remember, linked lists do not have a method for random direct access to an element
        // learned from Alex Lee's video on Youtube titled, "Linked List Java Tutorial #67"
        Iterator<String> it = listy.iterator();
        boolean objectFound = false;    // for extra code by me, 
        int timesFound = 0;             // extra code by me, keeps track of how many times data is found in the list
        String searchString = "Chad";

        // from tutorial, searches for data in a linked list with the linked list's iterator
        while(it.hasNext()) {
            if(it.next().equals(searchString)) {
                objectFound = true;
                timesFound++;
                System.out.printf("%nFound String object: %s in list. (%d)", searchString, timesFound);
            }
        }

        // extra code written by me
        if(objectFound == false) {
                System.out.printf("%nString object: %s NOT FOUND in list.", searchString);
        }

        System.out.printf("%nTotal of %d elements found in linked list", timesFound);

        //listy.clear();
        //System.out.println("4) " + listy);
    }    
}