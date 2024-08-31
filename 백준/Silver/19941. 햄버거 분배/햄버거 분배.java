import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        char[] table = br.readLine().toCharArray();
        int people = 0;
        boolean[] eat = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                int firstIndex = Math.max(i - K, 0); // 범위 내에서 가장 멀리 떨어진 햄버거 찾기(왼쪽)
                int lastIndex = Math.min(i + K, N - 1);// 범위 내에서 가장 멀리 떨어진 햄버거 찾기(왼쪽)
                for (int j = firstIndex; j <= lastIndex; j++) {
                    if (table[j] == 'H' && !eat[j]) { // 햄버거를 찾으면(이미 먹은 햄버거가 아니면)
                        eat[j] = true; // 먹었다고 표시
                        people++; // 먹은 사람 증가
                        break;
                    }
                }
            }
        }


        bw.write(people + "");
        bw.close();
        br.close();

    }
}