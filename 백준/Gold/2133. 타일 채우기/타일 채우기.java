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
		int dp[] = new int[n + 2];
		
		dp[2] = 3;
		
		for (int i = 4; i <= n; i += 2) {
			dp[i] += dp[i - 2] * dp[2];
			
			for (int k = 4; k < i; k += 2) {
				dp[i] += dp[i - k] * 2;
			}
			
			dp[i] += 2; // 3 * i 타일
		}
		
		bw.write(Integer.toString(dp[n]));
		bw.flush();

		br.close();
		bw.close();
	}
}