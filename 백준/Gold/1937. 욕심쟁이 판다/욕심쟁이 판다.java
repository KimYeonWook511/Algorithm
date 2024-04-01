import java.io.*;
import java.util.*;

public class Main {
	static int n, arr[][], dp[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < n; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
		int max = 0;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (dp[r][c] == 0) dfs(r, c);
				
				max = Math.max(max, dp[r][c]);
			}
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	static int dfs(int r, int c) {
		if (dp[r][c] > 0) return dp[r][c];
		
		dp[r][c] = 1;
		
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if (nr < 0 || nc < 0) continue;
			if (nr >= n || nc >= n) continue;
			if (arr[nr][nc] >= arr[r][c]) continue;
			
			dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
		}
		
		return dp[r][c];
	}
}