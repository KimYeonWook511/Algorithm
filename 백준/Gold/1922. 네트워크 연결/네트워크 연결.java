import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int graph[][] = new int[N + 1][N + 1];
		boolean chk[] = new boolean[N + 1];
		int minC[] = new int[N + 1];

		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a][b] = graph[b][a] = c;
		}

		for (int i = 1; i <= N; i++) {
			minC[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		minC[1] = 0;
		pq.offer(new int[]{1, 0});

		int cnt = N;
		int sum = 0;

		while (!pq.isEmpty()) {
			int cur[] = pq.poll();

			if (chk[cur[0]]) continue;

			chk[cur[0]] = true;
			sum += cur[1];

			if (--cnt == 0) break;

			for (int next = 1; next <= N; next++) {
				if (chk[next]) continue;
				if (graph[cur[0]][next] == 0) continue;
				if (minC[next] <= graph[cur[0]][next]) continue;

				minC[next] = graph[cur[0]][next];
				pq.offer(new int[]{next, minC[next]});
			}
		}	

		System.out.println(sum);

		br.close();
	}
}