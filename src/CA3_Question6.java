
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question6 {
    /*
    Stock shares tax calculation (QUEUE)
    Buy 100 shares of stock at $12 per share
    another 100 at $10 per share
    then sell 150 shares at $15
    taxes have to be paid on the gain

    FIFO IS first in, first out
    FIFO rule: first sell all shares of first batch profit = 300
    then 50 for second batch profit = 250
    then total profit is 550

    write program to make these calculations for arbitrary purchases & sales of shares in a
    SINGLE COMPANY
    User enters commands: buy quantity price, sell quantity (display the gain), quit

    HINT: keep a queue of objects of a class Block that contains quantity and price
    of block of shares
     */

    /*
        create block class
     */

    //Block class that contains quantity and price of block of shares
    public static class block {
        private int qty;

        public int getQuantity() {
            return qty;
        }

        public void setQuantity(int qty) {
            this.qty = qty;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        private double price;

        public block(int qty, double price) {
            this.qty = qty;
            this.price = price;
        }
    }

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

//Make a queue
        Queue<Integer> q = new LinkedList<Integer>();

        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                int qty = in.nextInt();
                double price = in.nextDouble();

            } else if (command.equals("sell")) {
                int qty = in.nextInt();
                double price = in.nextDouble();


            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}