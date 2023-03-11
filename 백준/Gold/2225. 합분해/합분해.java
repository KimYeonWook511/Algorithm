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
		int dp[][] = new int[k + 1][n + 2];
		
		dp[1][0] = 1;
		
		for (int r = 1; r <= k; r++) {
			for (int c = 1; c <= n + 1; c++) { // c = 1 -> 0
				dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % 1_000_000_000;
			}
		}
		
		bw.write(Integer.toString(dp[k][n + 1]));
		bw.flush();

		br.close();
		bw.close();
	}
}