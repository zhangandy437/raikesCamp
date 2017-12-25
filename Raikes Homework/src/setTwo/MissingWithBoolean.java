package setTwo;

public class MissingWithBoolean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = Integer.parseInt(args[0]);
		int[] provided = new int[args.length - 1];
		int[] missing = new int[number];
		int counter = 0;
		
		//puts everything in provided
		for(int i = 1; i < args.length; i++){
			provided[i - 1] = Integer.parseInt(args[i]);
		}

		for(int i = 1; i <= number; i++){
			boolean isProvided = false;
			for(int j = 0; j < provided.length; j++){
				if(i == provided[j]){
					isProvided = true;
				}
			}
			if(!isProvided){
				missing[counter] = i;
				counter++;
			}
		}
		
		System.out.print("THE MISSING NUMBERS ARE AS FOLLOWS: ");
		
		for(int i = 0; i < counter; i++){
			System.out.print(missing[i]);
			if(i != counter - 1){
				System.out.print(", ");
			}
		}
	}

}
