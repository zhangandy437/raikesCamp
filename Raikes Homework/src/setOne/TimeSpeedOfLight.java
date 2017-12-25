package setOne;

import java.util.Scanner;

public class TimeSpeedOfLight {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);

		System.out.println("Enter percentage of the speed of light at which you are traveling");
		double lightPercent = scan.nextDouble();
		double percentDisplay = lightPercent * 100;
		System.out.println("Enter Hour(s)");
		double hours = scan.nextDouble();
		double timeEarth = hours / ((double) Math.sqrt(1 - (lightPercent * lightPercent)));

		if (timeEarth < 0) {
			throw new RuntimeException("");
		}

		System.out.println("Traveling for " + hours + " hour(s) in your spaceship at \n" + percentDisplay
				+ "% the speed of light, your friends on \n Earth would experience:");

		Time formattedTime = new Time(timeEarth);
		
		System.out.println(formattedTime.toString());

	}
}









class Time{
	int years;
	int weeks;
	int days;
	int hours;
	double minutes;
	
	Time(double earthHours){
		years = (int) Math.floor(earthHours/8766);
		earthHours%=8766;
		weeks = (int) Math.floor(earthHours/168);
		earthHours%=168;
		days = (int) Math.floor(earthHours/24);
		earthHours%=24;
		hours = (int) Math.floor(earthHours);
		earthHours%=1;
		minutes = earthHours * 60;
	}
	
	@Override
	public String toString(){
		boolean shouldPrint = false;
		StringBuilder output = new StringBuilder();
		
		if(years + weeks + days + minutes == 0) return "AIN'T NOBODY GOT TIME FOR THAT";
		
		if(years > 0){
			output.append(years + " Year(s)\n");
			shouldPrint = true;
		}
		if(weeks > 0 || shouldPrint){
			output.append(weeks + " Week(s)\n");
			shouldPrint = true;
		}
		if(days > 0 || shouldPrint){
			output.append(days + " Day(s)\n");
			shouldPrint = true;
		}
		if(hours > 0 || shouldPrint){
			output.append(hours + " Hour(s)\n");
			shouldPrint = true;
		}
		output.append(String.format("%.2f Minute(s)", minutes));
		
		return output.toString();
	}
}
