import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int resultSum = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(resultSum)) {
                resultSum = sum;
                resultLeft = arr[left];
                resultRight = arr[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(resultLeft + " " + resultRight);

    }
}
