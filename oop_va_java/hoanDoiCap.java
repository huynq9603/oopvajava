import java.util.Scanner;
class Pair<T>{
    private T first;
    private T second;
    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(T second){
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return second;
    }
    public void swap(){
        T temp = first;
        first = second;
        second = temp;
    }
}
public class hoanDoiCap {
     public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split(" ");
            if(isNumeric(s[0]) && isNumeric(s[1])){
                Integer first = Integer.parseInt(s[0]);
                Integer second = Integer.parseInt(s[1]);
                Pair<Integer> p = new Pair<>(first,second);
                p.swap();
                System.out.println(p.getFirst() + " " + p.getSecond());
            }
            else{
                Pair<String> p = new Pair(s[0], s[1]);
                System.out.println("'" +p.getFirst()+ "'"+ " " + "'" + p.getSecond() + "'");
            }
        }
    }
}
