import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */
public class CA3_Question10 {
/*
    Shortest distance to city
    Using (Map, Treeset, PriorityQueue)
    Program is not working - however I have made an attempt at following the helper code in the questions pdf
 */

    public static void main(String[] args) throws IOException {
        //All direct connections between cities stored in the map
        Map<String, TreeSet<DistanceTo>> map = new HashMap<>();
        //from is the starting point
        String from = "";

        //Priority queue - inserts by priority, removes lowest number first
        PriorityQueue<DistanceTo> q = new PriorityQueue<>();

        //add distanceTo(from 0) to a priority queue
        q.add(new DistanceTo(from, 0));

        //Construct map - city names to distances
        Map<String, Integer> shortestKnownDistance = new HashMap<>();
        shortestKnownDistance.put(from, 0);

        /*
            Read in lines from a file
            With the format : city1 city2 distance
            Starting point is first city first line
        */
        Scanner in = new Scanner(System.in);
        String filename;
        File f;
        System.out.println("Enter file name:");
        filename = in.nextLine();
        f = new File(filename);

        while (in.hasNext()) {
            String city1 = in.next();
            String city2 = in.next();
            int distance = in.nextInt();

            shortestKnownDistance.put(city1, distance);
            shortestKnownDistance.put(city2, distance);

            //while priority queue is not empty
            while (!q.isEmpty()) {
                //get smallest element of the queue
                DistanceTo d1 = q.poll();

                //if target is NOT a key in shortestKnownDistance map
                if (!shortestKnownDistance.containsKey(d1.getTarget())) {
                    //d is the distance to the target
                    int d = d1.getDistance();
                    //put (target,d) into the shortestKnownDistanceMap
                    shortestKnownDistance.put(d1.getTarget(), d);
                    //for loop - all cities that have a direct connection from the target
                    String c = d1.getTarget();
//                for(DistanceTo c : shortestKnownDistance.put(d1.getTarget(), d1.getDistance())){
//
//                }
                    //Add DistanceTo(c,d + distance from target to c) to priority queue
                    q.add(new DistanceTo(c, d));
                }
            }
        }

        //ArrayList containing city names and distances
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Pendelton");
        cities.add("Pierre");
        cities.add("Pueblo");
        cities.add("Phoenix");
        cities.add("Peoria");
        cities.add("Pittsburgh");
        cities.add("Princeton");
        cities.add("Pensacola");

        for (String c : cities) {
            System.out.println(c + " ");
        }

        ArrayList<Integer> distances = new ArrayList<>();
        distances.add(2);
        distances.add(8);
        distances.add(4);
        distances.add(3);
        distances.add(10);
        distances.add(5);
        for (int d : distances) {
            System.out.println(d + " , ");
        }

        /*
           Then print shortest distance to all other cities
         */

        /*
             For outputting the shortestKnownDistance could have used an enhanced for loop
             to get the keys and values in the map
         */

//        for(Map.Entry<String, Integer> entry: shortestKnownDistance.entrySet()){
//        }
        System.out.println(shortestKnownDistance);
    }
}
