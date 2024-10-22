public class traversalDriver {
    public static void main(String[] args) {
        generateMaze gm = new generateMaze();
        char[][] maze = gm.createMaze(30,30);
        printArray(maze);
    }

    public static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
