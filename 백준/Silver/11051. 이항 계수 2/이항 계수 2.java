import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[][] dp = new int[N + 1][N + 1];

        /*
         * 이항계수 동적계획법
              1C0 1C1
            2C0  2C1  2C2

            2C1 = 1C0 + 1C1
         */

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
                }
            }
        }

        bw.write(dp[N][K] + "");
        bw.close();
        br.close();

    }
}



