public class Point {
    
    public int row;
    public int col;
    public int distance;

    public Point(int row, int col, boolean visited, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
