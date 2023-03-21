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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n + 1];
		int dp[][] = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r <= n; r++) {
			dp[r][0] = 10_000_001;
			
			for (int c = 1; c <= n; c++) {
				if (c > r) dp[r][c] = dp[r][c - 1];
				else dp[r][c] = Math.min(dp[r][c - 1], arr[c] + dp[r - c][n]); 
			}
		}
		
		bw.write(Integer.toString(dp[n][n]));
		bw.flush();

		br.close();
		bw.close();
	}
}