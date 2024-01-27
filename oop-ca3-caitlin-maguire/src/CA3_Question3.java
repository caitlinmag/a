import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Name:
 * Class Group:
 */

public class CA3_Question3 {
    /*
    Reading file
    produce index of all identifiers in file
    identifiers -> variable names, class names , and keywords
       Declare scanner in for reading file
       call in.useDelimiter("[^A-Za-z0-9_]+")
       Each identifier print all lines, with line number
       consider identifier as string consisting only of letters, numbers , and underscrores
       each call to next returns identifier
     */


    public static void readFile(String fileName) {
        File f = null;
        f = new File("src/CA3_Question1.java");

        //Declare scanner in to read from the source file
        Scanner in = new Scanner("src/CA3_Question1.java");
        //call delimiter
        in.useDelimiter("[^A-Za-z0-9_]+");

        //count the identifiers in the file
        int count = 0;

        //create a map
        Map<String, String> identifierMap = new TreeMap<>();

        //iterate through the file
        while (in.hasNextLine()) {

        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
