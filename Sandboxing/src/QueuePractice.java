import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<Integer> qList = new LinkedList<>();

        qList.add(1);
        qList.add(2);
        qList.add(3);

        // Reverse the queue list
        System.out.println("Practice task: Reverse the list");
        System.err.println(qList);
        reverseIntQueue(qList);
        System.err.println(qList);

        // Find the largest element
        System.out.println("\nPractice task: Find the largest element");
        System.out.println(qList);
        maxNum(qList);

    }

    // Algorithm from lecture notes for reversing a list from a queue using a stack
    public static Queue<Integer> reverseIntQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> rQueue = new LinkedList<>();
        rQueue = q;

        // move the elments from the queue into stack. FIFO --> LIFO
        while(!q.isEmpty()) {
            s.push(q.remove());
        }

        // move elements from the stack back to the queue
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
        return rQueue;
    }

    // Algo for finding the max element in a queue, preserves queue
    // you can't preserve the original queue and return the max.
    public static Queue<Integer> maxNum(Queue<Integer> q) {
        int max = 0;
        Queue<Integer> copy = new LinkedList<>();

        // search through the whole list
        while(!q.isEmpty()) {
            int i = q.remove();

            // if element 'i' > current max, max is 'i'
            if (i > max) {
                max = i;
            }
            copy.add(i);    // to preserve the queue
        }
        System.out.printf("Max = %d", max);
        return copy;
    }
}
