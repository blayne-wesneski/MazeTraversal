public class traversalDriver {
    public static void main(String[] args) {
        generateMaze gm = new generateMaze();
        gm.createMaze();
        printArray(gm.maze);
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
