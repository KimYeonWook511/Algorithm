import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		List<Integer> graph[] = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
				
			
		int chk[] = new int[N + 1];
		int cnt = 1;
		
		pq.offer(new int[] {R, 1});
		
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			
			chk[cur[0]] = cnt++;

			for (int next : graph[cur[0]]) {
				if (chk[next] != 0) continue;
				
				pq.offer(new int[] {next, chk[cur[0]] + 1});
				chk[next] = -1;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(chk[i]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}