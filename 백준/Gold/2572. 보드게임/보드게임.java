import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int next;
		char color;
		
		Edge(int next, char color) {
			this.next = next;
			this.color = color;
		}
	}
	
	static int N, M, K;
	static char card[];
	static List<Edge> graph[];
	static int dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		card = new char[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = st.nextToken().charAt(0);
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[M + 1];
		dp = new int[N][M + 1];
		
		for (int i = 1; i <= M; i++) {
			graph[i] = new ArrayList<>();
			
			for (int k = 0; k < N; k++) {
				dp[k][i] = -1;
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			char color = st.nextToken().charAt(0); 
			
			graph[a].add(new Edge(b, color));
			graph[b].add(new Edge(a, color));
		}
		
		System.out.println(func(0, 1));
		
		br.close();
	}
	
	static int func(int cnt, int cur) {
		if (cnt == N) return 0;
		
		if (dp[cnt][cur] != -1) return dp[cnt][cur];
		
		dp[cnt][cur] = 0;
		
		for (Edge e : graph[cur]) {
			dp[cnt][cur] = Math.max(dp[cnt][cur], func(cnt + 1, e.next) + (e.color == card[cnt] ? 10 : 0));
		}
		
		return dp[cnt][cur];
	}
}