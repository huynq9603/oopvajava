import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@FunctionalInterface
interface Filter<T> {
	boolean test(T t);
}

class GenericFilter {
	public static <T> List<T> filter(List<T> input, Filter<T> filter) {
		List<T> res = new ArrayList<>();
		for (T t : input) {
			if (filter.test(t)) {
				res.add(t);
			}
		}
		return res;
	}
}

class IntegerEvenFilter implements Filter<Integer> {
	@Override
	public boolean test(Integer t) {
		return t % 2 == 0;
	}
}

class StringLengthFilter implements Filter<String> {
	private int minLength;

	public StringLengthFilter(int minLength) {
		super();
		this.minLength = minLength;
	}

	@Override
	public boolean test(String t) {
		return t.length() >= this.minLength;
	}
}

class EmployeeSalaryFilter implements Filter<Employee1> {
	private double minSalary;

	public EmployeeSalaryFilter(double minSalary) {
		super();
		this.minSalary = minSalary;
	}

	@Override
	public boolean test(Employee1 t) {
		return t.getSalary() > this.minSalary;
	}
}

class Employee1 {
	private String name;
	private double salary;

	public Employee1(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%s %.1f", this.name, this.salary);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String line;
		while (true) {
			line = sc.nextLine();
			if (!line.equals("End")) {
				String[] arr = line.split("\\s+");
				if (arr[0].equals("FilterIntEven")) {
					int n = Integer.parseInt(arr[1]);
					List<Integer> list = new ArrayList<>();
					for (int i = 2; i < arr.length; i++) {
						list.add(Integer.parseInt(arr[i]));
					}
					List<Integer> res = GenericFilter.filter(list, new IntegerEvenFilter());
					for (Integer i : res) {
						System.out.println(i);
					}
					if (res.isEmpty()) {
						System.out.println("None");
					}
				} else if (arr[0].equals("FilterStringLength")) {
					int minLength = Integer.parseInt(arr[1]);
					int n = Integer.parseInt(arr[2]);
					List<String> list = new ArrayList<>();
					for (int i = 3; i < arr.length; i++) {
						list.add(arr[i]);
					}
					List<String> res = GenericFilter.filter(list, new StringLengthFilter(minLength));
					for (String i : res) {
						System.out.println(i);
					}
					if (res.isEmpty()) {
						System.out.println("None");
					}
				} else if (arr[0].equals("FilterEmployeeSalary")) {
					double minSalary = Double.parseDouble(arr[1]);
					int n = Integer.parseInt(arr[2]);
					List<Employee1> list = new ArrayList<>();
					for (int i = 3; i < arr.length; i += 2) {
list.add(new Employee1(arr[i], Double.parseDouble(arr[i + 1])));
					}
					List<Employee1> res = GenericFilter.filter(list, new EmployeeSalaryFilter(minSalary));
					for (Employee1 i : res) {
						System.out.println(i);
					}
					if (res.isEmpty()) {
						System.out.println("None");
					}
				}
			}

			else {
				break;
			}
		}
		sc.close();
	}

}
