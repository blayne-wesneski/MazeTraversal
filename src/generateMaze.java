
public class generateMaze {

    /**
     * Create a maze given length and width. 
     * @param length Integer value for the length of the maze to generate
     * @param width Integer value for the width of the maze to generate
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
         */

        // Create walls for the maze
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = '#';
            maze[i][maze.length - 1] = '#';
            maze[0][i] = '#';
            maze[maze.length - 1][i] = '#';
        }

        // Generate the obstacles in the maze randomly
        for (int i = 1; i < maze.length - 1; i++) {
            for (int j = 1; j < maze[i].length - 1; j++) {
                if (Math.random() < 0.3) {
                    maze[i][j] = 'X';
                }
            }
        }

        // Fill remaining cells with empty space
        for (int i = 1; i < maze.length - 1; i++) {
            for (int j = 1; j < maze[i].length - 1; j++) {
                if (maze[i][j] != 'X') {
                    maze[i][j] = ' ';
                }
            }
        }

        return maze;
    }
}
