import java.util.*;
interface Packable{
	double weight();
}
class Book implements Packable{
	private String author;
	private String name;
	private double weight;
	public Book(String author, String name, double weight){
		this.author = author;
		this.name = name;
		this.weight = weight;
	}
	@Override
	public double weight(){
		return weight;
	}
	@Override
	public String toString(){
		return author + ": " + name;
	}
}
class CD implements Packable{
	private String artist;
	private String name;
	private int publicationYear;
	public CD(String artist, String name, int publicationYear){
		this.artist = artist;
		this.name = name;
		this.publicationYear = publicationYear;
	}	
	@Override
	public double weight(){
		return 0.1;
	}
	@Override
	public String toString(){
		return artist + ": " + name + " (" + publicationYear + ")";
	}
}
public class Main{
	public static void main(String args[]){
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book("Fyodor Dostoevsky","Crime and Punishment",2));
		books.add(new Book("Robert Martin", "Clean Code",1));
		books.add(new Book("Kent Beck", "Test Driven Development",0.5));
		ArrayList<CD> cds = new ArrayList<>();
		cds.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
		cds.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
		cds.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));
		for(Book book : books){
			System.out.println(book.toString());
		}
		for(CD cd : cds){
			System.out.println(cd.toString());
		}
	}
}