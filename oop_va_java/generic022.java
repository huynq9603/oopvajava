import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
interface Filter<T>{
    boolean test(T t);
}
interface Mapper<T,R>{
    R map(T t);
}
class ListProcessor{
    public static <T> List<T> filter(List<T> input, Filter<T> filter){
        List<T> res = new ArrayList<>();
        for(T item : input){
            if(filter.test(item)){
                res.add(item);
            }
        }
        return res;
    }
    public static <T,R> List<R> map(List<T> input, Mapper<T,R> mapper){
        List<R> res = new ArrayList<>();
        for(T item: input){
            res.add(mapper.map(item));
        }
        return res;
    }
    public static <T> List<T> sort(List<T> input, Comparator<T> comparator){
        List<T> res = new ArrayList<>(input);
        res.sort(comparator);
        return res;
    }
}
class Student{
    private String name;
    private double gpa;
    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }
    public String getName(){
        return name;
    }
    public double getGPA(){
        return gpa;
    }
    @Override
    public String toString(){
        return name + " " + gpa;
    }
}
public class generic022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(true){
            String line = sc.nextLine();
            if(!line.equals("End")){
                String[] arr = line.split(" ");
                if(arr[0].equals("FilterGpaAbove")){
                    List<Student> res = new ArrayList<>();
                    for(int i = 3; i < arr.length; i+=2){
                        res.add(new Student(arr[i], Double.parseDouble(arr[i+1])));
                    }
                    res = ListProcessor.filter(res,s -> s.getGPA() > Double.parseDouble(arr[1]));
                    for(Student s : res){
                        System.out.println(s.toString());
                    }
                }
                else if(arr[0].equals("MapStudentToName")){
                    List<Student> students = new ArrayList<>();
                    for(int i = 2;i < arr.length; i+=2){
                        students.add(new Student(arr[i], Double.parseDouble(arr[i+1])));
                    }
                    List<String> res = ListProcessor.map(students, Student::getName);
                    for(String s : res){
                        System.out.println(s);
                    }
                }
                else if(arr[0].equals("SortStudentByGpa")){
                    List<Student> res = new ArrayList<>();
                    for(int i =2; i< arr.length; i+=2){
                        res.add(new Student(arr[i], Double.parseDouble(arr[i+1])));
                    }
                    res = ListProcessor.sort(res, Comparator.comparingDouble(Student::getGPA));
                    for(Student st : res){
                        System.out.println(st.toString());
                    }
                }
                else if(arr[0].equals("FilterIntOdd")){
                    List<Integer> res = new ArrayList<>();
                    for(int i = 2; i< arr.length; i++){
                        res.add(Integer.parseInt(arr[i]));
                    }
                    res = ListProcessor.filter(res, x -> x%2==1);
                    for(Integer integer : res){
                        System.out.println(integer);
                    }
                }
                else if(arr[0].equals("SortIntAsc")){
                    List<Integer> res = new ArrayList<>();
                    for(int i = 2; i< arr.length; i++){
                        res.add(Integer.parseInt(arr[i]));
                    }
                    res = ListProcessor.sort(res, Integer::compareTo);
                    for(Integer integer : res){
                        System.out.println(integer);
                    }
                }
                else if(arr[0].equals("MapIntToSquare")){
                    List<Integer> res = new ArrayList<>();
                    for(int i = 2; i< arr.length; i++){
                        res.add(Integer.parseInt(arr[i]));
                    }
                    res = ListProcessor.map(res,x -> x*x );
                    for(Integer integer : res){
                        System.out.println(integer);
                    }
                }
            }
            else{
                break;
            }
        }
    }
}
