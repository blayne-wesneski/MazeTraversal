import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Traverse {

    /*
     * This video by WilliamFiset helped alot with understanding BFS. I referenced
     * his pseudocode while writing my own implementation.
     * https://www.youtube.com/watch?v=KiCBXu4P-2Y
     * 
     * I also used this article from GeeksForGeeks as a reference while I was
     * figuring out the queue logic.
     * https://www.geeksforgeeks.org/queue-interface-java/
     */

    /**
     * Method to traverse a maze using a breadth first search.
     * 
     * @param maze     A 2D array representing the maze.
     * @param startRow The starting row of the maze.
     * @param startCol The starting column of the maze.
     */

    public void breadthFirst(Point[][] maze, int startRow, int startCol) {
        // Directions
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Create a queue
        Queue<Point> queue = new LinkedList<>();

        // Add the starting point to the queue
        queue.add(maze[startRow][startCol]);

        // Scanner for testing
        Scanner scanner = new Scanner(System.in);

        // While the queue isn't empty, keep searching
        // This does currently just end if it can't find the exit, probably should
        // implement a message for that.
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            // Search all 4 directions at every point
            for (int i = 0; i < directions.length; i++) {

                int nextRow = curr.row + directions[i][0];
                int nextCol = curr.col + directions[i][1];

                maze[curr.row][curr.col].visited = true;

                if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length) {
                    // Queue up next point
                    Point next = maze[nextRow][nextCol];

                    // If the point is the end, we are done, print it out.
                    if (next.isEnd()) {
                        maze[nextRow][nextCol].distance = curr.distance + 1;
                        maze[nextRow][nextCol].parent = curr;
                        printFinalPath(next, maze);
                        System.out.println("End is at row: " + next.row + " col: " + next.col);
                        System.out.println("Distance from start: " + maze[nextRow][nextCol].distance);
                        scanner.close();
                        return;
                    }

                    // if it isn't the end, check for walkability, if it isn't walkable, then ignore
                    // it.
                    if (next.isWalkable()) {
                        System.out.println("Visiting row: " + next.row + " col: " + next.col);
                        maze[next.row][next.col].type = '▦';
                        maze[next.row][next.col].visited = true;
                        maze[next.row][next.col].distance = curr.distance + 1;
                        maze[next.row][next.col].parent = curr;
                        queue.add(next);
                        ArrayOperations.printArrayPoint(maze);
                        // ArrayOperations.printArrayDist(maze);
                        // scanner.nextLine();
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * Method to traverse a maze using a depth first search.
     * 
     * @param maze     A 2D array representing the maze.
     * @param startRow The starting row of the maze.
     * @param startCol The starting column of the maze.
     */
    public void depthFirst(Point[][] maze, int startRow, int startCol) {

        // Create a stack
        Stack<Point> stack = new Stack<>();

        // Directions
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Push the starting point to the stack
        stack.push(maze[startRow][startCol]);

        // Scanner for testing
        Scanner scanner = new Scanner(System.in);

        // While the stack isn't empty, keep searching
        while (!stack.isEmpty()) {
            Point curr = stack.pop();

            if (curr.isWalkable()) {
                maze[curr.row][curr.col].visited = true;
                if (curr.type != 'S' && curr.type != 'E') {
                    maze[curr.row][curr.col].type = '▦';
                }

                // Check all 4 directions for next possible point
                for (int i = 0; i < directions.length; i++) {
                    int nextRow = curr.row + directions[i][0];
                    int nextCol = curr.col + directions[i][1];

                    // Check to make sure the point is in bounds
                    if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length) {
                        Point next = maze[nextRow][nextCol];

                        // If the point is the end, we are done, print it out.
                        if (next.isEnd()) {
                            maze[nextRow][nextCol].distance = curr.distance + 1;
                            maze[nextRow][nextCol].parent = curr;
                            printFinalPath(next, maze);
                            System.out.println("End is at row: " + next.row + " col: " + next.col);
                            System.out.println("Distance from start: " + maze[nextRow][nextCol].distance);
                            scanner.close();
                            return;
                        }
                        // If the point is walkable, update it and push it to the stack. If not, ignore
                        // it.
                        if (next.isWalkable()) {
                            maze[next.row][next.col].parent = curr;
                            maze[next.row][next.col].distance = curr.distance + 1;
                            stack.push(next);
                            ArrayOperations.printArrayPoint(maze);
                            scanner.nextLine();
                        }
                    }
                }
            }

        }
        scanner.close();
    }

    public void floodFill() {
        return;
    }

    /**
     * Backtracks through previous points to print final shortest path.
     * 
     * @param point end point found with search algorithm
     * @param maze  the maze array
     */
    private void printFinalPath(Point point, Point[][] maze) {

        // Create an arraylist to keep track of the previous points
        List<Point> path = new ArrayList<>();

        // While the point has a parent, keep going back
        while (point.parent != null) {
            path.add(point);
            point = point.parent;
        }

        Collections.reverse(path);

        // For each point in the path list, update the maze array
        for (Point point2 : path) {

            // Don't overwrite the 'E'
            if (maze[point2.row][point2.col].type != 'E') {
                maze[point2.row][point2.col].type = '▢';
            }

            // Cleanup code, just removes the search history ;-)
            for (int i = 1; i < maze.length - 1; i++) {
                for (int j = 1; j < maze.length - 1; j++) {
                    if (maze[i][j].type == '▦') {
                        maze[i][j].type = ' ';
                    }
                }
            }

        }
        ArrayOperations.printArrayPoint(maze);
    }

}
