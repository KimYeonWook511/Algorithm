import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = 0;
		int T = 1;
		
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int arr[][] = new int[N][N];
			int dp[][] = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					dp[r][c] = Integer.MAX_VALUE;
				}
			}
			
			Deque<int[]> deque = new ArrayDeque<>();
			deque.offer(new int[] {0, 0});
			dp[0][0] = arr[0][0];
			
			while (!deque.isEmpty()) {
				int cur[] = deque.poll();
				
				int nr, nc;
				for (int d = 0; d < 4; d++) {
					nr = cur[0] + dr[d];
					nc = cur[1] + dc[d];
					
					if (nr < 0 || nc < 0) continue;
					if (nr >= N || nc >= N) continue;
					if (dp[nr][nc] <= dp[cur[0]][cur[1]] + arr[nr][nc]) continue;
					
					dp[nr][nc] = dp[cur[0]][cur[1]] + arr[nr][nc];
					deque.offer(new int[] {nr, nc});
				}
			}
			
			sb.append("Problem ").append(T++).append(": ").append(dp[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}