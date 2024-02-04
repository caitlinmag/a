
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
    public static class Block {
        //quantity is number of shares
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

        //price per share
        private double price;

        public Block(int qty, double price) {
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
        //Use share class

        /*
        keep track of order of shares being bought
        FIFO for calculations
         */
        //Block queue of objects
        Queue<Block> queue = new LinkedList<Block>();

        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            //BUY - add to the queue
            if (command.equalsIgnoreCase("buy")) {
                int qty = in.nextInt();
                double price = in.nextDouble();
                Block b = new Block(qty, price);
                queue.add(b);
                //SELL - calculate the gain
            } else if (command.equals("sell")) {
                int sellQty = in.nextInt();
                double sellPrice = in.nextDouble();
                double gain = 0.0;
                Block b = new Block(sellQty, sellPrice);
                queue.add(b);

                //There are blocks in the queue AND there is more than 0 in the sell quantity  - shares can be sold
                while (!queue.isEmpty() && sellQty > 0) {
                    //delete from the queue
                    queue.poll();
//                    double profit = 0.0;
                    /*
                        To calculate one share:
                        block quantity is less than or equal to sell quantity
                        to get the gain = selling price subtract the block price multiplied by the original quantity
                        update available share quantity iterating through the while loop
                        calculate the quantity of shares that are left, after share is sold
                        output the share amount and the gain associated with the share
                     */
                    if (b.getQuantity() <= sellQty) {
                        gain = (sellPrice - b.getPrice()) * b.getQuantity();
                        sellQty -= b.getQuantity();
                        System.out.println( "Gain " + gain);

                        /*
                           To calculate multiple shares:
                           block quantity is greater than or equal to the sell quantity
                           profit is equal to the gain
                           output the shares amount and the gain associated with the shares
                         */
                    } else {
                        gain = (sellPrice - b.getPrice()) * sellQty;
                        //update the quantity after shares sold
                        b.setQuantity(b.getQuantity() - sellQty);
                        queue.add(b);
                        //set back to 0 again
                        System.out.println("Gain: " + gain);
                    }
                }

            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}