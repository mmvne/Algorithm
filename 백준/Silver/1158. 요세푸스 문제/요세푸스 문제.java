import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	// 1158 요세푸스
	public static void main(String[] args) {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			Deque<Integer> queue = new ArrayDeque<>();

			String line = br.readLine();
			String[] split = line.split(" ");

			// 7 3 입력시 " "으로 잘라서 N = 7, K = 3에 저장
			int N = Integer.parseInt(split[0]);
			int K = Integer.parseInt(split[1]);
			// 데이터의 인덱스로 사용하기 위한 변수
			int j = 0;
			// 큐에서 꺼낸 데이터를 저장하기 위한 배열
			int[] data = new int[N];

			// 1번부터 N 번까지 데이터 add
			for (int i = 1; i <= N; i++) {
				queue.add(i);
			}

			// size가 0 일때 까지 무한 반복
			while (true) {
				// size가 0 이면 반복문 나오기
				if (queue.size() == 0) {
					break;
				}
				// 입력 받은 K개 전까지 꺼내고 꺼낸값 다시 큐에 add 후 K번째 데이터를 새로운 배열에 add 반복
				for (int i = 1; i <= K; i++) {
					if (queue.size() == 0) {
						break;
					}

					if (i == K) {
						data[j++] = queue.poll();
                        
						// K번째전까지 데이터를 다시 큐에 add
					} else {
						queue.add(queue.poll());
					}

				}
				
			}

			System.out.print("<");

			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i]);
				if (i < data.length - 1) {
					System.out.print(", ");
				}
			}

			System.out.print(">");

			bw.flush();
			bw.close();
			br.close();

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}