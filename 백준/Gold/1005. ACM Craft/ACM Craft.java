import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < T; run++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			List<Integer> graph[] = new ArrayList[N + 1];
			int val[] = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
				
				val[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt[] = new int[N + 1];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				graph[A].add(B);
				cnt[B]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();
			
			for (int i = 1; i <= N; i++) {
				if (cnt[i] == 0) deque.offer(i);
			}
			
			int dp[] = new int[N + 1];
			while (!deque.isEmpty()) {
				int cur = deque.poll();
				
				for (int next : graph[cur]) {
					dp[next] = Math.max(dp[next], val[cur]);
					
					if (--cnt[next] == 0) {
						val[next] += dp[next];
						deque.offer(next);
					}
				}
			}
			
			sb.append(val[W]).append("\n");
		}

		System.out.println(sb);
		
		br.close();
	}
}