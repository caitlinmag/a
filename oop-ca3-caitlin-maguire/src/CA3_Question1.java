import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question1 {
    public static void runSimulation() {
        //create empty stacks
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        Scanner kb = new Scanner(System.in);
        int carNumberplate;

        do {
            System.out.println("Enter car numberplate, to add (positive number) and retrieve (negative number), 0 to stop");
            carNumberplate = kb.nextInt();

            //RETRIEVE - negative
            if (carNumberplate < 0) {
                //if driveway stack is NOT empty - (cars in the driveway)
                if (!driveway.isEmpty()) {
                    //check position of the car - then the cars behind will need pushed on to the street stack
                    while (driveway.peek() != -carNumberplate) {
                        //pop cars (in the way) from driveway stack
                        //push to the street stack
                        street.push(driveway.pop());
                        System.out.println("Cars moved to street: " + street);
                        System.out.println("Cars in driveway: " + driveway);
                    }
                    //if car is the last one in it can automatically be removed with no issues
                    driveway.pop();

                    while (!street.isEmpty()) {
                        //Back to driveway
                        driveway.push(street.pop());
                    }
                }
            }

            //ADD + positive - adds to the top of the driveway stack
            //street stack empty if car being added
            else if (carNumberplate > 0) {
                driveway.push(carNumberplate);
                System.out.println("The car: " + carNumberplate + " has been added. Driveway: " + driveway);
            }
            //else {
//                System.out.println("Invalid car number plate");
//            }
            System.out.println("Driveway: " + driveway + " Street: " + street);

//Run until user inputs 0 to exit
        } while (carNumberplate != 0);
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
