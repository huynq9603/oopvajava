import java.util.*;
class NotContainVowelException extends Exception{
    public NotContainVowelException(String message){
        super(message);
    }
}
public class Main {
    public boolean containsVowel(String s){
        return s.toLowerCase().matches(".*[aeuio].*");
    }
    public static void checkVowels(String s) throws NotContainVowelException {
    if (!containsVowel(s)) {
        throw new NotContainVowelException("String not contain vowels");
    } else {
        System.out.println("String has vowels");
    }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            try{
                checkVowels(s);
            }
            catch (NotContainVowelException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
