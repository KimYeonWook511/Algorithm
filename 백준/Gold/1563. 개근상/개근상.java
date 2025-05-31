import java.io.*;

public class Main {
	static final int MOD = 1_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[N + 1][2][3];
		dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
		
        for (int i = 2; i <= N; i++) {
			dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
			dp[i][0][1] = (dp[i - 1][0][0]) % MOD;
			dp[i][0][2] = (dp[i - 1][0][1]) % MOD;
			
			dp[i][1][0] = (dp[i][0][0] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
			dp[i][1][1] = (dp[i - 1][1][0]) % MOD;
			dp[i][1][2] = (dp[i - 1][1][1]) % MOD;
		}

        System.out.println((dp[N][0][0] + dp[N][0][1] + dp[N][0][2] + dp[N][1][0] + dp[N][1][1] + dp[N][1][2]) % MOD);
        
		br.close();
	}
}