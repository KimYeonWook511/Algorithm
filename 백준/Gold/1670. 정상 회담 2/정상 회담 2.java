import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[10001];
		dp[0] = dp[2] = 1;
		
		for (int i = 4; i <= N; i += 2) {
			for (int k = 0; k <= i - 2; k += 2) {
				dp[i] += dp[k] * dp[i - k - 2];
				dp[i] %= MOD;
			}
		}
		
		System.out.println(dp[N]);
		
		br.close();
	}
}