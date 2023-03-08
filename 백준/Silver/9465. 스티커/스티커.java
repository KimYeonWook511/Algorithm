import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			int sticker[][] = new int[2][n + 1];
			int dp[][] = new int[2][n + 1];

			for (int r = 0; r < 2; r++) {
				st = new StringTokenizer(br.readLine());

				for (int i = 1; i <= n; i++) {
					sticker[r][i] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];

			for (int c = 2; c <= n; c++) {
				dp[1][c] = Math.max(dp[0][c - 1], dp[0][c - 2]) + sticker[1][c];
				dp[0][c] = Math.max(dp[1][c - 1], dp[1][c - 2]) + sticker[0][c];
			}
			
			bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
			
			t--;
		}

		bw.flush();

		br.close();
		bw.close();
	}
}