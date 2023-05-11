import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			
			for (int s = 0; s < i; s++) {
				if (arr[s] > arr[i]) dp[i] = Math.max(dp[i], dp[s] + 1);
				
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n - max);

		br.close();
	}
}