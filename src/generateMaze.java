public class generateMaze {

    // @TODO: Allow user to specify the size of the maze.
    char[][] maze = new char[10][10];

    /*
     * Main method for testing only, will be moved to a tester class later.
     */
    public static void main(String[] args) {
        generateMaze gm = new generateMaze();
        gm.createMaze();
        printArray(gm.maze);
    }

    /*
     * This is debug code, will be moved into a tester class later.
     */
    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] createMaze() {

        /*
         * Visualising this hurts my brain.
         * I have it working, and fingers crossed there isn't a bug.
         */

        /*
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
