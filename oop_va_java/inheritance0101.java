import java.util.*;
abstract class Product{
    private String name;
    private double price;
    private int quantity;
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity =quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public abstract double calculateCost(int quantity);
    public String displayDetails(){
        return "Name: " + name + "\n" + "Price: $" + price + "\n" + "Available Quantity: " + quantity;
    }
}
class Book extends Product{
    private String author;
    public Book(String name, double price, int quantity, String author){
        super(name,price,quantity);
        this.author = author;
    }
    @Override
    public double calculateCost(int quantity){
        return super.getPrice() * quantity;
    }
    @Override
    public String displayDetails(){
        return super.displayDetails() + "\nAuthor: " + author;
    }
}
class Electronics extends Product{
    private String brand;
    public Electronics(String name,double price, int quantity, String brand){
        super(name,price,quantity);
        this.brand = brand;
    }
    @Override
    public double calculateCost(int quantity){
        return super.getPrice() * quantity * 1.1;
    }
    @Override
    public String displayDetails(){
        return super.displayDetails() + "\nBrand: " + brand; 
    }
}
class User{
    private String userName;
    private double totalSpent;
    public User(String userName){
        this.userName = userName;
        this.totalSpent = 0;
    }
    public String getName(){
        return userName;
    }
    public double getTotalSpent(){
        return totalSpent;
    }
    public void buyProduct(Product product, int quantity){
        int quantity1 = product.getQuantity();
        if(quantity1 > quantity){
            double spent = product.calculateCost(quantity);
            totalSpent += spent;
            product.setQuantity(quantity1 - quantity);
            System.out.println("User: " + userName + " bought " + quantity + " " + product.getName() + " for " + "$" + spent);
        }
        else{
            System.out.println("Insufficient quantity of " + product.getName() + " available.");
        }
    }
}
public class inheritance0101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Product> p = new ArrayList<>();
        p.add(new Electronics("laptop", 20, 10, "Dell"));
        p.add(new Book("Harry Potter", 10, 12, "camnh"));
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));
        users.get(0).buyProduct(p.get(0),3);
        users.get(0).buyProduct(p.get(1), 10);
        users.get(1).buyProduct(p.get(0), 1);
        users.get(2).buyProduct((p.get(1)), 5);
        System.out.println("====");
        System.out.println("Users with Highest Total Spent:");
        int dem = 1;
        for(User user : users){
            System.out.println(dem + ". " + user.getName() + ": $" + user.getTotalSpent());
            dem++;
        }
        System.out.println("====");
        System.out.println(p.get(0).displayDetails());
        System.out.println("---");
        System.out.println(p.get(1).displayDetails());
    }
}
