import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question4 {
/*
Using stack
-in the powerpoint - 15.6 stack and queue applications -
slide 55 is similar to the question on html tags-
only difference is dealing with the opening and closing tags

Program to check if a sequence of HTML tags are properly nested
For each opening tag (eg <p> must have a closing tag </p>)
- p tag may have other tags (eg <p> <ul> <li> </li> </u> <a> </p>)
inner tags must be closed before outer tags
process a file containing tags
ASSUME tags are separated by spaces & there is no text inside tags
 */

    /*
        filename: name of the file to test.
     */
    public static boolean validate(String filename) throws FileNotFoundException {
        return false;
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;


     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }

        //Create stack to hold html tags
        Stack<String> htmlStack = new Stack<String>();

//        File f = new File(fileName);
        //scanner to scan through file
//        Scanner in = new Scanner();

        String tag = "";

        //opening tag - push to stack
        htmlStack.push(tag);

        //if opening and closing tags dont match
        //stack is not empty
        while (!htmlStack.isEmpty()) {
            htmlStack.pop();

            //if at the end of the stack is empty (top element) - opening tag
            if (!htmlStack.peek().isEmpty()) {
                htmlStack.push(tag);
            } else {
                //not balanced
                //closing tag - pop the stack
                htmlStack.pop();
            }


        }
    }
}
