import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Caitlin Maguire
 * Class Group: SD2B
 */

/*
    Backtracking through a Maze (Stack)
    Stack is LIFO last in first out
 */

class path {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public path(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH, EAST, WEST};

public class CA3_Question9 {
    public static int[][] startMaze() {
        int[][] image = new int[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                image[x][y] = 0;
            }
        }
        return image;
    }

    public static void display(int[][] image) {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    /*
        Implement a backtracking algorithim to find a path through a maze from start to exit

     */
    public static void solve(int x, int y, DIRECTION dir, int[][] image) {
        //create stack to hold the points x,y
        Stack<path> backtrackingStack = new Stack<>();
        int visited = 1;
        //push x and y as points on to stack
        backtrackingStack.push(new path(x, y));

        //While the Stack is not empty
        while (!backtrackingStack.isEmpty()) {
            //Pop path from stack
            path currentPath = backtrackingStack.pop();
            int i = currentPath.getX();
            int j = currentPath.getY();

            /*  Follow path until you reach an exit, intersection or dead end
                Checking directions of paths that have been visited in the maze
                If the path has been visited then push 1 to the stack to be displayed
                Using a switch statement to check which enum direction has been entered
             */
            while (image[i][j] == 0) {
                //change path to visited
                image[i][j] = visited;

                switch (dir) {
                    case NORTH:
                        //one row up
                        if (i > 0 && image[i - 1][j] == 0) {
                            //push the path points on to stack
                            backtrackingStack.push(new path(i - 1, j));
                        }
                        break;
                    case EAST:
                        //one column to the right
                        if (j + 1 < 10 && image[i][j + 1] == 0) {
                            backtrackingStack.push(new path(i, j + 1));
                        }
                        break;
                    case SOUTH:
                        //one row down
                        if (i + 1 < 10 && image[i + 1][j] == 0) {
                            backtrackingStack.push(new path(i + 1, j));
                        }
                        break;
                    case WEST:
                        //one column to the left
                        if (j - 1 > 0 && image[i][j - 1] == 0) {
                            backtrackingStack.push(new path(i, j - 1));
                        }
                        break;
                }
            }

            /*
                If you found an exit
                Then print congratulations!
             */

            if (isExit(x, y)) {
                System.out.println("Congratulations!");
            }
            /*
                If an intersection is found
                Push all paths (which meet at the intersection) on to the stack
                Don't push the current path on to stack (use x,y instead of i,j)
             */
            else if (isIntersection(x, y)) {
                backtrackingStack.push(new path(x, y));
            } else if (isDeadEnd(x,y)) {
                System.out.println("You have reached a dead end.");
            }
        }
    }

    /*
        Method to check if you have found an exit
        Exit would be the boundaries of the maze
        10 by 10 array so 10 is the max value
     */
    public static boolean isExit(int i, int j) {
        if (i + 1 < 10 || j + 1 < 10) {
            return true;
        } else {
            return false;
        }
    }

    /*
        Method to check if you found an intersection
        Intersection if i or j is 1, this means the path has already been visited
     */
    public static boolean isIntersection(int i, int j) {
        if (i == 1 || j == 1) {
            return true;
        } else {
            return false;
        }
    }

    /*
        Method to check if you found a dead end
        Deadend is if i and j is 0,0
     */
    public static boolean isDeadEnd(int i, int j) {
        if (i == 0 && j == 0) {
            return true;
        }else{
            return false;
        }
    }

    public static void start() {
        //Prompt for starting points - starting cell for the flood fill
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter starting point 1:");
        int x = kb.nextInt();

        System.out.println("Enter starting point 2:");
        int y = kb.nextInt();

        System.out.println("Enter direction (NORTH, EAST,SOUTH or WEST)");
        String direction = kb.next();

        int[][] image = startMaze();
        solve(x, y, DIRECTION.valueOf(direction), image);
        display(image);
    }

    public static void main(String[] args) {
        start();
    }
}
