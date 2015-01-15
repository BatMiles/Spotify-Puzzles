import java.util.Scanner;

public class ReverseBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.nextLine().trim());
		String binary = Integer.toBinaryString(input);
		String reversedBinary = reverse(binary);
		int result = Integer.parseInt(reversedBinary, 2);
		System.out.println(result);
	}
	
	private static String reverse(String input) {
		char[] chars = input.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = chars.length-1; i >= 0 ; i--) 
			builder.append(chars[i]);
		
		return builder.toString();
	}

}
