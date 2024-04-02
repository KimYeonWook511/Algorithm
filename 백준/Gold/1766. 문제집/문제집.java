import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> graph[] = new ArrayList[N + 1];
		int cnt[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			cnt[B]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) pq.offer(i);
		}
		
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			
			sb.append(cur).append(" ");
			
			for (int next : graph[cur]) {
				if (--cnt[next] != 0) continue;
				
				pq.offer(next);
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}