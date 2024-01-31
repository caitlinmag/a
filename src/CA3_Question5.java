import java.util.PriorityQueue;

/**
 * Name:
 * Class Group:
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

    public static class flights {
        private String takeoff;
        private String landing;

        public String getTakeoff() {
            return takeoff;
        }

        public void setTakeoff(String takeoff) {
            this.takeoff = takeoff;
        }

        public String getLanding() {
            return landing;
        }

        public void setLanding(String landing) {
            this.landing = landing;
        }

        public flights(String takeoff, String landing) {
            this.takeoff = takeoff;
            this.landing = landing;
        }
    }


    public static void main(String[] args) {
//create a priority queue

        //lowest value priority removed first which is 1


    }
}