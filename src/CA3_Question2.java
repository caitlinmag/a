import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */
public class CA3_Question2 {
    //Simple pair class - to store row and column
    public static class pair {
        private int r;
        private int c;

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public void setR(int r) {
            this.r = r;
        }

        public void setC(int c) {
            this.c = c;
        }

        public pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    /*
        Starter function to create the 2D array and populate it with 0
     */
    public static int[][] floodFillStart() {

        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                arr[x][y] = 0;
            }
        }
        return arr;
    }
    /*
        Helper function to display the image
        10 x 10 array
     */

    public static void display(int[][] arr) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void fill(int r, int c, int[][] arr) {
        //fillOrder used to keep track of coordinates, incrementing the number for each coordinate
        int fillOrder = 1; //set to 1 otherwise 0 is included in the 2d array

        //create stack to hold row and column pairs
        Stack<pair> fillStack = new Stack<pair>();

        //push the row & column to the stack as a pair
        fillStack.push(new pair(r, c));

        //keep track of what cell it is on (row,column)
        //While the stack is not empty
        while (!fillStack.isEmpty()) {
//            fillStack.pop();

            // pop off currentCell from top
            pair currentCell = fillStack.pop();
            int i = currentCell.getR();
            int j = currentCell.getC();

            //check if the coordinates are 0
            if (arr[i][j] == 0) {
                //increment fill for each coordinate
                arr[i][j] = fillOrder++;

                //check neighbour coordinates and fill to the next fillOrder number
                //north - one row up
                if (i - 1 > 0 && arr[i - 1][c] == 0) {
                    //push coordinates on to stack
                    fillStack.push(new pair(i - 1, j));
                }
                //east - one column to the right
                //max is 10
                if (j + 1 < 10 && arr[i][j + 1] == 0) {
                    fillStack.push(new pair(i, j + 1));
                }
                //south - one row down
                if (i + 1 < 10 && arr[i + 1][j] == 0) {
                    fillStack.push(new pair(i + 1, j));
                }
                //west - one column to the left
                if (j - 1 > 0 && arr[i][j - 1] == 0) {
                    fillStack.push(new pair(i, j - 1));
                }
            }
        }
    }

    public static void start() {
        //Prompt for starting row and column - starting cell for the flood fill
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter starting row:");
        int r = kb.nextInt();

        System.out.println("Enter starting column:");
        int c = kb.nextInt();

        int[][] arr = floodFillStart();
        fill(r, c, arr);
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }

}
