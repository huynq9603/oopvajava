import java.util.*;
abstract class Shape{
    protected String name;
    public Shape(String name){
        this.name = name;
    }
    public abstract double calculateArea();
    public void displayInfo() {
        System.out.printf("Shape:%s|Area:%.2f\n", name, calculateArea());
    }

}
class Rectangle extends Shape{
    private double length;
    private double width;
    public Rectangle(String name, double length, double width){
        super(name);
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea(){
        return length * width;
    }
}
class Circle extends Shape{
    private double radius;
    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] chuoi = sc.nextLine().split(" ");
            if(chuoi[0].equals("Rectangle")){
                Shape rectangle = new Rectangle(chuoi[0],Double.parseDouble(chuoi[1]),Double.parseDouble(chuoi[2]));
                rectangle.calculateArea();
                rectangle.displayInfo();
            }
            else{
                Shape circle = new Circle(chuoi[0],Double.parseDouble(chuoi[1]));
                circle.calculateArea();
                circle.displayInfo();
            }

        }
    }
}