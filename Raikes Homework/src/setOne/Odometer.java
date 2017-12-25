package setOne;

import java.util.Scanner;

public class Odometer {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Enter Beginning Odometer Reading");
		double beginning = scan.nextDouble();
		if(beginning< 0 ){
			throw new RuntimeException("Please enter an acceptable value");
		}
		System.out.println("Enter Ending Odometer Reading");
		double ending = scan.nextDouble();
		if(ending < beginning){
			throw new RuntimeException("Please enter an acceptable value");
		}
		System.out.println("Enter Amount of Gallons to Fill Tank");
		double gallons = scan.nextDouble();
		if(gallons < 0){
			throw new RuntimeException("Please enter an acceptable value");
		}
		System.out.println("Enter Cost of Gas in Dollars Per Gallon");
		double cost = scan.nextDouble();

		double miles = ending - beginning;
		double milesPerGallon = miles / gallons;
		double costPerGallon = cost / milesPerGallon;
		costPerGallon = costPerGallon * 100;
		costPerGallon = Math.round(costPerGallon * 100) / 100.0;

		System.out.println("Miles Traveled: " + miles);
		System.out.println("Miles Per Gallon: " + milesPerGallon);
		System.out.println("Cost Per Gallon: $" + costPerGallon);

	}
}