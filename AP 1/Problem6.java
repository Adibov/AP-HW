import java.util.Scanner;

public class Problem6 {
	static Scanner input = new Scanner(System.in);
	static int key;
	static String inputString;

	public static void getInput() {
		inputString = input.next();
		key = Integer.parseInt(inputString, 2);
		inputString = input.next();
	}

	public static void solve() {
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			System.out.print(Integer.toBinaryString((int)c ^ key) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		getInput();
		solve();
	}
}
