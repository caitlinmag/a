import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */

public class CA3_Question5 {
/*
    Airport Flights (Queue)
 */

    /*
    QUEUES:
    add to one end (the tail)
    remove from other end (the head)
     */

    public static void main(String[] args) {
        //create 2 queues - takeoff and landing
        Queue<String> takeoff = new LinkedList<>();
        //landing a flight is priority - therefore use a priority queue
        PriorityQueue<String> land = new PriorityQueue<>();

        Scanner kb = new Scanner(System.in);
        String choice = "";
        do {
            System.out.println("Enter takeoff, land, next or quit: ");
            String flightSymbol = "";
            String flight = "";

//            first 2 commands place flight in appropriate queue - takeoff and land

            choice = kb.next();
            //There are 4 Commands : takeoff, land, next or quit
            //TAKEOFF - put into takeoff queue
            if (choice.equalsIgnoreCase("takeoff")) {
                flightSymbol = kb.next();
                //add the flight symbol to the takeoff queue
                takeoff.add(flightSymbol);
                System.out.println("Flight: " + flightSymbol + " in the queue for takeoff");

                //LAND
            } else if (choice.equalsIgnoreCase("land")) {
                flightSymbol = kb.next();
                //add the flight symbol to the land queue
                land.add(flightSymbol);
                System.out.println("Flight: " + flightSymbol + " in the queue for landing");

                //NEXT
            } else if (choice.equalsIgnoreCase("next")) {
                //next - finishes the current take off or landing and enables next one
                //landing a plane gets priority
                if (!land.isEmpty()) {
                    //poll() to remove the top of the land queue
                    flight = land.poll();
                    System.out.println("Flight: " + flight + " is landing");
                } else if (!takeoff.isEmpty()) {
                    //poll() to remove and return element at top of the queue
                    flight = takeoff.poll();
                    System.out.println("Flight: " + flight + " is ready for takeoff");
                } else {
                    System.out.println("There are no flights due to land or takeoff");
                }
            }
            //quit - exit out of flight simulation
        } while (!choice.equalsIgnoreCase("quit"));
    }
}
