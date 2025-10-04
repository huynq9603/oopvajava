import java.util.Scanner;
public class string002{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0){
            String s1 = sc.next();
            String s2 = sc.next();
            if(s1.contains(s2))
                System.out.println("true");
            else
                System.out.println("false");
		}
    }
}