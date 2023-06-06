import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[51];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1] + 1) % MOD;
		}
		
		System.out.println(dp[n]);
		
		br.close();
	}
}