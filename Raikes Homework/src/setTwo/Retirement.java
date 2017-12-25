package setTwo;

public class Retirement {

	public static void main(String[] args) {
		double start = Double.parseDouble(args[0]);
		double contribute = Double.parseDouble(args[1]);
		double returnRate = Double.parseDouble(args[2]);
		double inflationRate = Double.parseDouble(args[3]);
		int years = Integer.parseInt(args[4]);
		double interest[] = new double[years * 12];
		double balance[] = new double[years * 12];
		double totalInterest[] = new double[1];
		double monthlyRate = (((1 + returnRate) / (1 + inflationRate)) - 1)/12;
		
		if (returnRate > 1 || inflationRate > 1) {
			throw new RuntimeException("Please enter percentages in decimal form");
		}
		if (contribute > 17500) {
			throw new RuntimeException("Error: Contributions exceeds $17,500");
		}
		
		interest[0] = ((double) Math.round((start * monthlyRate) * 100)) / 100;
		balance[0] = start + contribute + interest[0];
		totalInterest[0] = interest[0];

		for (int month = 1; month < years * 12; month++) {
			interest[month] = ((double) Math.round((balance[month-1] * monthlyRate) * 100)) /100;
			balance[month] = balance[month - 1] + contribute + interest[month];
			totalInterest[0] = totalInterest[0] + interest[month];

		}
		System.out.println(String.format("%7s %10s %10s", "Month", "Interest", "Balance"));
		for (int i = 1; i <= years * 12; i++) {
			System.out.println(String.format("%7d %10.2f %10.2f", i, interest[i - 1], balance[i - 1]));
		}

		totalInterest[0] = ((double) Math.round(totalInterest[0] * 100)) / 100;
		balance[years * 12 - 1] = ((double) Math.round(balance[years * 12 -1] * 100)) / 100;
		
		System.out.println("Total Interest Earned: $" + totalInterest[0]);
		System.out.println("Final Account Balance: $" + balance[years * 12 - 1]);

	}

}
