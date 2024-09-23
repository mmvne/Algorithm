import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int score = Integer.parseInt(token.nextToken());
        int p = Integer.parseInt(token.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        token = new StringTokenizer(br.readLine());
        ArrayList<Integer> ranking = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ranking.add(Integer.parseInt(token.nextToken()));
        }

        int rank = 1;

        if (ranking.size() == p && score <= ranking.get(ranking.size() - 1)) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (score >= ranking.get(i)) {
                rank = i + 1;
                break;
            } else {
                rank++;
            }
        }

        if (rank <= p) {
            System.out.println(rank);
        } else {
            System.out.println(-1);
        }

    }
}