public class Point {
    
    public int row;
    public int col;
    public char type;
    public int distance;
    public boolean visited;

    public Point(int row, int col, boolean visited, int distance, char type) {
        this.row = row;
        this.col = col;
        this.visited = visited;
        this.distance = distance;
        this.type = type;
    }

    public boolean isWalkable() {
        if(this.type == 'X' || this.type == '#' || this.type == 'S' || this.type == '▦'){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isExit() {
        if(this.type == 'E'){
            return true;
        }
        else{
            return false;
        }
    }
}
