import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[n];
		long dp[][] = new long[n][21];
		
		for (int i = 1; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][num[1]] = 1;
		
		for (int r = 2; r < n; r++) {
			for (int c = 0; c <= 20; c++) {
				if (dp[r - 1][c] > 0) {
					int plus = c + num[r];
					int minus = c - num[r];
					
					if (plus <= 20) dp[r][plus] += dp[r - 1][c]; 
					if (minus >= 0) dp[r][minus] += dp[r - 1][c];
				}
			}
		}
		
		bw.write(Long.toString(dp[n - 1][Integer.parseInt(st.nextToken())]));
		bw.flush();

		br.close();
		bw.close();
	}
}