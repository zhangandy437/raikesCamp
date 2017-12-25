package setTwo;

public class AirDistance {

	public static void main(String[] args) {
			double total = 0;

			for(int increase = 0; increase < args.length-2; increase+=2){
				double Lat = Math.toRadians(Double.parseDouble(args[increase]));
				double Long = Math.toRadians(Double.parseDouble(args[increase + 1]));
				double Lat2 = Math.toRadians(Double.parseDouble(args[increase + 2]));
				double Long2 = Math.toRadians(Double.parseDouble(args[increase + 3]));
				double arccos = Math.acos(Math.sin(Lat) * Math.sin(Lat2) + Math.cos(Lat) * Math.cos(Lat2) * Math.cos(Long - Long2)) * 6371;
				double round = Math.round(arccos * 10000);
				double round2 = round / 10000;
				total = arccos + total;
				System.out.println("(" + args[increase] + ", " + args[increase + 1] + ") to (" + args[increase + 2] + ", " + args[increase + 3] + "): " + round2 + "km");
			}

			double rounded = Math.round(total * 10000);
			double rounded2 = rounded / 10000;
			System.out.println("Total Distance: " + rounded2 + "km");
			
	}

}
