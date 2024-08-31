import java.util.Scanner;
import java.util.Stack;

public class Main {

	// 10773 제로
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		String str;
		int K = sc.nextInt();

		for (int i = 0; i < K; i++) {
			str = sc.next();
			if (Integer.valueOf(str) != 0) {
				stack.push(Integer.valueOf(str));
			} else {
				stack.pop();
			}
			
		}
		
		for (Integer number : stack) {
			sum += number;
		}

		System.out.println(sum);
	}
}