package setTwo;

public class DNASequence {
	public static void main(String[] args) {
		int length = Integer.parseInt(args[0]);
		int highest = 0;
		String sequence = args[1];
		int highestPossible = length;
		
		for(int i = 0; i < sequence.length() - (length - 1); i++){
			char current = sequence.charAt(i);
			if(current == 'C' || current == 'G'){
				highest = highest + 1;
			}
			if(current != 'C' && current != 'G'){
				highest = 0;
			}
			if(highest == highestPossible){
				break;
			}
			if(i == sequence.length() - length){
				i = 0;
				highest = 0;
				highestPossible= highestPossible - 1;
			}
		}
		
		System.out.println("n = " + length);
		double percentage = (Math.round(((double) highest / length) * 10000)) / 100;
		System.out.println(percentage);
		System.out.println("Highest frequency: " + highest + "/" + length + " = " + percentage + "%");
		
		for(int i = 0; i < sequence.length() - (highest - 1); i++){
			char current = sequence.charAt(i);
			int corresponding = 1;
			if(current == 'C' || current == 'G'){
				for(int j = 1; j < highest; j++){
					char next = sequence.charAt(i + j);
					if(next == 'C' || next == 'G'){
						corresponding = corresponding + 1;
					}
					if(next != 'C' && next != 'G'){
						break;
					}
				}
			
			if(corresponding == highest){				
				System.out.print(String.format("%2d %2s %2d", i, "to", (i + highest)));
				System.out.print(" ");
				for(int j = 0; j < highest; j++){
					if(j == (highest - 1)){
						System.out.println(sequence.charAt(i + j));
						break;
					}
					System.out.print(sequence.charAt(i + j));
				}
			}
			}
		}
	} 

}
