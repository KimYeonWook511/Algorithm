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
		int dp[] = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			double sqrt = Math.sqrt(i);
			
			if (sqrt == (int)sqrt) {
				dp[i] = 1;
				
			} else {
				dp[i] = dp[i - 1] + 1;
				
				for (int k = 2; k <= sqrt; k++) {
					dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
				}
			}
		}
		
		bw.write(Integer.toString(dp[n]));
		bw.flush();

		br.close();
		bw.close();
	}
}