import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N + 1];
		
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			dp[num] = dp[num - 1] + 1;
			max = Math.max(max, dp[num]);
		}
		
		System.out.println(N - max);
		
		br.close();
	}
}