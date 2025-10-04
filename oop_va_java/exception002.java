import java.util.*;
class NotJavaFileException extends Exception{
	public NotJavaFileException(String messange){
		super(messange);
	}	
}
public class Main{
	public static void checkFileExtension(String filename) throws  NotJavaFileException{
		if(filename == null||filename.isEmpty()){
			throw new  NotJavaFileException("Not java file exception.Mark is -1");
		}
		else{
			String[] s = filename.split("\\.");
			if(s.length == 1) System.out.println(0);
			else System.out.println(1);
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0){
			String filename = sc.nextLine();
			try{
				checkFileExtension(filename);
			}
			catch (NotJavaFileException e){
				System.out.println(e.getMessage());
			}
		}
	}
}