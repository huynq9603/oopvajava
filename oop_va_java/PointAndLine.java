import java.util.*;
class Point{
    private double x;
    private double y;
    private double z;
    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z; 
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y && this.z == p.z;
    }
    public double disTanceTo(Point other){
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return Math.sqrt(dx*dx + dy * dy + dz * dz);
    }
}
class Line{
    private Point start;
    private Point end;
    private String name;
}