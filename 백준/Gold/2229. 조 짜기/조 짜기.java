import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			int min = arr[i];
			int max = arr[i];
			
			for (int k = 0; k < i; k++) {
				min = Math.min(min, arr[i - k]);
				max = Math.max(max, arr[i - k]);
				
				dp[i] = Math.max(dp[i], dp[i - k - 1] + (max - min));
			}
			
			// k == i
			min = Math.min(min, arr[0]);
			max = Math.max(max, arr[0]);
			dp[i] = Math.max(dp[i], max - min);
		}

		System.out.println(dp[N - 1]);
		
		br.close();
	}
}