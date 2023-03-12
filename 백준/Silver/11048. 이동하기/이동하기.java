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
		int maze[][] = new int[n + 1][m + 1];
		int dp[][] = new int[n + 1][m + 1];
		
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= m; c++) { 
				maze[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]) + maze[r][c];
			}
		}
		
		bw.write(Integer.toString(dp[n][m]));
		bw.flush();

		br.close();
		bw.close();
	}
}