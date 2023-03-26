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

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp[][] = new int[n + 1][m + 1];
		dp[1][0] = 1;
		
		if (k == 0) {
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= m; c++) {
					dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
				}
			}
			
		} else {
			for (int r = 1; r <= (k - 1) / m + 1; r++) {
				for (int c = 1; c <= (k - 1) % m + 1; c++) {
					dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
				}
			}
				
			for (int r = (k - 1) / m + 1; r <= n; r++) {
				for (int c = (k - 1) % m + 1; c <= m; c++) {
					dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
				}
			}
		}
		
		bw.write(Integer.toString(dp[n][m]));
		bw.flush();

		br.close();
		bw.close();
	}
}