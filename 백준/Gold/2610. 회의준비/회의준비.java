import java.io.*;
import java.util.*;

public class Main {
	static int parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int graph[][] = new int[N + 1][N + 1];
		int min[][] = new int[N + 1][2];
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			min[i][1] = Integer.MAX_VALUE;
			
			for (int k = 1; k <= N; k++) {
				graph[i][k] = Integer.MAX_VALUE;
			}
		}
		
		int K = N;
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
			
			if (union(a, b)) K--;
		}
		
		sb.append(K).append("\n");
		
		for (int m = 1; m <= N; m++) {
			for (int s = 1; s <= N; s++) {
				if (graph[s][m] == Integer.MAX_VALUE) continue;
				if (find(s) != find(m)) continue;
				
				for (int e = 1; e <= N; e++) {
					if (s == e) continue;
					if (graph[m][e] == Integer.MAX_VALUE) continue;
					if (find(s) != find(e)) continue;
					
					graph[s][e] = Math.min(graph[s][e], graph[s][m] + graph[m][e]);
				}
			}
		}

		for (int r = 1; r <= N; r++) {
			int max = 0;
			
			for (int c = 1; c <= N; c++) {
				if (graph[r][c] == Integer.MAX_VALUE) continue;
				
				max = Math.max(max, graph[r][c]);
			}
			
			if (max < min[find(r)][1]) {
				min[find(r)][0] = r;
				min[find(r)][1] = max;
			}
		}
		
		int result[] = new int[K];
		int idx = 0;
		
		for (int i = 1; i <= N; i++) {
			if (find(i) == i) result[idx++] = min[i][0];
		}
		
		Arrays.sort(result);

		for (int i = 0; i < K; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		if (x < y) parent[y] = x;
		else parent[x] = y;
		
		return true;
	}
}