public class Point {
    
    public int row;
    public int col;
    public char type;
    public int distance;
    public boolean visited;
    public Point parent;

    public Point(int row, int col, boolean visited, int distance, char type, Point parent) {
        this.row = row;
        this.col = col;
        this.visited = visited;
        this.distance = distance;
        this.type = type;
        this.parent = parent;
    }

    public boolean isWalkable() {
        if(this.type == 'X' || this.type == '#' || this.type == 'S' || this.visited){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isEnd() {
        if(this.type == 'E'){
            return true;
        }
        else{
            return false;
        }
    }
}
