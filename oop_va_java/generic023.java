import java.util.*;
import java.util.function.*;

interface Predicate<T> {
    boolean test(T t);
}

interface Function<T, R> {
    R apply(T t);
}

class Warehouse<T> {
    private List<T> items;

    public Warehouse(List<T> items) {
        this.items = items;
    }

    public Optional<T> findById(String id, Function<T, String> idExtractor) {
        for (T item : items) {
            if (idExtractor.apply(item).equals(id)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<T> sort(Comparator<T> comparator) {
        List<T> sorted = new ArrayList<>(items);
        sorted.sort(comparator);
        return sorted;
    }

    public Optional<T> max(Comparator<T> comparator) {
        if (items.isEmpty()) return Optional.empty();
        return Optional.of(java.util.Collections.max(items, comparator));
    }

    public Optional<T> min(Comparator<T> comparator) {
        if (items.isEmpty()) return Optional.empty();
        return Optional.of(java.util.Collections.min(items, comparator));
    }
}

class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.price);
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + "}";
    }
}

class Book extends Product {
    private String author;

    public Book(String id, String name, double price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{id='" + getId() + "', name='" + getName() + "', price=" + getPrice() + ", author='" + author + "'}";
    }
}

public class generic023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<Book> books = new ArrayList<>();
        Warehouse<Book> warehouse = new Warehouse<>(books);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("End")) break;

            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch (command) {
                case "AddBook": {
                    String id = tokens[1];
                    String name = tokens[2];
                    double price = Double.parseDouble(tokens[3]);
                    String author = tokens[4];
                    books.add(new Book(id, name, price, author));
                    break;
                }
                case "FindById": {
                    String id = tokens[1];
                    Optional<Book> found = warehouse.findById(id, Book::getId);
                    System.out.println(found.map(Object::toString).orElse("Not found"));
                    break;
                }
                case "FilterPriceAbove": {
                    double threshold = Double.parseDouble(tokens[1]);
                    List<Book> filtered = warehouse.filter(b -> b.getPrice() > threshold);
                    if (filtered.isEmpty()) System.out.println("Not found");
                    else filtered.forEach(System.out::println);
                    break;
                }
                case "SortByName": {
                    List<Book> sorted = warehouse.sort(Comparator.comparing(Book::getName));
                    if (sorted.isEmpty()) System.out.println("Not found");
                    else sorted.forEach(System.out::println);
                    break;
                }
                case "MaxByPrice": {
                    Optional<Book> max = warehouse.max(Comparator.comparingDouble(Book::getPrice));
                    System.out.println(max.map(Object::toString).orElse("Not found"));
                    break;
                }
                case "MinByPrice": {
                    Optional<Book> min = warehouse.min(Comparator.comparingDouble(Book::getPrice));
                    System.out.println(min.map(Object::toString).orElse("Not found"));
                    break;
                }
            }
        }
    }
}
