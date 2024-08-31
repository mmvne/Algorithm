import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			System.out.println(dataSave(sc.next()));
		}
	}

	public static String dataSave(String str) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char data = str.charAt(i);
			if (data == '(') {
				stack.push(data);
			} else if (stack.isEmpty()) {
				return "NO";
			} else {
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			return "YES";	
		}
		return "NO";
	}
}