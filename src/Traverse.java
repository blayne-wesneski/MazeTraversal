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

    public void breadthFirst(Point[][] maze, int startRow, int startCol) {
        // Directions
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Create a queue
        Queue<Point> queue = new LinkedList<>();

        // Add the starting point to the queue
        queue.add(new Point(startRow, startCol, true, 0, maze[startRow][startCol].type));

        Scanner scanner = new Scanner(System.in);
        while (!queue.isEmpty()) {

            Point curr = queue.poll();

            for (int i = 0; i < directions.length; i++) {

                int nextRow = curr.row + directions[i][0];
                int nextCol = curr.col + directions[i][1];

                if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length) {
                    Point next = new Point(nextRow, nextCol, false, curr.distance + 1,
                            maze[curr.row + directions[i][0]][curr.col + directions[i][1]].type);
                    if (next.isExit()) {
                        System.out.println("Exit is at row: " + next.row + " col: " + next.col);
                        scanner.close();
                        return;
                    }
                    if (next.isWalkable() && !next.visited) {
                        System.out.println("Visiting row: " + next.row + " col: " + next.col);
                        queue.add(next);
                        maze[next.row][next.col].type = '▦';
                        ArrayOperations.printArrayPoint(maze);
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
