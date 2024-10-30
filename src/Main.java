public class Main {
    public static void main(String[] args) {
        Maze gm = new Maze();
        Traverse traverse = new Traverse();
        
        char[][] maze = gm.createMaze(30, 30);
        int startRow = gm.getStartRow();
        int startCol = gm.getStartCol();

        //copying of maze for all algorithms
        char[][] maze1 = new char[maze.length][];
        char[][] maze2 = new char[maze.length][];

        for (int i = 0; i < maze.length; i++) {
            maze1[i] = ArrayOperations.copyArray(maze[i]);
            maze2[i] = ArrayOperations.copyArray(maze[i]);
        }
        
        ArrayOperations.printArrayChar(maze);

        traverse.breadthFirst(maze, startRow, startCol);

        System.out.println("complete");
    }

}
