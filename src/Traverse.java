import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        queue.add(maze[startRow][startCol]);

        Scanner scanner = new Scanner(System.in);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int i = 0; i < directions.length; i++) {

                int nextRow = curr.row + directions[i][0];
                int nextCol = curr.col + directions[i][1];

                if (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length) {
                    Point next = maze[nextRow][nextCol];
                    if (next.isEnd()) {
                        maze[nextRow][nextCol].distance = curr.distance + 1;
                        maze[nextRow][nextCol].parent = curr;
                        printFinalPath(next, maze);
                        System.out.println("End is at row: " + next.row + " col: " + next.col);
                        System.out.println("Distance from start: " + maze[nextRow][nextCol].distance);
                        scanner.close();
                        return;
                    }
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

    

    public void depthFirst() {

    }

    public void floodFill() {

    }

    private void printFinalPath(Point point, Point[][] maze){
        List<Point> path = new ArrayList<>();
        
        while(point.parent != null){
            path.add(point);
            point = point.parent;
        }
        Collections.reverse(path);
        for (Point point2 : path) {
            if(maze[point2.row][point2.col].type != 'E'){
                maze[point2.row][point2.col].type = '▢';
            }
            for (int i = 1; i < maze.length - 1; i++){
                for (int j = 1; j < maze.length - 1; j++) {
                    if(maze[i][j].type == '▦'){
                        maze[i][j].type = ' ';
                    }
                }
            }
            
        }
        ArrayOperations.printArrayPoint(maze);
    }

}
