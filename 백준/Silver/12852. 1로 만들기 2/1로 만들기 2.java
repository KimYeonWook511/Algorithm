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
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int nCopy = n;
		int dp[] = new int[n + 4];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for (int i = 4; i <= n; i++) {
			if (i % 6 == 0) {
				dp[i] = Math.min(dp[i / 2], Math.min(dp[i / 3], dp[i - 1])) + 1;
				
			} else if (i % 2 == 0) {
				dp[i] =  Math.min(dp[i / 2], dp[i - 1]) + 1;
				
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
						
			} else {
				dp[i] = dp[i - 1] + 1;
				
			}
		}
		
		sb.append(n + " ");
		
		while (n > 1) {
			if (n % 6 == 0) {
				int d2 = dp[n / 2];
				int d3 = dp[n / 3];
				int m = dp[n - 1];
				
				if (d2 <= m && d2 <= d3) {
					sb.append(n / 2 + " ");
					n /= 2;
					
				} else if (d3 <= m && d3 <= d2) {
					sb.append(n / 3 + " ");
					n /= 3;
					
				} else {
					sb.append(n - 1 + " ");
					n -= 1;
				}
				
			} else if (n % 2 == 0) {
				if (dp[n / 2] <= dp[n - 1]) {
					sb.append(n / 2 + " ");
					n /= 2;
					
				} else {
					sb.append(n - 1 + " ");
					n -= 1;
				}
				
			} else if (n % 3 == 0) {
				if (dp[n / 3] <= dp[n - 1]) {
					sb.append(n / 3 + " ");
					n /= 3;
					
				} else {
					sb.append(n - 1 + " ");
					n -= 1;
				}
						
			} else {
				sb.append(n - 1 + " ");
				n -= 1;
			}
		}
		
		bw.write(dp[nCopy] + "\n" + sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}
}