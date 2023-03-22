import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		int dp[][] = new int[100001][3];
		
		dp[1][0] = dp[2][1] = dp[3][0] = dp[3][1] = dp[3][2] = 1;
		
		for (int r = 4; r <= 100000; r++) {
			dp[r][0] = (dp[r - 1][1] + dp[r - 1][2]) % 1_000_000_009;
			dp[r][1] = (dp[r - 2][0] + dp[r - 2][2]) % 1_000_000_009;
			dp[r][2] = (dp[r - 3][0] + dp[r - 3][1]) % 1_000_000_009;
		}
		
		for (int run = 0; run < t; run++) {
			int n = Integer.parseInt(br.readLine());
			int result = (dp[n][0] + dp[n][1]) % 1_000_000_009;
			
			bw.write((result + dp[n][2]) % 1_000_000_009 + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}