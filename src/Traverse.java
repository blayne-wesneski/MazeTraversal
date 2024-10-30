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

    // I don't know what the fuck I am doing.
    public void breadthFirst(char[][] maze, int startRow, int startCol) {

        // Storing movement directions in a 2D array.
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // creating a queue to store the points.
        Queue<Point> queue = new LinkedList<>();

        // add the starting node to the "back" of the queue.
        queue.add(new Point(startRow, startCol, true, 0));

        // debug scanner, will be removed later.
        Scanner test = new Scanner(System.in);

        // while the queue isn't empty, keep searching.
        while (!queue.isEmpty()) {
            // grab the current point
            Point curr = queue.poll();

            // check all 4 directions from the current point one by one.
            for (int i = 0; i < 4; i++) {
                int newRow = curr.row + directions[i][0];
                int newCol = curr.col + directions[i][1];

                // This feels like a disaster, I should probably use another Array to track points
                if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length) {
                    if (maze[newRow][newCol] == 'E') {
                        System.out.println("Exit found at " + newRow + " " + newCol);
                        test.close();
                        return;
                    }
                    if (maze[newRow][newCol] == ' ') {
                        maze[newRow][newCol] = '▦';
                        queue.add(new Point(newRow, newCol, true, curr.distance + 1));
                        ArrayOperations.printArrayChar(maze);
                        test.nextLine();
                    }
                }
            }
        }
        test.close();
    }

    public void depthFirst() {

    }

    public void floodFill() {

    }

}
