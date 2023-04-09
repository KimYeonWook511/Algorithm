import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		long dp[][] = new long[31][33];
		
		for (int c = 2; c <= 31; c++) {
			dp[0][c] = 1;
		}
		
		for (int r = 1; r <= 30; r++) {
			for (int c = 1; c <= 31; c++) {
				dp[r][c] = dp[r][c - 1] + dp[r - 1][c + 1];
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) break;
			
			bw.write(dp[n - 1][2] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}