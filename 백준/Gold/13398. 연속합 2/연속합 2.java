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
		int dp[][] = new int[n][2];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		max = dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = 0;
		
		for (int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			dp[i][0] = dp[i - 1][0] + num > num ? dp[i - 1][0] + num : num;
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + num);
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		bw.write(Integer.toString(max));
		bw.flush();

		br.close();
		bw.close();
	}
}