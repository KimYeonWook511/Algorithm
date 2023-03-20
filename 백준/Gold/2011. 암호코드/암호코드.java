import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String input = br.readLine();
		int dp[] = new int[input.length() + 2];
		dp[0] = 1;
		dp[1] = 1;
		int num = input.charAt(0) - '0';
		
		bw.write(Integer.toString(num == 0 ? 0 : cal(input, dp)));
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	static int cal(String input, int dp[]) {
		for (int i = 2; i <= input.length(); i++) {
			int num = input.charAt(i - 1) - '0';
			
			if (num == 0) {
				num = input.charAt(i - 2) - '0';
				
				if (num == 0 || num >= 3) return 0;
				
				dp[i] += dp[i - 2];
				
			} else if (num <= 6) {
				num = input.charAt(i - 2) - '0';
				
				if (num == 1 || num == 2) dp[i] += dp[i - 2]; // 11, 21
				
				dp[i] += dp[i - 1];
				
				
			} else if (num >= 7) {
				num = input.charAt(i - 2) - '0';
				
				if (num == 1) dp[i] += dp[i - 2]; // 17, 18, 19
				
				dp[i] += dp[i - 1];
					
			}
			
			dp[i] %= 1_000_000;
		}
		
		return dp[input.length()];
	}
}