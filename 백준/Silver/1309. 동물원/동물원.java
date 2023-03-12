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
		int dp[][] = new int[n][2];
		dp[0][0] = 2; // ox, xo
		dp[0][1] = 1; // xx
		
		for (int r = 1; r < n; r++) {
			dp[r][1] = (dp[r - 1][0] + dp[r - 1][1]) % 9901;
			dp[r][0] = (dp[r - 1][1] + dp[r][1]) % 9901;
		}
		
		bw.write(Integer.toString((dp[n - 1][0] + dp[n - 1][1]) % 9901));
		bw.flush();

		br.close();
		bw.close();
	}
}