import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 1];
		int dp[] = new int[n + 1];
		int max = 1;
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int k = 1; k < i; k++) {
				if (arr[i] > arr[k]) dp[i] = Math.max(dp[i], dp[k] + 1);
			}
			
			max = Math.max(max, dp[i]);
		}
		
		bw.write(Integer.toString(n - max));
		bw.flush();

		br.close();
		bw.close();
	}
}