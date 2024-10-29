public class Point {
    
    public int row;
    public int col;
    public boolean visited;
    public int distance;

    public Point(int row, int col, boolean visited, int distance) {
        this.row = row;
        this.col = col;
        this.visited = visited;
        this.distance = distance;
    }
    
}
