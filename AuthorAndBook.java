import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book[name=" + name + ", " + author.toString() + ", price=" + price + ", qty=" + qty + "]";
    }
}

public class AuthorAndBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            Book book = null;
            Author author = null;

            while (true) {
                String x = sc.nextLine();
                if (x.equals("End")) break;

                if (x.equals("Book")) {
                    String nameBook = sc.nextLine();
                    double price = Double.parseDouble(sc.nextLine());
                    int qty = Integer.parseInt(sc.nextLine());
                    book = new Book(nameBook, null, price, qty);
                } else if (x.equals("Author")) {
                    String nameAuthor = sc.nextLine();
                    String email = sc.nextLine();
                    char gender = sc.nextLine().charAt(0);
                    author = new Author(nameAuthor, email, gender);
                    if (book != null) {
                        book.setAuthor(author);
                    }
                }
            }

            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }
}
