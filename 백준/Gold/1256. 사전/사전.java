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
		int n = Integer.parseInt(st.nextToken()) + 1;
		int m = Integer.parseInt(st.nextToken()) + 1;
		int k = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[n + 1][m + 1];
		dp[1][0] = 1;
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
				if (dp[r][c] > 1_000_000_000) dp[r][c] = 1_000_000_001;
			}
		}
		
		if (k > dp[n][m]) {
			bw.write("-1");
			
		} else {
			while (true) {
				if (n == 1 && m == 1) break;
				
				if (k <= dp[n - 1][m]) {
					bw.write("a");
					n--;
					
				} else {
					k -= dp[n - 1][m];
					bw.write("z");
					m--;
				}
			}
		}
		bw.flush();

		br.close();
		bw.close();
	}
}