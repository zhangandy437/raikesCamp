package setTwo;

public class AffineCipher {

	public static void main(String[] args) {
		String base = " ABCDEFGHIJKLMNOPQRSTUVWXYZ.!";
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		// List<Character> myCharacter = new ArrayList<Character>();
		StringBuilder decryptedString = new StringBuilder();

		int inverse = 0;
		int bleh = 0;
		int bf = 1;
		while (bleh != 1) {
			bleh = (a * bf) % 29;
			if (bleh == 1) {
				inverse = bf;
			}
			bf++;
		}

		for (int i = 0; i < args[2].length(); i++) {
			char myChar = args[2].charAt(i);

			int j = base.indexOf(myChar);
			int character = (inverse * (j - b));
			while (character < 29) {
				character = character + 29;
			}
			int letter = character % 29;
			decryptedString.append(base.charAt(letter));
		}
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a^-1 = " + inverse);
		System.out.println("Encrypted Message = " + args[2]);
		System.out.println("Decrypted Message = " + decryptedString.toString());

	}

}
