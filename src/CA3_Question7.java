import java.util.*;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */
public class CA3_Question7 {
    /*
        Multi-Company Stock sharex tax calculation (Queue)

        HINT: have a map Map<String, Queue<Block>> that manages a separate queue for each stock symbol
        so need the queue from the previous question, and then using a map also
     */

    public static class Block {
        //quantity is number of shares
        private int qty;
        private double price;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        private String symbol;

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
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {
        //Key is String
        //Values is queue block
        Map<String, Queue<Block>> map = new HashMap<>();
        double totalGain = 0.0;

        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if (command.equalsIgnoreCase("buy")) {
                String symbol = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();
                Block b = new Block(qty, price);

                //if the map does not contain the symbol
                //then put symbol into the map and create new block queue -  for each stock symbol
                if (!map.containsKey(symbol)) {
                    map.put(symbol, new LinkedList<Block>());
                }
                //add b to be associated with symbol in the map
                map.get(symbol).add(b);
            } else if (command.equals("sell")) {
                String symbol = in.next();
                int qty = in.nextInt();

            //check if the symbol is in the map - then get the symbol from the map
                if (map.containsKey(symbol)) {
                    Queue<Block> queue = map.get(symbol);

                    if (qty > 0 && !queue.isEmpty()) {
                        //get first element of the queue - make equal to b
                        Block b = queue.peek();

                        //Calculate the sellQuantity by taking the users input quantity away from quantity of block b
                        int sellQty = b.getQuantity() - qty;
                        totalGain = sellQty * b.getPrice();

                        //then update the quantity of shares in block b
                        b.setQuantity(b.getQuantity() - sellQty);

                        //remove from the queue
                        queue.poll();
                    }
                    //Output the gain
                    System.out.println("Gain: " + totalGain);
                }else{
                    System.out.println("Symbol not found.");
                }
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}
