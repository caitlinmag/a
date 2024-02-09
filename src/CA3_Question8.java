import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question8 {
    /*
    Implement a calculator to evaluate arithmetic expressions for the operators + - * / and
    parenthesis ( ). See the accompanying PDF document which is an extract from a book
    explaining the algorithm.

    Using a stack
     */


    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation, one number or operator per line.");
        equation = in.nextLine().trim();

        Stack<Integer> nums = new Stack<>();
        Stack<Integer> operators = new Stack<>();
        Stack<Integer> results = new Stack<Integer>();
        boolean finished = false;

        while (!finished) {
            if (in.hasNextInt()) {
                nums.push(in.nextInt());
            } else if (in.equals("+")) {
                results.push(results.pop() + results.pop());
            } else if (in.equals("-")) {
                Integer arg2 = results.pop();
                results.push(results.pop() - arg2);
            } else if (in.equals("*") || in.equals("x")) {
                results.push(results.pop() * results.pop());
            } else if (in.equals("/")) {
                Integer arg2 = results.pop();
                results.push(results.pop() / arg2);
            } else if (in.equals("()")) {
                operators.push(operators.pop());
            } else if (in.equals("q") || in.equals("Q")) {
                finished = true;
            } else {
                //not operator - integer
//                results.push(Integer.parseInt(in));
            }
            System.out.println(results);
        }

        //read number - push to stack

        //read operand - pop TWO values off stack
        //combine values with operand - push result on to stack

        //No more input - pop and display result

    }
}
