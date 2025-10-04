import java.util.*;
interface Box{
    public void add(Item item);
    public boolean isInBox(Item item);
}
class Item{
    private String name;
    private int weight;
    public Item(String name,int weight){
        this.name = name;
        this.weight = weight;
    }
    public Item(String name){
        this.name = name;
    }
    public int getWeight(){
        return weight;
    }
    public String getName(){
        return name;
    }
}
class BoxWithMaxWeight implements Box{
    private ArrayList<Item> items;
    private int maxWeight;
    public BoxWithMaxWeight(int maxWeight){
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }
    @Override
    public void add(Item item){
        int totalWeight = 0;
        for(Item i : items){
            totalWeight += i.getWeight();
        }
        if(item.getWeight() + totalWeight <= maxWeight)
        items.add(item);
    }
    @Override
    public boolean isInBox(Item item){
        for(Item i : items){
            if(i.getName().equals(item.getName()))
                return true;
        }
        return false;
    }
}
public class caiHop{
    public static void main(String[] args) {
        Box box = new BoxWithMaxWeight(10);
        Item item1 = new Item("Saludo", 5);
        Item item2 = new Item("Pirkka", 5);
        Item item3 = new Item("Kopi Luwak", 5);
        box.add(item1);
        box.add(item2);
        box.add(item3);
        System.out.println(box.isInBox(item1));
        System.out.println(box.isInBox(item2));
        System.out.println(box.isInBox(item3));
    }
}