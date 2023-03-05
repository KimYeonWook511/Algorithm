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
		int dp[][] = new int[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int r = 2; r <= 40; r++) {
			dp[r][0] = dp[r - 1][0] + dp[r - 2][0];
			dp[r][1] = dp[r - 1][1] + dp[r - 2][1];
		}
		
		for (int run = 0; run < t; run++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n][0] + " " + dp[n][1] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}