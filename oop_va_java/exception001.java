import java.util.Scanner;

class Amount{
    private String currency;
    private int amount;
    public Amount(String currency, int amount){
        this.currency = currency;
        this.amount = amount;
    }
    public int add(Amount amount) throws Exception{
        if(!this.currency.equals(amount.currency)){
            throw new Exception("Currency doesn't match");
        }
        return this.amount + amount.amount;
    }
}
public class exception001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] arr = sc.nextLine().split(" ");
            Amount a1 = new Amount(arr[0], Integer.parseInt(arr[1]));
            Amount a2 = new Amount(arr[2], Integer.parseInt(arr[3]));
            try{
                int amount = a1.add(a2);
                System.out.println(amount);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
