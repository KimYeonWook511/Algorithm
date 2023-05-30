import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int k[] = new int[n + 1];
		int s[] = new int[n + 1];
		int dp[][] = new int[t + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			k[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r <= t; r++) {
			for (int c = 1; c <= n; c++) {
				if (r >= k[c]) dp[r][c] = s[c] + dp[r - k[c]][c - 1];
				
				dp[r][c] = Math.max(dp[r][c], dp[r][c - 1]);
			}
		}
		
		System.out.println(dp[t][n]);
		
		br.close();
	}
}