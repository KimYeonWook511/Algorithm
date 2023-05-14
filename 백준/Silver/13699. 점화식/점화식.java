import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		long dp[] = new long[n + 1];
		dp[0] = 1;
		
		for (int run = 1; run <= n; run++) {
			int m = run / 2;
			
			for (int i = 0; i < m; i++) {
				dp[run] += dp[i] * dp[run - i - 1] * 2;
			}
			
			if (run % 2 != 0) dp[run] += dp[m] * dp[m];
		}
		
		System.out.println(dp[n]);
		
		br.close();
	}
}