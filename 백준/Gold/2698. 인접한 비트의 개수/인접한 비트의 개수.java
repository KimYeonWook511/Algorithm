import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int dp[][] = new int[101][101];
		dp[0][0] = 1;
		dp[1][0] = 2;
		
		for (int r = 2; r <= 100; r++) {
			dp[r][0] = dp[r - 1][0] + dp[r - 2][0];
			
			for (int c = 1; c < r; c++) {
				dp[r][c] = dp[r - 1][c] + dp[r - 2][c] + dp[r - 1][c - 1] - dp[r - 2][c - 1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			sb.append(dp[n][k]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}