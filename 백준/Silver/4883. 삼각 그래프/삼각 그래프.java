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
	static int idx = 1;
	
	public static void main(String[] args) throws IOException {

		while (true) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) break;
			
			int dp[][] = new int[n][3];
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			dp[0][0] = 1000; 
			dp[0][1] = Integer.parseInt(st.nextToken());
			dp[0][2] = dp[0][1] + Integer.parseInt(st.nextToken());
			
			for (int r = 1; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				
				dp[r][0] = Math.min(dp[r - 1][0], dp[r - 1][1]) + Integer.parseInt(st.nextToken());
				dp[r][1] = Math.min(dp[r][0], Math.min(dp[r - 1][0], Math.min(dp[r - 1][1], dp[r - 1][2]))) + Integer.parseInt(st.nextToken());
				dp[r][2] = Math.min(dp[r][1], Math.min(dp[r - 1][1], dp[r - 1][2])) + Integer.parseInt(st.nextToken());
			}
			
			bw.write(idx++ + ". " + dp[n - 1][1] + "\n");
		}
		
		br.close();
		bw.close();
	}
}