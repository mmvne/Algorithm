import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;


        while (N > 0) {
            if (N % 5 == 0) {
                count = count + N / 5;
                break;
            } else {
                N = N - 3;
                count++;
            }
            if(N < 0) {
                count = -1;
            }

        }


        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();

    }
}