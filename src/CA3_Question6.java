
import java.util.LinkedList;
import java.util.PriorityQueue;
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
    buy another 100 at $10 per share
    sell 150 shares at $15

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
        private int qty;
        private double price;

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

        public double getCost() {
            return price * qty;
        }

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
//        PriorityQueue<Block> queue = new PriorityQueue<>();
        Queue<Block> queue = new LinkedList<Block>();
        double gain = 0.0;
        double firstBatchGain = 0.0;

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

                //There are blocks in the queue AND there is more than 0 in the sell quantity  - shares can be sold
                if (sellQty > 0 && !queue.isEmpty()) {
                    Block b = queue.peek();
                    /*
                        To calculate selling first batch:
                        block quantity is greater than or equal to sell quantity
                        get the total = amount of shares being sold multiplied by the selling price
                        get the gain = total subtract the original share price multiplied by quantity
                        update the quantity after share sold

                        calculate the quantity of shares that are left, after share is sold
                        output the share amount and the gain associated with the share
                     */
                    if (b.getQuantity() >= sellQty) {
                      double total = sellQty * sellPrice;
                        //15, 12 , 100
                        firstBatchGain = total - b.getCost();
                        System.out.println("Share: " + sellQty +  " Gain: " + firstBatchGain);
                        /*
                           To calculate selling second batch:
                           get the gain calculated from the second batch
                           add the first batch gain to the second batch to get the total profit
                           update the quantity of shares that are left, after shares sold
                           output the gain
                        */
                        queue.poll();
                    } else {
                       double total = sellQty * sellPrice;
                        gain = total - b.getCost();
                        double totalProfit = firstBatchGain + gain;

                        //buy 100 @ 12
                        //buy 100 @ 10
                        //sell 150 @ 15

//                      gain = (sellPrice - b.getPrice()) * sellQty;
//                        b.setQuantity(b.getQuantity() - sellQty);
//                        queue.add(b);
                        System.out.println("Gain: " + totalProfit);
                    }
                }
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}