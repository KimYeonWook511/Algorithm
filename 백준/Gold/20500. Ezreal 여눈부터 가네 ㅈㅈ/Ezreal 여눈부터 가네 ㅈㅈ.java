import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[N + 2][3];
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for (int i = 3; i <= N; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}
		
		System.out.println(dp[N][0]);
		
		br.close();
	}
}