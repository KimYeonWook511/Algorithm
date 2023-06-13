import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[11];
		dp[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + i - 1;
		}
		
		System.out.println(dp[n]);
		
		br.close();
	}
}