import java.io.*;

public class Main {
	static final int MOD = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[N + 1][21]; // 2^20 = 1,048,576
		dp[1][0] = 1;
		
		for (int r = 2; r <= N; r++) {
			int pow = 0;
			for (int c = 20; c >= 0; c--) {
				pow = 1 << c;
				
				if (r < pow) continue;
				if (r == pow) {
					dp[r][c] = 1;
					continue;
				}
				
				dp[r][c] = (dp[r][c + 1] + dp[r - pow][c]) % MOD;
			}
		}
		
		System.out.println(dp[N][0]);
		
		br.close();
	}
}