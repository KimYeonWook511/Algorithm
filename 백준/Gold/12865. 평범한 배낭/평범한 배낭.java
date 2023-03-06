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

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int w[] = new int[n + 1];
		int v[] = new int[n + 1];
		int dp[][] = new int[k + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for (int r = 1; r <= k; r++) {
			for (int c = 1; c <= n; c++) {
				if (w[c] <= r) {
					dp[r][c] = Math.max(dp[r][c - 1], v[c] + dp[r - w[c]][c - 1]); // 현재 물건을 안 넣는 경우, 넣는 경우

				} else {
					dp[r][c] = dp[r][c - 1];

				}
			}
		}

		bw.write(Integer.toString(dp[k][n]));
		bw.flush();

		br.close();
		bw.close();
	}
}