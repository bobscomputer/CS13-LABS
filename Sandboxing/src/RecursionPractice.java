public class RecursionPractice {
    public static void main(String[] args) {
        walk(5);
        num(1, 21);
        System.out.println("Hello World");
        reverseString("Hello World");
    }

    // from bro code youtube video, displays how many steps taken in ascending order
    public static void walk(int steps) {
        if(steps == 0) // base case
            return;
        walk(steps-1); // recursive case, builds the call stack
        System.out.printf("You walked %d step(s).%n", steps); 
    }

    // from lecture, displays numbers from min to max using recursion
    public static void num(int min, int max) {
        if(min > max) { // base case 
            System.out.println();
            return;
        }

        System.out.print(min + " "); 
        num(min+1, max); // recursive case
    }

    // practice question, create a method that reverses string with recursion
    public static void reverseString(String token) {
        if(token.length() == 0) { // base case
            System.out.println();
            return;
        }

        String subString = token.substring(token.length()-1);
        System.out.print(subString);
        reverseString(token.substring(0, token.length()-1)); // recursive case
    } 
}
