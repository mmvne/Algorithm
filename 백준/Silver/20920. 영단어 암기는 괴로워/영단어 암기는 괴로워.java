import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                Integer count = map.getOrDefault(str, 0);
                map.put(str, count + 1); // 한번 더 나올시 count 증가
            }
        }

        List<String> strList = map.keySet().stream().collect(Collectors.toList()); // 키값 뽑아서 리스트로 변환

        strList.sort((o1, o2) -> {

            if (map.get(o1) == map.get(o2)) { // count 가 같을 경우
                if (o1.length() == o2.length()) { // 문자열 길이가 같을 경우
                    return o1.compareTo(o2); // 단어 순서대로
                } else { // 문자열 길이가 같지 않을 경우
                  return o2.length() - o1.length(); // 길이가 긴 순서대로
                }
            } else { // count 가 같지 않을 경우
                return  map.get(o2) - map.get(o1); // count가 높은 문자열부터 출력
            }
        });

        for (String s : strList) {
            bw.write(s + '\n');
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
