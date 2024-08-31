import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] minute = new int[N];
        int[] sum = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < minute.length; i++) {
            minute[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(minute);

        sum[0] = minute[0];
        int count = minute[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = minute[i] + sum[i-1];
            count = count + sum[i];
        }

        sb.append(count);

        System.out.println(sb);
    }
}