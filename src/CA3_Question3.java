import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */

public class CA3_Question3 {
    /*
        Java Identifier Count (Map)
     */
    public static void readFile(String fileName) throws FileNotFoundException {
        //read a java source file - fileName defined in the main
        File f = new File(fileName);

        //Declare scanner in to read from the source file
        Scanner in = new Scanner(f);

        //call delimiter - identifier considered as a string consisting only of letters, numbers , and underscrores
        in.useDelimiter("[^A-Za-z0-9_]+");

        /*
             create a map to hold identifiers(String) and an integer arrayList to hold multiple line numbers
             in the case that a delimiter is present in multiple lines
         */
        Map<String, ArrayList<Integer>> identifierMap = new HashMap<>();

        //key is the identifier
        String key = "";

        //count line numbers starting from 0
        int lineNum = 0;

        //create a while loop to scan through the file
        while (in.hasNext()) {
            //calling in.next() returns an identifier
            key = in.next();
            //increment the line number for each identifier
            lineNum++;

            //if the identifier is not in the map
            if (!identifierMap.containsKey(key)) {
                // Create arraylist to store multiple line numbers
                ArrayList<Integer> multipleLines = new ArrayList<>();
                //Add the line number into the arraylist
                multipleLines.add(lineNum);
                //Put the identifier (key) and its line number (multiple lines) into the  map
                identifierMap.put(key, multipleLines);
            } else {
                //if identifier is only on one line then add the line number to the map
                identifierMap.get(key).add(lineNum);
            }
        }

        System.out.println("Identifiers and corresponding line numbers:");

        /*
            Iterating through the identifierMap using an enhanced for loop
            Using the same type of format that is used in the MapsDemo example that we did in class
         */
        for (Map.Entry<String, ArrayList<Integer>> entry : identifierMap.entrySet()) {
            key = entry.getKey();
            ArrayList<Integer> multipleLines = entry.getValue();
            System.out.println(key + " -> " + multipleLines);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
