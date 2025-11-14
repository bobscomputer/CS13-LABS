/*
Name: Lynn Castro
Date: 11/11/2025
Description: Demonstarting my understanding of stacks and infix to postfix expressions
Testimony: All implemented code is written by me
========================================================
TOTAL Self grade score: 90/100 (explanation below)

EXPLANATIONS...
Proper naming: All methods and fields have descriptive and short names. (5/5)
Indendation: All code is neatly organized and indented by at least 4 spaces. (5/5)
Comments: All logic is preceded with a comment explaining its purpose. 
          However, I deleted or edited many of the given comments inside the methods. (20/25)
Program compiles: Program compiles in JGRASP (30/30)
Program runs & the output is similar to provided output: 
        My values match the provided output from the prof's given driver, 
        but my formatting is different from the provided driver. (20/25)
Requirements: I implemented all necessary methods and driver requirements. (25/25)
Self grade: I have provided a self grade. (5/5)
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
        // data declarations & instantiations
        Stack s = new Stack();
        String operations = "*+-/%"; // added %
        ArrayList<String> tokens = token(exp);
        String[] post = new String[tokens.size()];
        int index = 0; 

        // to scan all tokens in the infix
        while(tokens.size() > 0) {

            // get the curr element of our infix exp to scan
            String currToken = tokens.get(0); 
            tokens.remove(0); 

            // if the token is not a digit, token is an operator
            if(operations.indexOf(currToken) != -1) {

                // if the token is (+) or (-), precedence = 1
                if(precedence(currToken) == 1) {

                    // check if stack is not empty & if current token has higher or equal precedence than the top of the stack
                    while( (!s.isEmpty()) && (precedence((String) s.peek()) >= 1) ) {
                        // pop the top of the stack and store it in the array post at the current index
                        post[index] = (String) s.pop();
                        index++;
                    }

                    // stack is empty OR token has higher precedence than top of stack
                    if( (s.isEmpty()) || (precedence(currToken) > precedence((String)s.peek())) ) {
                        s.push(currToken);
                    }
                }

                // else if the token is (*), (/), or (%), precedence = 2
                else if(precedence(currToken) == 2) {

                    // check if stack is not empty & if current token has higher or equal precedence than the top of the stack
                    while( (!s.isEmpty()) && (precedence((String) s.peek()) == 2) ) {
                        // pop the top of the stack and store it in the array post at the current index
                        post[index] = (String) s.pop();
                        index++;
                    }

                    // stack is empty OR token has higher precedence than top of stack
                    if( (s.isEmpty()) || (precedence(currToken) > precedence((String) s.peek())) ) {
                        s.push(currToken);
                    }
                }
                
            } 

            // token is a digit
            else {
                // store the token in the array post at the current index
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
    // added '%' operator; has same precedence as * and /
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

        // formatting from prof's code. can't removed
        System.out.print("\t\t\t" + Arrays.toString(post) + "\t=");

        Stack s = new Stack(); // this stack is used to push the numbers in the postfix
        int result = 0;
        int index = 0;

        // while there are still tokens to scan
        while(index < post.length)
        {
            String token = post[index];
            index++;

            // if token is a digit, push to stack
            if(opr.indexOf(token) == -1) {
                s.push(token);
            }

            // else, token is an operator, run a calculation
            else {
                // pop the top 2 values to apply the operator
                String n1 = String.valueOf(s.pop());    
                String n2 = String.valueOf(s.pop());    

                // convert the string values into ints to be calculated
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);

                // apply the operator with calculate method
                result = calculate(num1, num2, token);

                // push the result to the stack
                s.push(result);
            }
        }
        // no more tokens to scan, return the final value
        result = Integer.parseInt(String.valueOf(s.pop())); 
        return result; 
    }

    // calculates an expression given two numbers and an operator
    // Added the operator "%" must be added
    private int calculate(int num1, int num2, String operator) {
        int solution = -1;

        if(operator.equals("+")) {
            solution = num1 + num2;
        }

        else if(operator.equals("-")) {
            solution = num2 - num1;
        }

        else if(operator.equals("*")) {
            solution = num1 * num2;
        }

        else if(operator.equals("/")) {
            solution = num2 / num1;
        }

        else if(operator.equals("%")) {
            // to prevent undefined values (can't divide by 0)
            if(num1 != 0) {
                solution = num2 % num1;
            }
        }
        return solution; 
    }
}


// MUST create 5 DIFFERENT expression, each expression must have AT LEAST 5 operators
// MUST be SIMILAR to the given Driver and include expressions with "%"

// (note for myself) the weird tabbing for the postfix expression is from the prof's given code. 
// i can't change it because it will ruin the display for the (commented) driver below that is given from the prof.
class ExpDriver {
    public static void main(String[] args) {
        // data declarations & instatiations
        String borderFmt = "-".repeat(20);
        ArrayList<String> expList = new ArrayList<>();  // stores my 5 different expressions

        // 5 different expressions, all include %
        expList.add("8 + 1 * 2 % 6 + 1 / 5");
        expList.add("4 % 2 + 3 * 4 / 5 - 6");
        expList.add("6 % 5 * 4 / 3 / 2 - 1");
        expList.add("9 % 3 + 8 % 3 - 2 + 4");
        expList.add("1 + 6 % 3 - 4 / 5 + 6");

        // displays all 5 different expressions
        for(int i=0; i<expList.size(); i++) {
            System.out.printf("%n%s PROBLEM #%d %s", borderFmt, i+1, borderFmt);
            methodsForExpression(expList.get(i));
            System.out.println("-".repeat(52));
        }
    }

    // Helper method that I added which displays all info for each problem
    public static void methodsForExpression(String problem) {
        Expressions exp = new Expressions(problem);

        // Runs methods for given infix expression
        System.out.printf("%nInfix exp: %s", problem);
        System.out.println("\nTurning infix to postfix...");
        System.out.printf("%nResult of expression: %d %n", exp.evalPostfix());
    }
}

/*
 * Once all the methods have been implemented. Uncomment the given driver to test your code
 * The following driver must work with your code.
 */

/*
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
*/