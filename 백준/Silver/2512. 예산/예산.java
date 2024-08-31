import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] money = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(token.nextToken()); 
        }

        int M = Integer.parseInt(br.readLine());
        Arrays.sort(money);

        int left = 0;
        int right = money[N - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (money[i] > mid) {
                    sum += mid;
                } else {
                    sum += money[i];
                }
            }
            if(sum <= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        sb.append(right);
        System.out.println(sb);

    }
}
