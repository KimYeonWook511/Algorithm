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
		int dp[][] = new int[n + 1][2];
		int pre = Integer.parseInt(st.nextToken());
		int max = 1;
		
		for (int i = 2; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num >= pre) {
				dp[i][0] = dp[i - 1][0] + 1;
			}
			
			if (num <= pre) {
				dp[i][1] = dp[i - 1][1] + 1;
			}
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]) + 1);
			pre = num;
		}
		
		bw.write(Integer.toString(max));
		bw.flush();

		br.close();
		bw.close();
	}
}