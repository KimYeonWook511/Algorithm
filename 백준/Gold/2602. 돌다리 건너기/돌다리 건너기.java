import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		String devil = br.readLine();
		String angel = br.readLine();
		int dp[][][] = new int[2][str.length()][devil.length()];
		
		dp[0][0][0] = str.charAt(0) == devil.charAt(0) ? 1 : 0;
		dp[1][0][0] = str.charAt(0) == angel.charAt(0) ? 1 : 0;
		
		for (int c = 1; c < devil.length(); c++) {
			dp[0][0][c] = dp[0][0][c - 1];
			dp[1][0][c] = dp[1][0][c - 1];
			
			if (str.charAt(0) == devil.charAt(c)) dp[0][0][c]++;
			if (str.charAt(0) == angel.charAt(c)) dp[1][0][c]++;
		}
		
		for (int r = 1; r < str.length(); r++) {
			if (r % 2 == 0) {
				for (int c = r; c < devil.length(); c++) {
					dp[0][r][c] = dp[0][r][c - 1];
					dp[1][r][c] = dp[1][r][c - 1];
					
					if (str.charAt(r) == devil.charAt(c)) dp[0][r][c] += dp[0][r - 1][c - 1];
					if (str.charAt(r) == angel.charAt(c)) dp[1][r][c] += dp[1][r - 1][c - 1];
				}
				
			} else {
				for (int c = r; c < devil.length(); c++) {
					dp[0][r][c] = dp[0][r][c - 1];
					dp[1][r][c] = dp[1][r][c - 1];
					
					if (str.charAt(r) == angel.charAt(c)) dp[0][r][c] += dp[0][r - 1][c - 1];
					if (str.charAt(r) == devil.charAt(c)) dp[1][r][c] += dp[1][r - 1][c - 1];
				}
			}
		}
		
		System.out.println(dp[0][str.length() - 1][devil.length() - 1] + dp[1][str.length() - 1][devil.length() - 1]);
		
		br.close();
	}
}