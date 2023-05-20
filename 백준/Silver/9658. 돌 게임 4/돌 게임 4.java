import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		boolean dp[] = new boolean[n + 5];
		
		dp[2] = dp[4] = true;
		
		for (int i = 5; i <= n; i++) {
			dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
		}
		
		System.out.println(dp[n] ? "SK" : "CY");

		br.close();
	}
}