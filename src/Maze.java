import java.util.Random;

public class Maze {

    private int startRow, startCol;

    /**
     * Create a maze given length and width.
     * 
     * @param length Integer value for the length of the maze to generate
     * @param width  Integer value for the width of the maze to generate
     * @return char[][] A 2D array representing the maze
     */
    public Point[][] createMaze(int length, int width) {

        Point[][] maze = new Point[length][width];

        /*
         * Wall = #
         * Obstacle = X
         * Start = S
         * End = E
         */

        // Create walls for the maze
        for (int i = 0; i < length; i++){
            maze[i][0] = new Point(i, 0, false, 0, '#', null);
            maze[i][width - 1] = new Point(i, width - 1, false, 0, '#', null);
        }
        for (int j = 0; j < width; j++){
            maze[0][j] = new Point(0, j, false, 0, '#', null);
            maze[length - 1][j] = new Point(length - 1, j, false, 0, '#', null);
        }

        // Fill maze with empty space
        for (int i = 1; i < maze.length - 1; i++){
            for (int j = 1; j < maze[i].length - 1; j++) {
                maze[i][j] = new Point(i, j, false, 0, ' ', null);
            }
        }

        // Set the start and end points of the maze

        Random rand = new Random();

        startRow = rand.nextInt(maze.length - 2) + 1;
        startCol = rand.nextInt(maze[0].length - 2) + 1;

        int endRow = rand.nextInt(maze.length - 2) + 1;
        int endCol = rand.nextInt(maze[0].length - 2) + 1;
        
        maze[startRow][startCol] = new Point(startRow, startCol, false, 0, 'S' , null);
        maze[endRow][endCol] = new Point(endRow, endCol, false, 0, 'E',null);

        // Generate the obstacles in the maze randomly
        for (int i = 1; i < maze.length - 1; i++) {
            for (int j = 1; j < maze[i].length; j++) {
                if(Math.random() < 0.3 && maze[i][j].type == ' '){
                    maze[i][j] = new Point(i, j, false, 0, 'X', null);
                }
            }
        }

        return maze;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }
}
