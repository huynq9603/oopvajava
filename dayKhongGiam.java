import java.util.Scanner;
public class dayKhongGiam{
    public int dayKoGiam(int a[],int n){
        int[] b= new int[n];
        for (int i = 0; i < n; i++) b[i] = 1;
        for(int i = 1;i<n;i++){
            if(a[i-1] <= a[i]){
                b[i] = Math.max(b[i],b[i-1]+1);
            }
        }
        int maximum = b[0];
        for(int i = 0;i<n;i++){
            if(maximum < b[i])
                maximum = b[i];
        }
        return maximum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] s = sc.nextLine().split(" ");
            int n = s.length;
            int[] a = new int[n];
            for(int i = 0;i<n;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            dayKhongGiam d = new dayKhongGiam();
            System.out.println(d.dayKoGiam(a,n));
        }
    }
}