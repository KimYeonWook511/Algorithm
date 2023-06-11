import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n];
		int arr[] = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			
			for (int k = 0; k < i; k++) {
				if (arr[i] > arr[k]) dp[i] = Math.max(dp[i], dp[k] + 1);
			}
			
			max = Math.max(max, dp[i]);
		}
	
		System.out.println(max);

		br.close();
	}
}