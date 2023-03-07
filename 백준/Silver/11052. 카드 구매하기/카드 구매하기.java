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
		int p[] = new int[n + 1];
		int dp[][] = new int[n + 1][n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int run = 1; run <= n; run++) {
			p[run] = Integer.parseInt(st.nextToken()); 
		}
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				if (r - c < 0) dp[r][c] = dp[r][c - 1];
				else dp[r][c] = Math.max(dp[r][c - 1], dp[r - c][n] + p[c]); 
			}
		}
		
		bw.write(Integer.toString(dp[n][n]));
		bw.flush();

		br.close();
		bw.close();
	}
}