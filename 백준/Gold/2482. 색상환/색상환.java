import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MOD = 1_000_000_003;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int dp[][] = new int[k][n];
		
		for (int c = 0; c < n; c++) {
			dp[0][c] = c + 1;
		}
		
		for (int r = 1; r < k; r++) {
			for (int c = r * 2 + 1; c < n; c++) {
				dp[r][c] = (dp[r - 1][c - 2] + dp[r][c - 1]) % MOD;
			}
		}
		
		System.out.println(dp[k - 1][n - 1]);
		
		br.close();
	}
}