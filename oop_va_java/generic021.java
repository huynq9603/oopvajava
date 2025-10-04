import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
interface Mapper<T,R> {
    R map(T t);
}
class GenericMapper{
    public static <T,R> List<R> map(List<T> input, Mapper<T,R> mapper){
        List<R> result = new ArrayList<>();
        for(T item : input){
            result.add(mapper.map(item));
        }
        return result;
    }
}
class IntegerToStringMapper implements Mapper<Integer,String>{
    public String map(Integer t){
        return String.valueOf(t);
    }
}
class StringToLengthMapper implements Mapper<String,Integer>{
    public Integer map(String s){
        return s.length();
    }
}
class EmployeeToStringMapper implements Mapper<Employee,String>{
    @Override
    public String map(Employee e){
        return e.toString();
    }
}
class Employee{
    private String name;
    private double salary;
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    @Override
    public String toString(){
        return name + ":" + salary;
    }
}
public class generic021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String line;
        while(true){
            line = sc.nextLine();
            if(!line.equals("End")){
                String[] arr = line.split(" ");
                if(arr[0].equals("MapIntToString")){
                    int n = Integer.parseInt(arr[1]);
                    List<Integer> s = new ArrayList<>();
                    for(int i = 2; i< arr.length; i++){
                        s.add(Integer.parseInt(arr[i]));
                    }
                    List<String> res = GenericMapper.map(s, new IntegerToStringMapper());
                    for(String x : res){
                        System.out.println(x);
                    }
                }
                else if(arr[0].equals("MapStringToLength")){
                    int n = Integer.parseInt(arr[1]);
                    List<String> list = new ArrayList<>();
                    for(int i = 2; i < arr. length; i++){
                        list.add(arr[i]);
                    }
                    List<Integer> res = GenericMapper.map(list, new StringToLengthMapper());
                    for(Integer i : res){
                        System.out.println(i);
                    }
                }
                else{
                    int n = Integer.parseInt(arr[1]);
                    List<Employee> e = new ArrayList<>();
                    for(int i = 2; i < arr.length; i+=2){
                        e.add(new Employee(arr[i], Double.parseDouble(arr[i+1])));
                    }
                    List<String> res = GenericMapper.map(e,new EmployeeToStringMapper());
                    for(String x : res){
                        System.out.println(x);
                    }
                }
            }
            else{
                break;
            }
        }
    }
}
