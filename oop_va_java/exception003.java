import java.util.*;
import java.text.DecimalFormat;
class UsedCarException extends Exception{
	public UsedCarException(String vin){
		super("Invalid Used Car: VIN " + vin);
	}	
}
class UsedCar{
	private String vin;
	private String make;
	private int year;
	private int mileage;
	private int price;
	public UsedCar(String vin,String make, int year, int mileage, int price) throws UsedCarException{
		if(vin.length() == 4){
			throw new UsedCarException(vin);
		}
		else if(!make.equals("Ford")&&!make.equals("Honda")&&!make.equals("Toyota")&&!make.equals("Chrysler")){
			throw new UsedCarException(vin);
		}
		else if(year<1990||year>2014){
			throw new UsedCarException(vin);
		}
		else if(mileage<0 || price < 0){
			throw new UsedCarException(vin);
		}
		else{
			this.vin = vin;
			this.make = make;
			this.year = year;
			this.mileage = mileage;
			this.price = price;
		}
	}
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.0");
		return "UsedCar{vin='" + vin + "', make='" + make + "', year=" + year + ", mileage=" + mileage + ", price=" + df.format(price) + "}";
	}
}
public class exception003{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		List<UsedCar> list = new ArrayList<>();
		while(t-- > 0){
			String[] arr = sc.nextLine().split(",");
			try{
				list.add(new UsedCar(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4])));
			}
			catch (UsedCarException e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("List of successfully constructed UsedCar objects:");
		for(UsedCar usedcar : list){
			System.out.println(usedcar.toString());
		}
		if(list.isEmpty()){
			System.out.println("No used cars");
		}
	}
}
