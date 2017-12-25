package setThree;

public class Utilities {


	public static double degreesToRadians(double degrees) throws Exception {
		if(degrees < 0 || degrees > 360){
			throw new Exception("Error: Input must be between 0 and 360");
		}
		double radians = (double) (degrees * Math.PI) / 180;
		return radians;
	}
	
	public static double annualPercentageYield(double apr){ 
		double apy = (double) Math.pow(Math.E , apr) - 1;
		return apy;
	}
	
	public static double getAirDistance(double latA, double longA, double latB, double longB) throws Exception{
		if(longA > 180 || longA < -180 || latA > 180 || latA < -180 || longB > 180 || longB < -180 || latB > 180 || latB > -180){
			throw new Exception("Error: Inputs must be between 0 and 180");
		}
		double rlatA = (latA / 180) * Math.PI;
		double rlatB = (latB / 180) * Math.PI;
		double rlongA = (longA / 180) * Math.PI;
		double rlongB = (longB / 180) * Math.PI;
		double rlocateAB = rlongB - rlongA;
		
		double bearing = Math.atan2(Math.sin(rlocateAB) * Math.cos(rlatB), Math.cos(rlatA) * Math.sin(rlatB) - Math.sin(rlatA) * Math.cos(rlatB) * Math.cos(rlocateAB));
		
		double bearingD = (bearing * 180) / Math.PI;
		return bearingD;
	}
	

}
