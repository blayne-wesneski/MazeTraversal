import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Maze gm = new Maze();
        Traverse traverse = new Traverse();
        
        Point[][] maze = gm.createMaze(10, 10);
        int startRow = gm.getStartRow();
        int startCol = gm.getStartCol();

        ArrayOperations.printArrayPoint(maze);

        //copying of maze for all algorithms
        Point[][] maze1 = new Point[maze.length][];
        Point[][] maze2 = new Point[maze.length][];

        for (int i = 0; i < maze.length; i++) {
            maze1[i] = ArrayOperations.copyArray(maze[i]);
            maze2[i] = ArrayOperations.copyArray(maze[i]);
        }
        
        ArrayOperations.printArrayPoint(maze);

        traverse.breadthFirst(maze, startRow, startCol);

        System.out.println("complete");

    }

}
