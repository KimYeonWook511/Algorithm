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
		int m = Integer.parseInt(st.nextToken());
		int dp[] = new int[m + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			// 첫번째줄
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			int input[] = new int[m + 1];
			int left[] = new int[m + 2];
			int right[] = new int[m + 1];
			right[0] = left[m + 1] = -100_000_000;
			
			for (int i = 1; i <= m; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				right[i] = Math.max(right[i - 1], dp[i]) + input[i];
			}
			
			for (int i = m; i > 0; i--) {
				left[i] = Math.max(left[i + 1], dp[i]) + input[i];
			}
			
			for (int i = 1; i <= m; i++) {
				dp[i] = Math.max(right[i], left[i]);
			}
		}

		bw.write(Integer.toString(dp[m]));
		bw.flush();

		br.close();
		bw.close();
	}
}