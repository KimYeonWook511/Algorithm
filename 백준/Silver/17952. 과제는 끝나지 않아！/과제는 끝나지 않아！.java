import java.io.*;
import java.util.*;

public class Main {
	static class Work {
		int A, T;
		
		Work(int A, int T) {
			this.A = A;
			this.T = T;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Deque<Work> deque = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		Work cur;
		int sum = 0;
		
		for (int run = 0; run < N; run++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 0) {
				if (deque.isEmpty()) continue;
				
				cur = deque.pollLast();
				
				if (--cur.T == 0) {
					sum += cur.A;
					continue;
				}
				
				deque.offerLast(cur);
				continue;
			}
			
			int A = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken()) - 1;
			
			if (T != 0) {
				deque.offerLast(new Work(A, T));
				continue;
			}
				
			sum += A;
		}
		
		System.out.println(sum);
		
		br.close();
	}
}