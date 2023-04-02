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
		boolean dp[] = new boolean[n + 3];
		
		dp[1] = dp[3] = true;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
		}
		
		bw.write(dp[n] ? "SK" : "CY");
		bw.flush();

		br.close();
		bw.close();
	}
}