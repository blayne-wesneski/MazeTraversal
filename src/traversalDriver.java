public class traversalDriver {
    public static void main(String[] args) {
        maze gm = new maze();
        char[][] maze = gm.createMaze(10, 10);

        //copying of maze for all algorithms
        char[][] maze1 = new char[maze.length][];
        char[][] maze2 = new char[maze.length][];

        for (int i = 0; i < maze.length; i++) {
            maze1[i] = copyArray(maze[i]);
            maze2[i] = copyArray(maze[i]);
        }
        
        printArray(maze);

        // for passing to the traversal class later
        @SuppressWarnings("unused")
        int startX = gm.getStartPointX();
        @SuppressWarnings("unused")
        int startY = gm.getStartPointY();
    }

    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[] copyArray(char[] array) {

        char[] new_array = new char[array.length];

        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[i];
        }

        return new_array;
    }
}
