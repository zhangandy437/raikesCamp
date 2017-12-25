package setTwo;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		List<Integer> inputValues = new ArrayList<Integer>();
		List<Integer> missing = new ArrayList<Integer>();
		
		for(int i = 1; i < args.length; i++){
			int list = Integer.parseInt(args[i]);
			inputValues.add(list);
		}
		for(int j = 1; j < n + 1; j++){
			boolean isMissing = true;
			for (int i = 0; i < inputValues.size(); i++) {
				int current = inputValues.get(i);
				if(current == j){
					isMissing = false;
				}
			}
			if(isMissing){
				missing.add(j);
			}

		}
		System.out.println("Here are the missing numbers");
		for(int i = 0; i < missing.size() - 1; i++){
			System.out.print(missing.get(i) + ", ");
		}
		System.out.println(missing.get(missing.size() - 1));
	}
}