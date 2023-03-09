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
		int dp[][] = new int[n + 1][11];
		int result = 0;
		
		dp[1][0] = 1;
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= 10; c++) {
				dp[r][c] = (dp[r][c - 1] + dp[r - 1][c]) % 10007;
			}
		}
		
		for (int c = 1; c <= 10; c++) {
			result = (result + dp[n][c]) % 10007;
		}
		
		bw.write(Integer.toString(result));
		bw.flush();

		br.close();
		bw.close();
	}
}