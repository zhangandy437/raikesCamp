package setTwo;

public class FizzBuzz {

	public static void main(String[] args) {

		double end = Double.parseDouble(args[0]);
		
		for(int i = 1; i <= end; i++){
			double root = Math.sqrt(i);
			double rootTest = root - Math.floor(root);
			if(rootTest == 0){
				System.out.println("Go Huskers!");
				//System.out.println(i);
			}
			if(rootTest > 0){
				boolean prime = true;
				for(int j = 1; j <= i; j++){
					double primeTest = (double) i / j;
					double floor = Math.floor(primeTest);
					double mod = primeTest % floor;
					if(mod == 0 && j != 1 && j != i){
						prime = false;
					}
				}
				if(prime){
					System.out.println("Go Cubs!");
					//System.out.println(i);
				}
			}
		}
		
	}
}
