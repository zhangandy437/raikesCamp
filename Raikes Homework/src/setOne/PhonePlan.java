package setOne;

import java.util.Scanner;

public class PhonePlan {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		
		System.out.println("Enter Number of Minutes per 30 Days Plan Period");
		int m = scan.nextInt();
		System.out.println("Enter Current Day In Current Period");
		int d = scan.nextInt();
		System.out.println("Enter Total Amount of Minutes Used so Far");
		int u = scan.nextInt();
		if(m < 0 || d < 0 || u < 0){
			throw new RuntimeException("Ur fet");
		}
		
		int daysLeft = 30 -d;
		double averageUsage = (Math.round((m / 30)*100))/100;
		double userAverage = (Math.round((u / d)*100))/100;
		double test = averageUsage - userAverage;
		System.out.println(d + " days used");
		System.out.println(daysLeft + " days remaining");
		System.out.println("Average Usage: " + userAverage + " min/day");
		if(test > 0){
			System.out.println("Great Job! You are below your average daily use (" + averageUsage + " min/day)");
		}
		else if(test <0){
			System.out.println("You are exceeding your daily average use (" + averageUsage + "min/day)");
			double endUsage = userAverage * daysLeft;
			double byHowMuch = endUsage - m + u;
			System.out.println("If you continue this, you will be over your plan by " + byHowMuch + " minutes");
		}
		

	}

}
