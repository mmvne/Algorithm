import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();

            int n = Integer.parseInt(br.readLine());
            int count = 1;

            while (n-- > 0) {

                int value = Integer.parseInt(br.readLine());

                if (count <= value) {
                    for (int i = count; i <= value; i++) {
                        stack.push(i);
                        sb.append('+').append('\n');
                    }
                    count = value + 1;
                } else if (stack.peek() != value) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append('-').append('\n');
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}