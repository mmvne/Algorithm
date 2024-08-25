import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String key = br.readLine();
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, i);
            } else {
                map.put(key, i);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(Comparator.comparingInt(map::get));

        // 수강신청 학생이 더 작을수도 있으니 최소값 설정
        for (int i = 0; i < Math.min(K, list.size()); i++) { 
            bw.write(list.get(i));
            bw.newLine(); // '/n' 이랑 같음
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
