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
		long dp[] = new long[n + 1];
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		bw.write(Long.toString(dp[n] * 4 + dp[n - 1] * 2));
		bw.flush();

		br.close();
		bw.close();
	}
}