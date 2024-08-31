import java.util.Scanner;
import java.util.Stack;

public class Main {

	//4949 균형 잡힌 세상
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;

        while (true) {
            str = sc.nextLine();
            if (str.equals(".")) {
                break;
            }
            System.out.println(balance(str));
        }

    }

    private static String balance(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char data = str.charAt(i);

            if (data == '[' || data == '(') {
                stack.push(data);
            } else if (data == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (data == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }

    }
}