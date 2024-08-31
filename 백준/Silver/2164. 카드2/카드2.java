import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	//2164 카드2
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> queue = new ArrayDeque<>();

		
		try {
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				queue.add(i);
			}
			
			while(true) {
				
                if(queue.size() == 1) {
					break;
				}
                
                queue.poll();
				queue.add(queue.poll());
				
			}
			
			System.out.println(queue.peek());
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}