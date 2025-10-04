import java.util.Scanner;
public class timChiSoPhanTu {
    public static <T> int findFirstMatch(T[] array,T target){
        for(int i = 0; i < array.length - 2;i++){
            if(target.equals(array[i])){
                return i;
            }
        }
        return -1;
    } 
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split(" ");
            int index = findFirstMatch(s, s[s.length - 1]);
            System.out.println(index);
        }
    }
}
