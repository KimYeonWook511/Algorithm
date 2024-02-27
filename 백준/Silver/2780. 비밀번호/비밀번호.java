import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int MOD = 1234567;
		
		int pad[][] = {{7}, {2, 4}, {1, 3, 5}, {2, 6}, {1, 5, 7}, {2, 4, 6, 8}, {3, 5, 9}, {4, 8, 0}, {5, 7, 9}, {6, 8}};
		int dp[][] = new int[1000][11]; // 0~999
		
		for (int c = 0; c < 10; c++) {
			dp[0][c] = 1;
		}

		dp[0][10] = 10;
		
		for (int r = 1; r < 1000; r++) {
			int sum = 0;
			
			for (int c = 0; c < 10; c++) {
				for (int num : pad[c]) {
					dp[r][c] = (dp[r][c] + dp[r - 1][num]) % MOD;
				}
				
				sum = (sum + dp[r][c]) % MOD;
			}
			
			dp[r][10] = sum;
		}
		
		for (int run = 0; run < T; run++) {
			sb.append(dp[Integer.parseInt(br.readLine()) - 1][10]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}