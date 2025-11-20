import java.util.Arrays;

// thank you Bro Code code explanations 
// all time complexities for sorting algos in this program are O(n^2)
// insertion sort is typically preferred over bubble & selection because it take less steps
// and in best case, could be O(n)
public class SelectionAndSortingPractice {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,7,8,9,10,12,14}; // for binary search
        int[] unsortedList = {8, 7, 6, 5, 4, 3, 2, 1}; // for sorting algos

        // binary search 
        System.out.println("Binary search test: " + Arrays.toString(list));
        System.out.println("Value 90 found at index: " + binarySearch(list, 90));

        // bubble sort
        System.out.println("\nBubble Sort\n" + Arrays.toString(unsortedList) + " (Unsorted)");
        bubbleSort(unsortedList);
        System.out.println(Arrays.toString(unsortedList) + " (Sorted)");

        // reset list to be unsorted
        unsortedList = new int[]{8, 7, 6, 5, 4, 3, 2, 1}; 

        // selection sort
        System.out.println("\nSelection Sort\n" + Arrays.toString(unsortedList) + " (Unsorted)");
        selectionSort(unsortedList);
        System.out.println(Arrays.toString(unsortedList) + " (Sorted)");

        // reset list
        unsortedList = new int[]{8, 7, 6, 5, 4, 3, 2, 1}; 

        // insertion sort
        System.out.println("\nInsertion Sort\n" + Arrays.toString(unsortedList) + " (Unsorted)");
        insertionSort(unsortedList);
        System.out.println(Arrays.toString(unsortedList) + " (Sorted)");
    }

    public static int binarySearch(int[] list, int token) {
        int min = 0;
        int max = list.length-1;
        int value = -1;
        boolean valueFound = false;
        
        while( (min <= max) && (!valueFound) ) {
            int mid = (min+max)/2;
            
            if(list[mid] == token) {
                value = mid;
                valueFound = true;
            }
            else if(list[mid] < token) min = mid+1;
            else max = mid-1;
        }
        return value;
    }

    public static void bubbleSort(int[] list) {
        int temp;

        // for each iteration, '-1' because we are comparing pairs
        for(int i=0; i<list.length-1; i++) {    
            //for each iteration, check each pair, ignore already sorted values
            for(int j=0; j<list.length-i-1; j++) { 
                // if the first element in a pair is greater than the next, swap
                if(list[j] > list[j+1]) {
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] list) {
        boolean swap = false;

        // assumes the lowest index is the min val '-1' because we compare in pairs
        for(int i=0; i<list.length-1; i++) {
            int min = i;

            // finds min value. 'i+1' to ignore already sorted values 
            for(int j=i+1; j<list.length; j++) {    
                if(list[min] > list[j]) {   // found min
                    min = j;
                    swap = true;
                }
            }

            // swap. swaps regardless of whether or not the min value is in its proper place
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
    }
    
    public static void insertionSort(int[] list) {
        // iterates through entire list. 'i=1' because we assume the first elem. is sorted
        // keeps track of our index to compare to the rest of the list
        for(int i=1; i<list.length; i++) {
            int temp = list[i];
            int j = i-1;    // starts at 0

            // continues to shifts values if the previous element is greater than the next
            // while we are still checking indicies & previous element is > next elem
            while( (j>=0) && (list[j] > temp) ) { 
                list[j+1] = list[j];
                j--; // check the previous elements until we reach the beginning
            } 
            // get next value to compare
            list[j+1] = temp;
        }
    }
}
