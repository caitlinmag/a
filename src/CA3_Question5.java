import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */

public class CA3_Question5 {

    /* What do i need to do?
    Using a queue to mimic airport flights
    - airport = ONLY 1 runway
    - runway is busy = planes (take off or landing) have to wait
    - landing planes get priority = PRIORITY QUEUE - so would be highest number
    - user enters commands takeoff flightSymbol, land flightSymbol, next and quit
    - first 2 commands place flight in appropriate queue
    - next command finishes the current take off or landing and enables the next one
    -> printing the action (takeoff or land) & the flight symbol

    Example: takeoff( “Flight-100”); // is queued
    takeoff(“Flight-220”); // is queued
    land(“Flight-320”); // is queued
    next(); // will complete the takeoff/landing of the
    // current flight and initiate landing of
    // the next prioritized flight’ i.e. Flight-320

queue is first in first out
removing element -> element with most urgent priority is retrieved
- so in this case if plane is landing it would get priority
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

        /*
        next - need to figure out how the program will decide which flight is priority
         and have it print out the flight number which will be taking off or landing next -
         as it is currently blank for the flight symbol
         */
        //create scanner
        Scanner kb = new Scanner(System.in);
        String choice = "";
        do {
            System.out.println("Enter takeoff, land, next or quit: ");
            String flightSymbol = "";
            String flight = "";

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
