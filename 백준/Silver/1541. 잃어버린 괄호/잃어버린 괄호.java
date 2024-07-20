import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] num = br.readLine().split("-");

        List<Integer> resultList = new ArrayList<>();

        for (String s : num) {
            int sum = 0;
            if (s.contains("+")) {
                String[] splitStr = s.split("\\+");
                for (String split : splitStr) {
                    sum += Integer.parseInt(split);
                }
            } else {
                sum = Integer.parseInt(s);
            }
            resultList.add(sum);
        }


        int result = resultList.get(0);

        for (int i = 1; i < resultList.size(); i++) {
            result = result - resultList.get(i);
        }

        sb.append(result);
        System.out.println(sb);

    }

}