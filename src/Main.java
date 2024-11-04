import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Maze gm = new Maze();
        Traverse traverse = new Traverse();
        
        System.out.print("Please enter the length of the maze: ");
        int length = scanner.nextInt();
        System.out.print("Please enter the width of the maze: ");
        int width = scanner.nextInt();

        Point[][] maze = gm.createMaze(length, width);
        int startRow = gm.getStartRow();
        int startCol = gm.getStartCol();

        System.out.println("Maze generated: ");
        ArrayOperations.printArrayPoint(maze);

        //copying of maze for all algorithms
        Point[][] maze1 = new Point[maze.length][];
        Point[][] maze2 = new Point[maze.length][];

        for (int i = 0; i < maze.length; i++) {
            maze1[i] = ArrayOperations.copyArray(maze[i]);
            maze2[i] = ArrayOperations.copyArray(maze[i]);
        }
        
        System.out.println("Select algorithm to run:");
        System.out.println("1. Depth First Search");
        System.out.println("2. Breadth First Search");
        System.out.println("3. Flood Fill");
        System.out.println("4. All");

        int algo = scanner.nextInt();

        switch (algo) {
            case 1:
                traverse.depthFirst(maze1, startRow, startCol);
                break;
        
            case 2:
                traverse.breadthFirst(maze2, startRow, startCol);
                break;
            
            case 3:
                traverse.floodFill();
                break;

            case 4:
                traverse.depthFirst(maze1, startRow, startCol);
                traverse.breadthFirst(maze2, startRow, startCol);
                traverse.floodFill();
                break;
            
            default:
                System.out.println("Invalid input");
                break;
        }

        System.out.println("complete");

        scanner.close();
    }

}
