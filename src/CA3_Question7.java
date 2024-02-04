import java.util.*;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question7 {
    /* What do i need to do?
    extend question 6
    program that can handle shares of multiple companies
    user enters commands buy symbol quantity price, sell symbol quantity

    HINT: have a map Map<String, Queue<Block>> that manages a separate queue for each stock symbol
    so need the queue from the previous question, and then using a map also
     */

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
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {
        Queue<Block> queue = new LinkedList<Block>();

        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to buy shares here
            } else if (command.equals("sell")) {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                // Code to sell shares and calculate profit here
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}
