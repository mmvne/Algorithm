import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			switch (sc.next()) {
			
			case "push": {
				stack.push(Integer.valueOf(sc.next()));
				break;
			}
			
			case "pop": {
				if(stack.isEmpty()) {
					System.out.println("-1");
					break;
				}	
				System.out.println(stack.pop());
				break;
			} 
			
			case "size": {
				System.out.println(stack.size());
				break;
			}
			
			case "empty": {
				if(stack.isEmpty()) {
					System.out.println("1");
					break;
				} else {
					System.out.println("0");
					break;
				}
			}
			
			case "top": {
				if(stack.isEmpty()) {
					System.out.println("-1");
					break;
				}	
				System.out.println(stack.peek());
				break;
			}

			}
		}
	}
}