import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int[][] distance;
    static StringTokenizer token;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, -1, 0, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1); // Arrays.fill -> 행의 모든 값을 지정한 값으로 바꿔줌
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append(0 + " ");
                } else if (distance[i][j] == -1) {
                    sb.append(-1 + " ");
                } else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int x, int y) {
        queue.add(new Point(x, y));
        visited[x][y] = true;
        distance[x][y] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
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
                distance[nextX][nextY] = distance[now.x][now.y] + 1;
            }
        }
    }
}
