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
		int max = 0;
		int input[] = new int[n];
		int dp[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = input[0];
		max = dp[0];
		
		for (int i = 1; i < n; i++) {
			for (int k = 0; k < i; k++) {
				if (input[i] > input[k]) {
					dp[i] = Math.max(dp[i], dp[k] + input[i]);
				} else {
					dp[i] = Math.max(dp[i], input[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		bw.write(Integer.toString(max));
		bw.flush();

		br.close();
		bw.close();
	}
}