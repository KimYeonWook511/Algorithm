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
		int dp[] = new int[1_000_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 1000000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_009;
			dp[i] = (dp[i] + dp[i - 3]) % 1_000_000_009;
		}
		
		for (int run = 0; run < t; run++) {
			bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}