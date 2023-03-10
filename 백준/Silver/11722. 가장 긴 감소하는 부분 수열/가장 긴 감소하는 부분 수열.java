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
		int dp[] = new int[n + 1];
		int max = 1;
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for (int i = n - 1; i > 0; i--) {
			for (int k = n; k > i; k--) {
				if (arr[i] > arr[k]) {
					dp[i] = Math.max(dp[i], dp[k] + 1);
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