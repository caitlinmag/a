import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class CA3_Question2 {
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

        Stack<Integer> fillStack = new Stack<Integer>();
//        fillStack.push(r,c);
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
        //Prompt for starting row and column - starting cell for the flood fill
        Scanner kb = new Scanner(System.in);
        int userRow;
        int userColumn;

        System.out.println("Enter starting row:");
        userRow = kb.nextInt();

        System.out.println("Enter starting column:");
        userColumn = kb.nextInt();

    }

    public static void start() {
        int[][] arr = floodFillStart();
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }

}
