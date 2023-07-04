import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deque = new LinkedList<>();
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			deque.offer(i);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < m; run++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = deque.indexOf(num);
			
			if (idx <= deque.size() / 2) { // 2번
				sum += idx;
				
				for (int i = 0; i < idx; i++) {
					deque.offerLast(deque.pollFirst());
				}
				
				deque.pollFirst(); // 1번
				
			} else { // 3번
				sum += deque.size() - idx;
				
				for (int i = deque.size() - 1; i > idx; i--) {
					deque.offerFirst(deque.pollLast());
				}
				
				deque.pollLast(); // 1번
			}
		}
		
		bw.write(Integer.toString(sum));
		
		br.close();
		bw.close();
	}
}