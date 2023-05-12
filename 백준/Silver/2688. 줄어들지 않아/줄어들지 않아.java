import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		long dp[][] = new long[65][10];
		
		for (int c = 0; c <= 9; c++) {
			dp[0][c] = 1;
		}
		
		for (int r = 1; r <= 64; r++) {
			dp[r][9] = 1;
			
			for (int c = 8; c >= 0; c--) {
				dp[r][c] = dp[r - 1][c] + dp[r][c + 1];
			}
		}
		
		for (int run = 0; run < t; run++) {
			System.out.println(dp[Integer.parseInt(br.readLine())][0]);
		}
		
		br.close();
	}
}