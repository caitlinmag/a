import java.security.KeyPair;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question2 {
    /*
    - Empty pixels will be given colour
    - Stop when reach occupied pixel
    - Get the starting row & column - starting cell
    - push (row,column)pair on to stack
    - Make simple pair class storing the row & column DONE

    - While loop for if stack is not empty
    do these until stack is empty :
    - POP off (row,column)pair from top of stack -
    if the element is the top then pop it off
    - not filled then - fill the corresponding cell with a number
    the number is added on at each step to show order of fill - maybe use a count
    - PUSH coordinates(row,column)pair of unfilled neighbours(still 0) in north,east,south & west directions on the stack
     north - one row up
     east - one column to right
     south - one row down
     west - one column to left
     -> idea is to keep checking if neighbours are 0 until there is no values of 0 in the 2d array

    - stack is empty then print the entire 2D array
     */

    //Simple pair class - to store row and column
    public static class pair {
        private int c;
        private int r;

        public int getC() {
            return c;
        }

        public int getR() {
            return r;
        }

        public void setC(int c) {
            this.c = c;
        }

        public void setR(int r) {
            this.r = r;
        }

        public pair(int c, int r) {
            this.c = c;
            this.r = r;
        }
    }

    /*
        Starter function to create the 2D array and populate it with 0
     */
    public static int[][] floodFillStart() {
        Scanner kb = new Scanner(System.in);

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
        int fillOrder = 0;

        //create stack to hold row and column pairs
        Stack<pair> fillStack = new Stack<pair>();

        //push the row & column to the stack as a pair
        fillStack.push(new pair(c, r));

        //keep track of what cell it is on (row,column)
        //While the stack is not empty
        while (!fillStack.isEmpty()) {
            // pop off (r,c) from top
            fillStack.pop();

            //iterate through the array, checking the rows and columns
            for (r = 1; r < arr.length; r++) {
                for (c = 1; c < arr[0].length; c++) {
                    //check if the coordinates are 0
                    if (arr[c][r] == 0) {
                        //increment fill for each coordinate
                        arr[c][r] = fillOrder++;

                        //check neighbour coordinates and fill to the next fillOrder number
                        //north - one row up
                        if (r - 1 >= 0 && arr[c][r - 1] == 0) {
                            //push coordinates on to stack
                            fillStack.push(new pair(c, r - 1));
                            //then change the array from 0,0 to next fillCell number
                            arr[c][r - 1] = fillOrder++;
                        }
                        //east - one column to right
                        if (c + 1 < arr.length && arr[c + 1][r] == 0) {
                            fillStack.push(new pair(c + 1, r));
                            arr[c + 1][r] = fillOrder++;
                        }
                        //south - one row down
                        if (r + 1 < arr.length && arr[c][r + 1] == 0) {
                            fillStack.push(new pair(c, r + 1));
                            arr[c][r + 1] = fillOrder++;
                        }
                        //west - one column to the left
                        if (c - 1 >= 0 && arr[c - 1][r] == 0) {
                            fillStack.push(new pair(c - 1, r));
                            arr[c - 1][r] = fillOrder++;
                        }
                    }
                }
            }
        }
    }


    public static void start() {
//        //Prompt for starting row and column - starting cell for the flood fill
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter starting column:");
        int c = kb.nextInt();

        System.out.println("Enter starting row:");
        int r = kb.nextInt();

        int[][] arr = floodFillStart();
        fill(c, r, arr);
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }

}
