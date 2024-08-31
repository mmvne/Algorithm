import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken()); // 정점의 개수
        M = Integer.parseInt(token.nextToken()); // 간선의 개수
        V = Integer.parseInt(token.nextToken()); // 탐색 시작 정점

        arr = new int[N + 1][N + 1]; // 연결을 기록하기 위한 배열
        visited = new boolean[N + 1]; // 방문을 기록하기 위한 배열

        for (int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 간선 연결 정점
            int b = Integer.parseInt(st.nextToken()); // 간선 연결 정점

            arr[a][b] = 1; // 2차원 배열에 서로 연결이 된 경우 1로 표시
            arr[b][a] = 1;
        }

        dfs(V);
        sb.append('\n');
        visited = new boolean[N + 1]; // 초기화 안하면 그대로 남아있음

        bfs(V);

        System.out.println(sb);
    }

    // 깊이 우선 탐색 -> stack, 재귀함수 사용
    private static void dfs(int start) {
        visited[start] = true; // 방문한 경우 true
        sb.append(start + " "); // 방문 시 방문한 정점 출력

        for(int i = 0; i < N + 1 ; i++){
            // 1일경우 -> 연결이 되어 있으니 탐색 && 방문한 적이 없을 경우 탐색
            // 다시 start 값에 i 값을 넣어서 위에서 부터 탐색
            if(arr[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }
    }

    // 너비우선탐색 -> queue 사용
    private static void bfs(int start) {
        queue.add(start); // 우선 처음 값을 큐에 넣고
        visited[start] = true; // 방문한 경우 true

        while (!queue.isEmpty()){
            start = queue.poll();
            sb.append(start + " "); // 넣은 값을 빼고

            // 뺀 값과 연결된 정점을 다시 큐에 넣어줌 그리고 방문했으니 true
            for(int i = 0; i < N + 1 ; i++){
                if(arr[start][i] == 1 && visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}