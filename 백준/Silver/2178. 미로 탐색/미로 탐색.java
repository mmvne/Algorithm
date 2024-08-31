import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1 ,0}; // 하, 우, 상, 좌
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write(map[N-1][M-1] + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(int x, int y) {
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue; // 맵을 벗어난 경우
                }
                if (map[nextX][nextY] == 0) {
                    continue; // 갈 수 없는 땅인 경우
                }
                if (visited[nextX][nextY]) {
                    continue; // 이미 방문한 경우
                }
                queue.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                map[nextX][nextY] = map[now.x][now.y] + 1;
            }
        }
    }
}
