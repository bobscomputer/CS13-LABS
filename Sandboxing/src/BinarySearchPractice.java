import java.util.*;

class BinarySearchPractice {
    public static void main(String[] args) {

        // practice problem 3, given the following list, find the index of 13 using binary search
        int[] list = {2, 4, 7, 10, 13, 18, 20};

        System.out.printf("%nList: %s", Arrays.toString(list));
        System.out.printf("%n(target = 13) Target found in list at index %d.", binarySearch(list, 13));
        System.out.printf("%n(target = 12) Target found in list at index %d.", binarySearch(list, 12));
    }

    public static int binarySearch(int[] list, int target) {
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
}