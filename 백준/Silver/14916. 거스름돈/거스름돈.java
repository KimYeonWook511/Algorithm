import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n + 6];
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		
		for (int i = 6; i <= n; i++) {
			if (dp[i - 2] == 0 && dp[i - 5] == 0) {
				continue;
				
			} else if (dp[i - 2] == 0) {
				dp[i] = dp[i - 5] + 1;
				
			} else if (dp[i - 5] == 0) {
				dp[i] = dp[i - 2] + 1;
				
			} else {
				dp[i] = Math.min(dp[i - 5], dp[i - 2]) + 1;
			}
		}
		
		bw.write(Integer.toString(dp[n] == 0 ? -1 : dp[n]));
		bw.flush();

		br.close();
		bw.close();
	}
}