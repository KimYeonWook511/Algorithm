import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w[] = new int[n];
			
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>(); 
			
			for (int i = 0; i < n; i++) {
				w[i] = Integer.parseInt(st.nextToken());
				q.offer(w[i]);
			}
			
			Arrays.sort(w);
			int wIdx = n - 1;
			
			while (true) {
				while (w[wIdx] != q.peek()) {
					q.offer(q.poll());
					
					if (m == 0) m = q.size() - 1;
					else m--;
				}
				
				if (m == 0 && q.peek() == w[wIdx]) {
					bw.write(n - q.size() + 1 + "\n");
					break;
				}
				
				q.poll();
				wIdx--;
				m--;
			}
		}
		
		br.close();
		bw.close();
	}
}
