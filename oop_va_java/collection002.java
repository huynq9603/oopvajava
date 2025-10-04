import java.util.*;
class Warehouse{
	HashMap<String,Integer> PriceMap;
	HashMap<String, Integer> StockMap;
	public Warehouse(){
		this.PriceMap = new HashMap<>();
		this.StockMap = new HashMap<>();
	}	
	public void addProduct(String product, int price, int stock){
		PriceMap.put(product, price);
		StockMap.put(product, stock);
	}
	public int price(String product){
		return PriceMap.getOrDefault(product,-99);
	}
	public int stock(String product){
		return StockMap.getOrDefault(product,0);
	}
	public boolean take(String product){
		if(StockMap.containsKey(product)&&StockMap.get(product) > 0){
			StockMap.put(product, StockMap.get(product) - 1);
			return true;
		}
		else return false;
	}
	public String toString(String product){
		return "taking " + product + " "+take(product);
	}
}
public class collection002{
	public static void main(String args[]){
		Warehouse warehouse = new Warehouse();
		warehouse.addProduct("coffee", 5, 1);
		System.out.println("stock:");
		System.out.println("coffee:  " + warehouse.stock("coffee"));
		System.out.println("sugar: " + warehouse.stock("sugar"));
		System.out.println(warehouse.toString("coffee"));
		System.out.println(warehouse.toString("coffee"));
        System.out.println(warehouse.toString("sugar"));
		System.out.println("stock:");
		System.out.println("coffee:  " + warehouse.stock("coffee"));
		System.out.println("sugar: " + warehouse.stock("sugar"));
	}
}