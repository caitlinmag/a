import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        File f = new File(fileName);

        //Declare scanner in to read from the source file
        Scanner in = new Scanner(fileName);
        //call delimiter
        in.useDelimiter("[^A-Za-z0-9_]+");

        String line;
        String identifier;
        boolean hasHeaders = true;
        boolean headersRead = false;
        //count the identifiers in the file
        int countIdentifiers = 0;
        int countLines = 0;

        //while loop to iterate through the file
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (!hasHeaders || hasHeaders && headersRead) {
                if (line != "") {
                    countLines++;
                }

                while (in.hasNext()) {
                    countIdentifiers++;
                }
            } else {
                headersRead = true;
            }
            System.out.println(line);
        }

        //create a map - to hold the index and line number
        Map<Integer, Integer> identifierMap = new HashMap<>();
        identifierMap.keySet(); //returns all keys

    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
