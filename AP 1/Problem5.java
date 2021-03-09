import java.util.Scanner;

public class Problem5 {
	static Scanner input = new Scanner(System.in);
	static float a1, b1, a2, b2;
	static char operation;
	static int indx = 0;
	static char[] operations = new char[100];
	static String[] answers = new String[100];
	
	public static void getInput() {
		a1 = input.nextFloat(); b1 = input.nextFloat(); a2 = input.nextFloat(); b2 = input.nextFloat();
		while (true) {
			String tmp = input.next();
			operation = tmp.charAt(0);
			if (operation == '#')
				break;
			
			operations[indx++] = operation;
		}
	}

	public static String convertToString(float a, float b) {
		if (b >= 0.0) {
			if (b != 1.0)
				return (String)(Float.toString(a) + '+' + Float.toString(b) + 'i');
			return (String)(Float.toString(a) + '+' + 'i');
		}
		
		if (b != -1.0)
			return (String)(Float.toString(a) + Float.toString(b) + 'i');
		return (String)(Float.toString(a) + '-' + 'i');
	}

	public static void solve() {
		float a, b;
		for (int i = 0; i < indx; i++)
			if (operations[i] == '+') {
				a = a1 + a2;
				b = b1 + b2;
				answers[i] = convertToString(a, b);
			}
			else if (operations[i] == '-') {
				a = a1 - a2;
				b = b1 - b2;
				answers[i] = convertToString(a, b);
			}
			else if (operations[i] == '*') {
				a = a1 * a2 - b1 * b2;
				b = a1 * b2 + a2 * b1;
				answers[i] = convertToString(a, b);
			}
			else {
				float x = a2 * a2 + b2 * b2;
				a = (a1 * a2 + b1 * b2) / x;
				b = (a2 * b1 - a1 * b2) / x;
				answers[i] = convertToString(a, b);
			}
	}

	public static void printAnswers() {
		for (int i = 0; i < indx; i++)
			System.out.println(answers[i]);
	}

	public static void main(String[] args) {
		getInput();
		solve();
		printAnswers();
	}
}
