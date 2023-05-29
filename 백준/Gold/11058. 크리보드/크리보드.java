import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		long buffer = 1; // 초반엔 A, 복사 이후엔 버퍼
		long dp[] = new long[n + 4];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			if (dp[i - 4] * 3 < dp[i - 1] + buffer) {
				dp[i] = dp[i - 1] + buffer;
				
			} else {
				buffer = dp[i - 4]; 
				dp[i] = buffer * 3;
			}
		}

		System.out.println(dp[n]);
		
		br.close();
	}
}