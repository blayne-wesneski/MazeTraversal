import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traverse {

    public void breadthFirst() {
        Maze maze = new Maze();

        Queue<Point> Q = new LinkedList<>();
        Q.enqueue(new Point(maze.getStartRow(), maze.getStartCol(), true, 0));

    }

    public void depthFirst() {

    }

    public void floodFill(){

    }





    /* QUEUE FUNCTIONS */
    public void enqueue(Point p) {
        // Add to the end of the queue
    }

}
