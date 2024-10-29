import java.util.Random;
public class Maze {

    private int randomStartX, randomStartY;

    /**
     * Create a maze given length and width.
     * 
     * @param length Integer value for the length of the maze to generate
     * @param width  Integer value for the width of the maze to generate
     * @return char[][] A 2D array representing the maze
     */
    public char[][] createMaze(int length, int width) {

        char[][] maze = new char[length][width];

        /*
         * Visualising this hurts my brain.
         * I have it working, and fingers crossed there isn't a bug.
         *
         * 
         * 
         * Wall = #
         * Obstacle = X
         * Start = S
         * End = E
         */

        // Create walls for the maze
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = '#';
            maze[i][maze.length - 1] = '#';
            maze[0][i] = '#';
            maze[maze.length - 1][i] = '#';
        }

        // Fill maze with empty space
        for (int i = 1; i < maze.length - 1; i++) {
            for (int j = 1; j < maze[i].length - 1; j++) {
                maze[i][j] = ' ';
            }
        }

        // Set the start and end points of the maze

        Random rand = new Random();


        randomStartX = rand.nextInt(maze.length - 2) + 1;
        randomStartY = rand.nextInt(maze[0].length - 2) + 1;

        int randomEndX = rand.nextInt(maze.length - 2) + 1;
        int randomEndY = rand.nextInt(maze[0].length - 2) + 1;

        maze[randomStartY][randomStartX] = 'S';
        maze[randomEndY][randomEndX] = 'E';

        // Generate the obstacles in the maze randomly
        for (int i = 1; i < maze.length - 1; i++) {
            for (int j = 1; j < maze[i].length - 1; j++) {
                if (Math.random() < 0.3 && maze[i][j] == ' ') {
                    maze[i][j] = 'X';
                }
            }
        }

        return maze;
    }

    public int getStartPointX() {
        return randomStartX;
    }

    public int getStartPointY() {
        return randomStartY;
    }
}
