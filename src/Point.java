public class Point {
    
    public int row;
    public int col;
    public int distance;
    public boolean visited;

    public Point(int row, int col, boolean visited, int distance) {
        this.row = row;
        this.col = col;
        this.visited = visited;
        this.distance = distance;
    }
}