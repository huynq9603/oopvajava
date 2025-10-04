import java.util.*;
interface Identifiable{
    String getId();
}
interface Birthable{
    String getBirthDate();
}
class Citizen implements Identifiable, Birthable{
    private String name;
    private int age;
    private String id;
    private String birthDate;
    public Citizen(String name,int age, String id,String birthDate){
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String getId(){
        return id;
    }
    @Override
    public String getBirthDate(){
        return birthDate;
    }
}
class Pet implements Birthable{
    private String name;
    private String birthDate;
    public Pet(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    public String getName(){
        return name;
    }
    @Override
    public String getBirthDate(){
        return birthDate;
    }
}
public class interface005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        List<Birthable> birthables = new ArrayList<>();
        while(true){
            String line = sc.nextLine();
            if(!line.equals("End")){
                String[] arr = line.split(" ");
                if(arr[0].equals("Citizen")){
                    birthables.add(new Citizen(arr[1], Integer.parseInt(arr[2]), arr[3], arr[4]));
                }
                else{
                    birthables.add(new Pet(arr[1],arr[2]));
                }
            }
            else break;
        }
        String date = sc.next();
        for(Birthable birthable : birthables){
            String birthDate = birthable.getBirthDate();
            String[] birthdate = birthDate.split("/");
            if(date.equals(birthdate[2]))
                System.out.println(birthDate);
        }
    }
}
