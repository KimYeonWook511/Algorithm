import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		long dp[][] = new long[h][w];
		for (int c = 0; c < w; c++) {
			dp[0][c] = 1;
		}
		
		for (int r = 1; r < h; r++) {
			dp[r][0] = 1;
			
			for (int c = 1; c < w; c++) {
				dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % MOD;
			}
		}
		
		System.out.println((dp[y - 1][x - 1] * dp[h - y][w - x]) % MOD);

		br.close();
	}
}