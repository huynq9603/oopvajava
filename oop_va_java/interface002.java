import java.util.*;
interface Movable{
    void move(int dx, int dy);
}
class Organism implements Movable{
    private int x;
    private int y;
    public Organism(int x, int y){
        this.x = x;
        this. y = y;
    }
    @Override
    public void move(int dx, int dy){
        this.x+=dx;
        this.y += dy;
    }
    @Override
    public String toString(){
        return "x:" + x + ";y:" + y; 
    }
}
class Herd{
    private ArrayList<Movable> list;
    public Herd(){
        this.list = new ArrayList<>();
    }
    public void addToHerd(Movable movable){
        list.add(movable);
    }
    public void move(int dx, int dy){
        for(Movable movable : list){
            movable.move(dx, dy);
        }   
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(Movable movable : list){
            sb.append(movable.toString()).append("\n");
        }
        return sb.toString();
    }
}
public class interface002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        Herd herd = new Herd();
        while(t-- >0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Organism o = new Organism(x, y);
            herd.addToHerd(o);
        }
        herd.move(1, 1);
        System.out.println(herd);
    }
}
