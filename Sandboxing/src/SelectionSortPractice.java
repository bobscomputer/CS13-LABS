import java.util.*;

class SelectionSortPractice {
    public static void main(String[] args) {
        // lists to be tested
        int[] list1 = {2, 4, 7, 10, 13, 18, 20};
        String[] list2 = {"Apple", "Orange", "Banana", "Grape", "Strawberry"};
        int[] list3 = {2, 7, 8, 91, 42, 67};
        String[] list4 = {"Orange", "Apple", "Banana", "Strawberry", "Grape"};
        int[] list5 = {7, 5, 21, 1, -73, 67, -5};



        // testing binary search for integers
        System.out.printf("%nList: %s", Arrays.toString(list1));
        System.out.printf("%n(target = 13) Target found in list at index %d.", intBinarySearch(list1, 13));
        System.out.printf("%n(target = 12) Target found in list at index %d.", intBinarySearch(list1, 12));

        // testing binary search for Strings
        Arrays.sort(list2);
        System.out.println();
        System.out.printf("%nList: %s", Arrays.toString(list2));
        System.out.printf("%n(target = 'Strawberry') Target found in list at index %d.", stringBinarySearch(list2, "Strawberry"));
        System.out.printf("%n(target = 'Mandarin') Target found in list at index %d.", stringBinarySearch(list2, "Mandarin"));

        // bubble sort testing
        System.out.println("\n");
        System.out.println("List before calling bubble sort method: " + Arrays.toString(list3));
        bubbleSort(list3);
        System.out.println("List after calling bubble sort method: " + Arrays.toString(list3));

        System.out.println();
        System.out.println("List before calling bubble sort method: " + Arrays.toString(list4));
        bubbleSort(list4);
        System.out.println("List after calling bubble sort method: " + Arrays.toString(list4));

        System.out.println();
        System.out.println("List before calling selection sort method: " + Arrays.toString(list5));
        selectionSort(list5);
        System.out.println("List after calling selection sort method: " + Arrays.toString(list5));
    }

    // binary search for integers
    public static int intBinarySearch(int[] list, int target) {
        int first = 0;
        int last = list.length - 1;
        int targetIndex = -1;
        boolean targetFound = false;

        // avoids infinite looping if target element is not in list. 
        while((first <= last) && (targetFound == false)) {
            int mid = (first + last)/2;

            // target is found
            if(target == list[mid]) {
                targetIndex = mid;
                targetFound = true;
            }

            // mid-point is greater than target
            else if(target < list[mid]) {
                last = mid - 1;
            }

            // mid-point is less than target
            else {
                first = mid + 1;
            }
        }
        return targetIndex;
    }

    // binary search for Strings
    public static int stringBinarySearch(String[] list, String target) {
        int first = 0;
        int last = list.length - 1;
        int targetIndex = -1;
        boolean targetFound = false;

        while( (first <= last) && (targetFound == false) ) {
            int mid = (first + last)/2;

            if(list[mid].equalsIgnoreCase(target)) {
                targetIndex = mid;
                targetFound = true;
            }

            // mid-point is less than target string
            else if(list[mid].compareTo(target) < 0) {
                first = mid + 1;
            }

            // mid-point is greater than target string
            else {
                last = mid - 1;
            }
        }
        return targetIndex;
    }

    // testing my own bubble sort, i created without seeing an algo for it (17 mins)
    public static void bubbleSort2(int[] list) {
        int pos1;
        int pos2;
        int swaps = 1;

        while(!(swaps == 0)) {
            swaps = 0;
            for(int i=0; i<list.length-1; i++) {
                pos1 = list[i];
                pos2 = list[i+1];

                // pos1 is greater than pos2, swap is necessary.
                if(list[i] > list[i+1]) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    
                    swaps++;
                }
                // else, pos1 is < pos2 or pos1 == pos2
            }  
        }
    }

    // actual bubble sort algo from professor
    public static void bubbleSort(int[] list) {
        for(int i=0; i<list.length-1; i++) {
            for (int j=0; j<list.length-1-i; j++) {
                if(list[i] > list[i+1]) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                }
            }
        }
    }

    // string bubble sort
    public static void bubbleSort(String[] list) {
        for(int i=0; i<list.length-1; i++) {
            for (int j=0; j<list.length-1-i; j++) {
                if(list[i].compareTo(list[i+1]) > 0) {
                    String temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                }
            }
        }
    }

    // selection sort
    public static void selectionSort(int[] list) {
        
        // keeps track of the next element to be swapped
        for(int i=0; i<list.length-1; i++) {
            int min = list[i];
            int index = -1;
            boolean swap = false;

            // each iteration to find min. value, ignores the already properly sorted elements
            for(int j=i+1; j<list.length; j++) {
                if(min > list[j]) {
                    index = j;
                    min = list[j];
                    swap = true;
                }
            }
            
            // swap AFTER finding the minimum value after from an iteration
            if(swap) {
                int temp = list[i];
                list[i] = list[index];
                list[index] = temp;
            }
        }
    }
}
