import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Name:
 * Class Group:
 */

public class CA3_Question3 {
    /*
       What I need to do:
       Reading file
       produce index of all identifiers in file
       identifiers -> variable names, class names , and keywords
       Declare scanner in for reading file
       call in.useDelimiter("[^A-Za-z0-9_]+")
       Each identifier print all lines, with line number
       consider identifier as string consisting only of letters, numbers , and underscrores
       each call to next returns identifier
     */

    public static void readFile(String fileName) throws FileNotFoundException {
        //read a java source file - fileName defined in the main
        File f = new File(fileName);

        //Declare scanner in to read from the source file
        Scanner in = new Scanner(f);

        //call delimiter - identifier considered as a string consisting only of letters, numbers , and underscrores
        in.useDelimiter("[^A-Za-z0-9_]+");

        //create a map to hold identifiers(String) and their line numbers(Integer)
        Map<String, Integer> identifierMap = new HashMap<>();

        //Come back to question 3 and make the changes:
        //create a list to store when identifiers are in multiple lines
        //Would need to then add the list into the hashmap
        //Use an if statement within the while loop to check if the identifier (key) has been found already
        //Then it would be put into the list

        //key is the identifier
        String key = "";

        //count line numbers starting from 0
        int lineNum = 0;

        System.out.println("Identifiers and corresponding line numbers:");

        //create a while loop to scan through the file
        while (in.hasNext()) {
            //calling in.next() returns an identifier
            key = in.next();
            //increment the line number for each identifier
            lineNum++;
            //Put the identifier and its line number into the hash map
            identifierMap.put(key, lineNum);

            //display identifiers and the corresponding line numbers
            System.out.println(key + "  " +  lineNum);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
