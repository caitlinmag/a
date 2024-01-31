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
//        return false;

        File f = new File(filename);
//        scanner to scan through file
        Scanner in = new Scanner(f);

        //Create stack to hold html tags
        Stack<String> htmlStack = new Stack<String>();

        //Make a string to check the tags
        String tag = "";

//        //opening tag - push to stack
//        htmlStack.push(tag);

        //if at the end of the stack is empty (top element) - opening tag
        while (in.hasNext()) {
            tag = in.next();

            //check opening tag - also must have a closing tag
            //opening tag then push
            if (tag.startsWith("<")) {
                //push it on to the stack
                htmlStack.push(tag);

                //checking closing tag
                if (tag.endsWith("</")) {
                    //while there are nesting tags within the opening and closing tags
                    while (tag.contains("<") && !tag.endsWith("/>")) {
                        htmlStack.push(tag);
                    }
                }
//                //check if there is another tag - and if it is it needs to be closed
//                if (tag.contains("<")) {
//                    //push other tag to stack
//                    htmlStack.push(tag);
//                }

                //does it contain a closing tag
//                if (htmlStack.lastElement().startsWith("</") && htmlStack.lastElement().matches(htmlStack.peek())) {
//                    //closing tag - pop from the stack
//                    htmlStack.pop();
//                }
            }
        }
        //        return false;
        if (htmlStack.isEmpty()) {
            System.out.println("The tags match." + "Opening tag " + htmlStack.firstElement() + " and closing tag " + htmlStack.lastElement());

        } else {
            System.out.println("The tags do not match." + "Opening tag " + htmlStack.firstElement() + " and closing tag " + htmlStack.lastElement());
            //closing tag - then pop the stack - when the opening and closing tag dont match
        }
        return htmlStack.isEmpty();
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
