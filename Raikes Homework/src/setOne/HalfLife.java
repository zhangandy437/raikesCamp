package setOne;

import java.util.Scanner;

public class HalfLife {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Mass of Isotope");
		double isotope = scan.nextDouble();
		System.out.println("Enter Half-Life of Isotope");
		double halfLife = scan.nextDouble();
		System.out.println("Enter Years");
		double years = scan.nextDouble();
		scan.close();
		
		if(years < 0 || isotope < 0 || halfLife < 0){
			throw new RuntimeException("Ur fet");
		}
		
		double decay = years / halfLife;
		double expOf = Math.pow(.5, decay);
		double amountLeft = (double) Math.round(expOf * 100000) / 10000;
		
		System.out.println("Starting with " + isotope + "kg of an isotope with a half-life of");
		System.out.println(halfLife + " years, after " + years + " years you would have");
		System.out.println(amountLeft + "kg left");
		
	}

}
