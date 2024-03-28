import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 1_000_000_001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[n + 1][n + 1];
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (r == c) continue;
				
				dp[r][c] = MAX;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dp[a][b] = Math.min(dp[a][b], Integer.parseInt(st.nextToken()));
		}
		
		for (int mid = 1; mid <= n; mid++) {
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= n; c++) {
					if (r == c) continue;
					
					dp[r][c] = Math.min(dp[r][c], dp[r][mid] + dp[mid][c]);
				}
			}
		}

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				sb.append(dp[r][c] == MAX ? "0" : dp[r][c]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}