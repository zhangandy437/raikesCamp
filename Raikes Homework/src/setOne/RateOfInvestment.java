package setOne;

import java.util.Scanner;

public class RateOfInvestment {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Cost Of Investment");
		double cost = scan.nextInt();
		System.out.println("Enter Gain Of Investment");
		double gain = scan.nextInt();
		scan.close();
		if(cost < 0){
			throw new RuntimeException("Please enter an acceptable value");
		}
		if(gain < cost){
			throw new RuntimeException("Please enter an acceptable value");
		}

		double numerator = gain - cost;
		double roi = numerator / cost;
		double ans = roi * 100;

		System.out.println("Your ROI is : " + ans + "%");
	}

}