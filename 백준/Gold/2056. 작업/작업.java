import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> graph[] = new ArrayList[N + 1];
		int T[] = new int[N + 1];
		int cnt[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			
			graph[i] = new ArrayList<>();
			int K = Integer.parseInt(st.nextToken());
			cnt[i] = K;
			
			for (int k = 0; k < K; k++) {
				graph[Integer.parseInt(st.nextToken())].add(i);
			}
		}

		Deque<Integer> deque = new ArrayDeque<>();
		int dp[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) deque.offer(i);
		}
		
		int result = 0;
		
		while (!deque.isEmpty()) {
			int cur = deque.poll();
			
			dp[cur] += T[cur];
			result = Math.max(result, dp[cur]);
			
			for (int next : graph[cur]) {
				dp[next] = Math.max(dp[next], dp[cur]);
				
				if (--cnt[next] == 0) deque.offer(next);
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}