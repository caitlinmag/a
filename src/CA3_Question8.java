import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */
public class CA3_Question8 {
    /*
        Arithmetic Expression Calculator (Stack)
     */

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation, one number or operator per line.");
        equation = in.nextLine().trim();
        /*
            Using 2 stacks
            Result should be in the numbers stack at the end of the equation
            Operators stack is used solely to hold the operators
         */
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        //Iterate through the length of the equation
        for (int i = 0; i < equation.length(); i++) {
            //i is equal to char c
            char c = equation.charAt(i);
            /*
                Read in a number
                Then Push to numbers stack
             */
            if (in.hasNextInt()) {
                numbers.push((int)c);
            }
            /*
                Read an opening parenthesis (
                Then Push on to operators stack
            */
            else if (c == ('(')) {
                operators.push(c);
            }
            /*
                Read an operator op
                While the top of the stack has a higher precedence than op
                Then Evaluate top
                Pop the opening parenthesis
            */
            else if (isOperator(c)) {
                while(highPrecedence(operators.peek()) == true && highPrecedence(c) == false) {
                    evaluateTop(numbers, operators);
                }
//                while (highPrecedence(operators.peek()) >= highPrecedence(c)) {
//                    evaluateTop(numbers, operators);
//                }
                operators.pop();
            }
            /*
                Read a closing parenthesis )
                While the top of the stack is not )
                Then evaluate the top
                And pop the closing parenthesis )
             */
            else if (c == (')')) {
                while (operators.peek() != c) {
                    evaluateTop(numbers, operators);
                }
                operators.pop();
            }
            /*
                No input
                While operator stack is not empty then evaluate the top
             */
//            else if (!in.hasNextLine()) {
//                while (!operators.isEmpty()) {
//                    evaluateTop(numbers, operators);
//                }
//            }

            else{
                while(!operators.isEmpty()){
                    evaluateTop(numbers,operators);
                }
            }
        }
        //Output the numbers stack after
        System.out.println(numbers);
    }

    /*
        Method to check if the character is an operator
        Return true or false depending on the user input
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /*
        Method to check if an operator has a higher precedence as another operator
        * and / has highest precedence
        + and - have the lowest precedence
     */
    public static boolean highPrecedence(char op) {
        if (op == '+' || op == '-') {
            return false;
        }
        else if (op == '*' || op == '/') {
            return true;
        }else{
            return false;
        }
    }

    /*
        Method to evaluate top
        Calculations with operators will be done in this method
     */
    public static void evaluateTop(Stack<Integer> numbers, Stack<Character> operators) {
        /*
            Pop two numbers off numbers stack
            Pop one operator off operators stack
        */
        int num1 = numbers.pop();
        int num2 = numbers.pop();
        char op = operators.pop();

        /*
            Using a switch statement to handle the operators - depending on which operator has been entered
            Combine the numbers with the operator
            Push the result to the numbers stack
        */

        switch (op) {
            //add numbers
            case '+':
                numbers.push(num1 + num2);
                break;
            //subtract numbers
            case '-':
                numbers.push(num1 - num2);
                break;
            //multiply numbers
            case '*':
                numbers.push(num1 * num2);
                break;
            //divide numbers
            case '/':
                numbers.push(num1 / num2);
            break;
        }

    }
}


