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
		int arr[] = new int[n + 1];
		int dp[] = new int[n + 1];
		int maxLen = 1;
		int maxIdx = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int k = 0; k < i; k++) {
				if (arr[i] > arr[k]) {
					dp[i] = Math.max(dp[i], dp[k] + 1);
				}
			}
			
			if (dp[i] > maxLen) {
				maxLen = dp[i];
				maxIdx = i;
			}
		}
		
		int result[] = new int[maxLen + 1];
		result[1] = arr[maxIdx];
		dp[maxIdx]--;
		
		for (int i = maxIdx - 1; i > 0; i--) {
			if (dp[maxIdx] == dp[i] && arr[i] < result[maxLen - dp[maxIdx]]) {
				dp[maxIdx]--;
				result[maxLen - dp[maxIdx]] = arr[i];
			}
		}
		
		bw.write(maxLen + "\n");
		for (int i = maxLen; i > 0; i--) {
			bw.write(result[i] + " ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}