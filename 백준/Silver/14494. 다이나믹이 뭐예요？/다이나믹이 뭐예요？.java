import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int dp[][] = new int[n + 1][m + 1];
		
		dp[0][0] = 1;
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % MOD;
				dp[r][c] = (dp[r][c] + dp[r - 1][c - 1]) % MOD;
			}
		}
		
		System.out.println(dp[n][m]);
		
		br.close();
	}
}