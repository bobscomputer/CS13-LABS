/*
Name: Lynn Castro
Date: 11/11/2025
Description: Demonstarting my understanding of stacks and infix to postfix expressions
Testimony: All implemented code is written by me
========================================================
TOTAL Self grade score: /100

EXPLANATIONS...
Proper naming:  (/5)
Indendation: (/5)
Comments: (/25)
Program compiles: (/30)
Program runs & the output is similar to provided output: (/25)
Requirements: (/25)
Self grade: (/5)
========================================================

Must follow the exact given algorithm

Extra feature(30 points):  add another operator %. This operator has the same precedence as * and /.
Must modify the code so accordingly. 
In your driver every expression that you create must have a % operation in it.
(20 points) Your driver must be completely different than the given one. 
Copying the given driver will lose 20 points.

The code must be implemented based on the given directions and methods. 
Any code that does not have the same exact methods will get zero points

Do not delete any of the given comments. 

Your code must generate the given ouput exactly.
Make sure to run your code and compare it with the given output. 

Make sure to place {} in the places that are given. Moving the brackets will cause errors 

Sample OUTPUT
Infix                                   postfix                                 Result              
 _____________________________________________________________________________________
 
 2 + 3 + 7 * 4 - 2 / 3			[2, 3, +, 7, 4, *, +, 2, 3, /, -]	=			33
 3 - 4 / 2 + 6 * 3 * 8			[3, 4, 2, /, -, 6, 3, *, 8, *, +]	=			145
 5 * 6 - 8 + 2 * 9 / 7			[5, 6, *, 8, -, 2, 9, *, 7, /, +]	=			24
 4 + 8 * 3 - 2 / 3 + 3			[4, 8, 3, *, +, 2, 3, /, -, 3, +]	=			31
 6 - 3 + 6 / 2 * 4 - 8			[6, 3, -, 6, 2, /, 4, *, +, 8, -]	=			7
 2 + 3 * 6 + 7 - 8 * 2			[2, 3, 6, *, +, 7, +, 8, 2, *, -]	=			11
 2 * 3 + 4 / 3 * 2 + 6			[2, 3, *, 4, 3, /, 2, *, +, 6, +]	=			14
 2 * 3 + 1 - 3 * 4 + 5			[2, 3, *, 1, +, 3, 4, *, -, 5, +]	=			0
 1 + 2 * 3 - 6 * 7 + 2			[1, 2, 3, *, +, 6, 7, *, -, 2, +]	=			-33
 5 * 6 - 8 + 2 * 1 * 9			[5, 6, *, 8, -, 2, 1, *, 9, *, +]	=			40
 6 - 3 + 6 / 2 * 4 - 8			[6, 3, -, 6, 2, /, 4, *, +, 8, -]	=			7
 9 + 8 * 7 - 6 * 4 / 2			[9, 8, 7, *, +, 6, 4, *, 2, /, -]	=			53
                                   
*/

import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

public class ExpressionCastro {
}

class Expressions {
    private String exp;

    public Expressions(String s) {
        exp = s;
    }

    public String getExp() {
        return exp;
    }

    public String toString() {
        return exp;
    }

    // Gets a string, separates each token and stores into an Arraylist; spaces are NOT included in the list.
    private static ArrayList<String> token(String exp) {
        ArrayList<String> tokens = new ArrayList<>();

        for(int i=0; i<exp.length(); i++) {
            if(exp.charAt(i) != ' ') {
                tokens.add(Character.toString(exp.charAt(i)));
            }
        }
        return tokens; 
    }

    // Creates a postfix expression String array
    // Algorithm is based on the algorithm from prof's video lecture
    public String[] getPostfix() {
        // declare a stack and instantiate it, call the stack s
        Stack s = new Stack();
        String operations = "*+-/%"; // added %

        // call the method token(exp) to get the infix exp, store the result in an arraylist of String
        ArrayList<String> tokens = token(exp);

        // declare an array of string with the size of tokens. This array will hold the postfix. call this array 'post'
        String[] post = new String[tokens.size()];

        int index = 0; // this will be used as the index for the array that will hold the postfix, size of arraylist tokens

        // while there are still symbols to scan
        while(tokens.size() > 0) {

            // get the curr element of our infix exp to scan
            String currToken = tokens.get(0); // changed from index to 0
            tokens.remove(0); // changed from index to 0

            // if the token is not a digit, token is an operator
            // condition was given from prof's file
            if(operations.indexOf(currToken) != -1) {

                // if the token is (+) or (-), precedence = 1
                if(precedence(currToken) == 1) {

                    // while s is not empty and precedence of the top of the stack is greater or equal to the current token
                    while( (!s.isEmpty()) && (precedence((String)(s.peek())) >= 1)) {
                        // pop the top of the stack and store it in the array post at index
                        post[index] = (String) s.pop();
                        index++;
                    }

                    // stack is empty OR token has higher precedence than top of stack
                    if( (s.isEmpty()) || (precedence(currToken) > precedence((String)(s.peek()))) ) {
                        s.push(currToken);
                    }
                }

                // else if the token is (*), (/), or (%), precedence = 2
                else if(precedence(currToken) == 2) {

                    // while the stack is not empty, and the precedence of the top of the stack is 1 or 2 (peek method must be used)
                    while( (!s.isEmpty()) && (precedence((String)(s.peek()) ) == 2) ) {
                        // pop the top of the stack and store it in the array post at index
                        post[index] = (String) s.pop();
                        index++;
                    }

                    // stack is empty OR token has higher precedence than top of stack
                    if( (s.isEmpty()) || (precedence(currToken) > precedence((String)(s.peek()))) ) {
                        s.push(currToken);
                    }
                }
                
            } 

            // token is a digit
            else {
                // store the token in the array post at the index
                post[index] = currToken;
                index++;
            }
        }

        // store the rest of our stack into the post infix, while the stack s is not empty
        while(!s.isEmpty()) {
            // pop an element from the stack, store it in the array post at index
            post[index] = (String) s.pop();
            index++;
        }
        return post;
    }

    // returns the level of precedence of a given operator
    // MUST ADD '%' operator; has same precedence as * and /
    private static int precedence(String opr) {
        String[] operators = { "+", "-", "*", "/" , "%"};
        int precedence = -1;

        // if opr is the same as the array operators at index 2, 3, or 4 return 2
        if( (opr.equals(operators[2]) ) || ( (opr.equals(operators[3])) ) || ( (opr.equals(operators[3])) ) ) {
            precedence = 2;
        }

        // if opr is the same as the array operators at index 0 or 1 return 1
        else {
            precedence = 1;
        }

        return precedence;
    }

    // evalulates/calculates the postfix expression. algorithm is based on the algorithms from the lectures.
    // the generates postfix expression is stored in the array; this method calls the getPostfix method
    public int evalPostfix() {
        String opr = "*/%+-"; // added %
        String[] post = this.getPostfix(); // creating the postfix expression

        System.out.print("\t\t\t" + Arrays.toString(post) + "\t=");

        Stack s = new Stack(); // this stack is used to push the numbers in the postfix
        int result = 0;

        int index = 0;
        // while index is less than the length of post
        while(index < post.length)
        {
            // declare a variable of type String and store post[index] in it
            String token = post[index];

            // increment the index
            index++;

            // if token is a digit
            if(opr.indexOf(token) == -1) {
                // push the token to the stack s
                s.push(token);
            }

            // else, token is an operator
            else {
                // pop the top 2 values to apply the operator
                String n2 = (String) s.pop();
                String n1 = (String) s.pop();

                // convert the string values into ints to be calculated
                int num2 = Integer.parseInt(n1);
                int num1 = Integer.parseInt(n2);

                // call the method calculate and pass num1, num2, token to it, store the result in a variable
                result = calculate(num1, num2, token);

                // push the result to the stack
                s.push(result);
            }
        }
        // final value, pop the stack, convert it to an integer, return the result
        result = Integer.parseInt((String) s.pop());
        return result; 
    }

    // calculates an expression given two numbers and an operator
    // The operator "%" must be added. The "%" CAN'T have the denominator as zero
    // partial code is given (?)
    private int calculate(int num1, int num2, String operator) {
        int solution = -1;

        if(operator == "+") {
            solution = num1 + num2;
        }

        else if(operator == "-") {
            solution = num1 - num2;
        }

        else if(operator == "*") {
            solution = num1 * num2;
        }

        else if(operator == "/") {
            solution = num1 / num2;
        }

        else if(operator == "%") {
            if(num2 != 0) {
                solution = num1 % num2;
            }
        }

        return solution; 
    }
}


// MUST create 5 DIFFERENT expression, each expression must have AT LEAST 5 operators
// MUST be SIMILAR to the given Driver and include expressions with "%"

/*
class ExpDriver {
    public static void main(String[] args) {
        String problem1 = "2 + 3 + 7 * 4 - 2 / 3";
        Expressions prob1 = new Expressions(problem1);

        System.out.printf("%nInfix exp: %s", prob1.getExp());

        System.out.println("\nTurning infix to postfix...");
        
        System.out.printf("%nPostfix exp: %s", Arrays.toString(prob1.getPostfix()));
    }
}
*/

/*
 * Once all the methods have been implemented. Uncomment the given driver to test your code
 * The following driver must work with your code.
 */

  
class Driver {
   public static void main(String[] args) {
       LinkedList<String> list = new LinkedList<String>();
       list.add("2 + 3 + 7 * 4 - 2 / 3");
       list.add("3 - 4 / 2 + 6 * 3 * 8");
       list.add("5 * 6 - 8 + 2 * 9 / 7");
       list.add("4 + 8 * 3 - 2 / 3 + 3");
       list.add("6 - 3 + 6 / 2 * 4 - 8");
       list.add("2 + 3 * 6 + 7 - 8 * 2");
       list.add("2 * 3 + 4 / 3 * 2 + 6");
       list.add("2 * 3 + 1 - 3 * 4 + 5");
       list.add("1 + 2 * 3 - 6 * 7 + 2");
       list.add("5 * 6 - 8 + 2 * 1 * 9");
       list.add("6 - 3 + 6 / 2 * 4 - 8");
       list.add("9 + 8 * 7 - 6 * 4 / 2");
       Iterator<String> itr= list.iterator(); 
       System.out.printf("%-40s%-40s%-40s", "Infix", "postfix","Result"); 
       System.out.println("\n_____________________________________________________________________________________");
       System.out.println(); 
       while (itr.hasNext()) {
           String infix = itr.next();
           Expressions e = new Expressions(infix);
           System.out.print(e);
           String[] post = e.getPostfix();
           //System.out.println(Arrays.toString(post));
           int result = e.evalPostfix();
           System.out.print("\t" + result);
           System.out.println();   
      }
   }
}
