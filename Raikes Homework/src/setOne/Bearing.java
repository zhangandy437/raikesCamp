package setOne;

import java.util.Scanner;

public class Bearing {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter First Location's Latitude");
		double latA = scan.nextDouble();
		System.out.println("Enter First Location's Longitute");
		double longA = scan.nextDouble();
		System.out.println("Enter Second Location's Latitude");
		double latB = scan.nextDouble();
		System.out.println("Enter Second Location's Longitude");
		double longB = scan.nextDouble();
		scan.close();
		
		if(longA > 180 || longA < -180 || latA > 180 || latA < -180 || longB > 180 || longB < -180 || latB > 180 || latB > -180){
			throw new RuntimeException("Please enter values in degrees");
		}
		
		double rlatA = (latA / 180) * Math.PI;
		double rlatB = (latB / 180) * Math.PI;
		double rlongA = (longA / 180) * Math.PI;
		double rlongB = (longB / 180) * Math.PI;
		double rlocateAB = rlongB - rlongA;
		
		double bearing = Math.atan2(Math.sin(rlocateAB) * Math.cos(rlatB), Math.cos(rlatA) * Math.sin(rlatB) - Math.sin(rlatA) * Math.cos(rlatB) * Math.cos(rlocateAB));
		
		double bearingD = (bearing * 180) / Math.PI;
		System.out.println("Bearing " + bearingD + " degrees");
		
		
	}

}
