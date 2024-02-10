import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */
public class CA3_Question1 {
    /*
        Car Parking (Stack)
     */
    public static void runSimulation() {
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        Scanner kb = new Scanner(System.in);
        int carNumberplate;

        do {
            System.out.println("Enter car numberplate, to add (positive number) and retrieve (negative number), 0 to stop");
            carNumberplate = kb.nextInt();

            /*
                To retrieve a car - the number will be negative
                Check if the driveway is NOT empty - then there are cars in the driveway
                If the car is NOT the top element in the stack or (last car in the driveway)
                Then Cars behind need put on to the street (so push to street stack)
                Pop cars (that are in the way) from the driveway stack
                Then push to street stack
             */

            if (carNumberplate < 0) {
                if (!driveway.isEmpty()) {
                    while (driveway.peek() != -carNumberplate) {
                        street.push(driveway.pop());
                        System.out.println("Cars moved to street: " + street);
                        System.out.println("Cars in driveway: " + driveway);
                    }
                    //if car is the last car in it can automatically be removed with no issues
                    driveway.pop();

                    while (!street.isEmpty()) {
                        //Back to driveway
                        driveway.push(street.pop());
                    }
                }
            }
            /*
                To add a car - the number will be positive
                Adding the car to the top of the driveway stack
                The street stack will be empty if a car is being added to the driveway
             */
            else if (carNumberplate > 0) {
                driveway.push(carNumberplate);
                System.out.println("The car: " + carNumberplate + " has been added. Driveway: " + driveway);
            }
            else {
                System.out.println("Invalid car number plate");
            }
            System.out.println("Driveway: " + driveway + " Street: " + street);

            //Run until user inputs 0 to exit
        } while (carNumberplate != 0);
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
