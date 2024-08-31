import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
//import java.util.Arrays;
import java.util.Deque;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

		public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			Deque<Integer> queue = new ArrayDeque<>();

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
				switch (stringTokenizer.nextToken()) {

				case "push": {

					String token = stringTokenizer.nextToken();
					int number = Integer.parseInt(token);
					queue.add(number);

					break;
				}

				case "pop": {
					if (queue.isEmpty()) {
//						System.out.println("-1");
						bw.write("-1\n");
						break;
					}
//					System.out.println(queue.pop());
					bw.write(String.valueOf(queue.pop()) + '\n');
					break;
				}

				case "size": {
//					System.out.println(queue.size());
					bw.write(String.valueOf(queue.size()) + '\n');
					break;
				}

				case "empty": {
					if (queue.isEmpty()) {
//						System.out.println("1");
						bw.write("1\n");
						break;
					} else {
//						System.out.println("0");
						bw.write("0\n");
						break;
					}
				}

				case "front": {
					if (queue.isEmpty()) {
//						System.out.println("-1");
						bw.write("-1\n");
						break;
					}
//					System.out.println(queue.peek());
					bw.write(String.valueOf(queue.peek()) + '\n');
					break;
				}

				case "back": {
					if (queue.isEmpty()) {
//						System.out.println("-1");
						bw.write("-1\n");
						break;
					}
//					System.out.println(queue.getLast());
					bw.write(String.valueOf(queue.getLast()) + '\n');
					break;
				}

				}
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}