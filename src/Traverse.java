import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    // I made this way too convoluted, and I had trouble keeping track of it all. So
    // I am completely rewriting it. I think I just didn't fully understand what I
    // was doing and I didn't plan it out well enough in the beginning.

    public void breadthFirst(char[][] maze, int startRow, int startCol) {
        // Scanner for testing
        Scanner scanner = new Scanner(System.in);

        // Directions
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Create a queue
        Queue<Point> queue = new LinkedList<>();

        // Add the starting point to the queue
        queue.add(new Point(startRow, startCol, true, 0));

        while (!queue.isEmpty()) {

            Point curr = queue.poll();
            Point next = new Point(curr.row, curr.col, false, curr.distance + 1);

            for (int i = 0; i < directions.length; i++) {
                if (next.row >= 0 && next.row < maze.length && next.col >= 0 && next.col < maze[0].length) {
                    if (next.visited == false && maze[next.row][next.col] == 'E') {
                        System.out.println("End point found at row: " + next.row + " col: " + next.col);
                        scanner.close();
                        return;
                    }
                    if (next.visited == false && maze[next.row][next.col] != 'X') {
                        curr = next;
                        curr.visited = true;
                        queue.add(curr);
                        next = new Point(curr.row + directions[i][0], curr.col + directions[i][1], false,
                                curr.distance + 1);
                        // This will print a character to the maze array to show the search
                        maze[next.row][next.col] = '▦';
                        ArrayOperations.printArrayChar(maze);
                        scanner.nextLine();
                    }
                }
            }
        }
        scanner.close();

    }

    public void depthFirst() {

    }

    public void floodFill() {

    }

}
