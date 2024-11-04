import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Maze gm = new Maze();
        Traverse traverse = new Traverse();

        int length, width;

        // Get user input for maze size
        // If user input is invalid, use default size of 10
        System.out.print("Please enter the length of the maze: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input, using defualt of 10.");
            length = 10;
        } else {
            length = scanner.nextInt();
        }

        if (length < 5) {
            System.out.println("Maze length must be 5 or greater, using default of 10.");
            length = 10;
        }

        System.out.print("Please enter the width of the maze: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input, using default of 10.");
            width = 10;
        }else {
            width = scanner.nextInt();
        }

        if (width < 5) {
            System.out.println("Maze length must be 5 or greater, using default of 10.");
            width = 10;
        }

        Point[][] maze = gm.createMaze(length, width);
        int startRow = gm.getStartRow();
        int startCol = gm.getStartCol();

        System.out.println("Maze generated: ");
        ArrayOperations.printArrayPoint(maze);

        // copying of maze for both algorithms
        Point[][] maze1 = new Point[maze.length][maze[0].length];

        maze1 = ArrayOperations.copyArray(maze);

        System.out.println("Select algorithm to run:");
        System.out.println("1. Depth First Search");
        System.out.println("2. Breadth First Search");
        System.out.println("3. Both");

        int algo = scanner.nextInt();

        switch (algo) {
            case 1:
                traverse.depthFirst(maze, startRow, startCol, scanner);
                break;

            case 2:
                traverse.breadthFirst(maze1, startRow, startCol, scanner);
                break;

            case 3:
                traverse.depthFirst(maze, startRow, startCol, scanner);
                traverse.breadthFirst(maze1, startRow, startCol, scanner);
                break;

            default:
                System.out.println("Invalid input");
                break;
        }

        scanner.close();
    }

}
