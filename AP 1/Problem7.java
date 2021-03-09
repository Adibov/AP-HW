import java.util.Scanner;

public class Problem7 {
	static Scanner input = new Scanner(System.in);
	static String s1, s2;

	public static void getInput() {
		s1 = input.next();
		s2 = input.next();
	}

	public static boolean change() {
		char different = '\0';
		for (int i = 0; i < s1.length(); i++)
			if (s1.charAt(i) != s2.charAt(i)) {
				if (different == '\0')
					different = s1.charAt(i);
				else if (different != s1.charAt(i))
					return false;
			}
		return different != '\0';
	}

	public static boolean delete() {
		for (int i = 0; i < s1.length(); i++) {
			String tmp = s1.substring(0, i) + s1.substring(i + 1, s1.length());
			if (tmp.equals(s2))
				return true;
		}
		return false;
	}

	public static boolean add() {
		for (int i = 0; i < s1.length(); i++) {
			String tmp = s1.substring(0, i) + s2.charAt(i) + s1.substring(i, s1.length());
			if (tmp.equals(s2))
				return true;
		}
		String tmp = s1 + s2.charAt(s2.length() - 1);
		return tmp.equals(s2);
	}

	public static boolean solve() {
		if (s1.length() == s2.length())
			return change();
		else if (s1.length() - 1 == s2.length())
			return delete();
		else if (s1.length() + 1 == s2.length())
			return add();
		return false;
	}
	public static void main(String[] args) {
		getInput();
		if (solve())
			System.out.println("True");
		else
			System.out.println("False");
	}
}