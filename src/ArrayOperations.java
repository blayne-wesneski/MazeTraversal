public class ArrayOperations {

    public static void printArrayPoint(Point[][] array) {
        /*
         * Code to clear the console copied from StackOverflow 11/4/2024
         * https://stackoverflow.com/a/32295974
         */
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j].type + " ");
            }
            System.out.println();
        }
    }

    // Code for debugging, will either be removed or commented out later
    public static void printArrayDist(Point[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j].distance + " ");
            }
            System.out.println();
        }
    }

    public static void printArrayInt(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Point[][] copyArray(Point[][] array) {

        Point[][] new_array = new Point[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                new_array[i][j] = new Point(array[i][j].row, array[i][j].col, array[i][j].visited, array[i][j].distance,
                        array[i][j].type, array[i][j].parent);
            }
        }

        return new_array;
    }

}
