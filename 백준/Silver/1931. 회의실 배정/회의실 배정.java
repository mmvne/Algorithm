import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for (int i = 0; i < meeting.length; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < meeting[i].length; j++) {
                meeting[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        // 회의 종료 시간이 같다면 시작시간이 빠른순으로 정렬
        Arrays.sort(meeting, (o1, o2) -> {
            // 회의 종료시간이 같다면
            if (o1[1] == o2[1]) {
                // 회의 시작시간 기준으로 정렬
                return Integer.compare(o1[0], o2[0]);
            } else {
                // 아니면 회의 종료시간 기준으로 정렬
                return Integer.compare(o1[1], o2[1]);
            }
        });

        /*
        for (int i = 0; i < meeting.length; i++) {
            for (int j = 0; j < meeting[i].length; j++) {
                System.out.print(meeting[i][j] + " ");
            }
            System.out.println();
        }
        */

        int count = 1;
        int endTime = meeting[0][1];

        for (int i = 1; i < meeting.length; i++) {
            if (meeting[i][0] >= endTime) {
                count++;
                endTime = meeting[i][1];
            }
        }

        sb.append(count);
        System.out.println(sb);

    }
}