import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */
public class CA3_Question4 {
/*
    Nested HTML Tags (Stack)
    - program is not fully working
 */

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner in = new Scanner(f);

        //Stack to hold html tags
        Stack<String> htmlStack = new Stack<String>();

        //if at the end of the stack is empty (top element) - opening tag
        while (in.hasNext()) {
            //Make a string to store tags in the file as strings
            String tag = in.next();

            //check if it is a closing tag - pop from stack
            if (tag.startsWith("</")) {
                //to get the closing inner tag - eg for </ul;> use 2,3 to get u
                String closingInnerTag = tag.substring(2,3);

                //Stack is NOT empty and the top element is equal to the closing tag
                if (!htmlStack.isEmpty() && htmlStack.peek().equals(closingInnerTag)) {
                    htmlStack.pop(); //pop from the stack
                } else {
                    //opening and closing tags dont match
                    htmlStack.push(tag);
                    return false;
                }
            } else if (tag.startsWith("<")) {
                htmlStack.push(tag); //opening tag so push to stack
            }
        }
        return true;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        //checking the correct files are valid and invalid
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }

    }
}
