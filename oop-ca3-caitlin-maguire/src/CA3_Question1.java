import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question1 {
    public static void runSimulation() {
//create empty stacks
        //car retrieved , cars up until this car to be moved (IF NOT THE LAST ONE IN) - negative
        //need if statement check the position of the car so if its the last one in it can automatically be removed with no issues
        //if not - then the cars behind will need pushed on to the street stack
        //push those cars to the street stack
        //when the car is removed
        //push the other cars back into the driveway stack

        //ADD + positive numbers 1 is car num 1
        //RETRIEVE - negative numbers -2 is car num 2

        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        //Adding cars to the driveway stack
        //AND Leaving the street stack empty for now
        driveway.push(1);
        driveway.push(2);
        driveway.push(3);
        driveway.push(4);
        driveway.push(5);

        Scanner kb = new Scanner(System.in);
        int carNumberplate;

        do {
            System.out.println("Enter car numberplate, to add (positive number) and retrieve (negative number), 0 to stop");
            carNumberplate = kb.nextInt();

            //RETRIEVE - negative
            if (carNumberplate < 0) {
                if (!driveway.isEmpty()) {
                    while (driveway.peek() != -carNumberplate) {
                        //pop cars (in the way) from driveway stack
                        //push to the street stack
                        street.push(driveway.pop());
                    }
                    driveway.pop();

                    while (!street.isEmpty()) {
                        //Back to driveway
                        driveway.push(street.pop());
                    }
                    System.out.println("Driveway: " + driveway + " Street: " + street);
                }
            }

            //ADD - positive - adds to the top of the driveway stack
            else if (carNumberplate > 0) {
                driveway.push(carNumberplate);
                System.out.println("The car: " + carNumberplate + " has been added. Driveway: " + driveway);
            }
            System.out.println("Driveway: " + driveway + " Street: " + street);

//Run until user inputs 0 to exit
        } while (carNumberplate != 0);
    }

    public static void main(String[] args) {
        runSimulation();
    }
}
