// Experimenting with LinkedLists

import java.util.LinkedList;

class LinkyListSandbox {
    public static void main(String [] args) {
        LinkedList listy = new LinkedList();
        LinkedList listy2 = new LinkedList();

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
        
        listy.clear();
        System.out.println("4) " + listy);
    }    
}