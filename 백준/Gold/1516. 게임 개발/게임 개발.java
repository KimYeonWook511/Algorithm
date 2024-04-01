import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt[] = new int[N + 1];
		int time[] = new int[N + 1];
		List<Integer> graph[] = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			int next = 0;
			
			while (true) {
				next = Integer.parseInt(st.nextToken());
				
				if (next == -1) break;
				
				graph[next].add(i);
				cnt[i]++;
			}
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		int max[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] != 0) continue;
			
			deque.offer(i);
			max[i] = time[i];
		}
		
		while (!deque.isEmpty()) {
			int cur = deque.poll();
			
			for (int next : graph[cur]) {
				max[next] = Math.max(max[next], time[next] + max[cur]);
				
				if (--cnt[next] != 0) continue;
				
				deque.offer(next);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(max[i]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}