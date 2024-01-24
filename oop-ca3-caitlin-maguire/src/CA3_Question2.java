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

    //stack
    private static Stack<Integer> fillStack = new Stack<Integer>();

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
        //Prompt for starting row and column - starting cell for the flood fill
        Scanner kb = new Scanner(System.in);
        int userRow;
        int userColumn;
        int fill = 1;

        System.out.println("Enter starting row:");
        userRow = kb.nextInt();

        System.out.println("Enter starting column:");
        userColumn = kb.nextInt();

        fillStack.push(userRow);
        fillStack.push(userColumn);
        System.out.println(fillStack);

        //keep track of what cell it is on (row,column)
        int currentCell;
        //While the stack is not empty
        while (!fillStack.isEmpty()) {
            //check top element
//            if (fillStack.peek() == currentCell) {
                //pop off (r,c) from top
//                fillStack.pop(currentCell);
//            }

            //use the getters & setters to get the rows & columns

            //Check if rows & columns are 0 and then increment them to now have the next fill number
            if (r == 0 || c == 0) {
                //increment the fill value
                fill++;
            }
//            fillStack.push(currentCell);
        }

    }

    public static void start() {
        int[][] arr = floodFillStart();
        fill(0, 0, arr);
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }

}
