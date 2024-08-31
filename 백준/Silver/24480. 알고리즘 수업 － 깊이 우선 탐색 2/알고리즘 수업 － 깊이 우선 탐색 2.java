import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer token;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited; // 방문한 정점 기록용 배열
    static int count; // 방문 순서

    public static void main(String[] args) throws IOException {
        token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken()); // 정점의 수
        int M = Integer.parseInt(token.nextToken()); // 간선의 수
        int R = Integer.parseInt(token.nextToken()); // 시작 정점

        visited = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int fromVer = Integer.parseInt(token.nextToken()); // 간선 정보
            int toVer = Integer.parseInt(token.nextToken());

            graph.get(fromVer).add(toVer); // 간선 정보 인접리스트에 넣기
            graph.get(toVer).add(fromVer);
        }

        // 내림차순 정렬 작업
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        // 방문 순서 1부터 시작
        count = 1;

        dfs(R);

        // 방문한 정점 배열에 담긴 순서 출력
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append(" ");
        }

        System.out.println(sb);

    }

    private static void dfs(int start) {
        // 정점 방문 시 순서 저장
        visited[start] = count;

        // 정점에 연결된 간선 정보 만큼 순회
        for (int i = 0; i < graph.get(start).size(); i++) {
            // 방문한적이 없는 정점이라면 순서를 증가시키고 방문
            int vertex = graph.get(start).get(i);
            if (visited[vertex] == 0) {
                count++;
                dfs(vertex);
            }
        }

    }
}