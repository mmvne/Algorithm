import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        try {
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {

                String str = br.readLine();
                int count = 0;
                int max;
                StringTokenizer stringTokenizer = new StringTokenizer(str);
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int M = Integer.parseInt(stringTokenizer.nextToken());

                Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
                Deque<Integer> deque = new ArrayDeque<>();
                Deque<Integer> indexDeque = new ArrayDeque<>();

                String document = br.readLine();
                StringTokenizer token = new StringTokenizer(document);

                for (int j = 0; j < N; j++) {
                    int index = Integer.parseInt(token.nextToken());
                    deque.add(index);
                    queue.add(index);
                    indexDeque.add(j);
                }

                while (!deque.isEmpty()) {
                    max = queue.peek();

                    if (deque.peek() == max) {
                        if (indexDeque.poll() == M) {
                            count++;
                            break;
                        }
                        deque.poll();
                        queue.poll();
                        count++;
                    } else {
                        deque.add(deque.poll());
                        indexDeque.add(indexDeque.poll());
                    }
                }
                bw.write(String.valueOf(count) + '\n');

            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
