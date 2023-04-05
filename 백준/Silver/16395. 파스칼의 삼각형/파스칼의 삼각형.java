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
		int k = Integer.parseInt(st.nextToken());
		int dp[][] = new int[n + 1][31];
		
		for (int r = 0; r <= n; r++) {
			dp[r][0] = 1;
			
			for (int c = 1; c <= r; c++) {
				dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
			}
		}
		
		bw.write(Integer.toString(dp[n - 1][k - 1]));
		bw.flush();

		br.close();
		bw.close();
	}
}