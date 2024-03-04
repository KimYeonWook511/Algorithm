import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean dp[][] = new boolean[N + 1][15001];
		int sum = arr[0];
		dp[0][arr[0]] = true;
		
		for (int r = 1; r < N; r++) {
			sum += arr[r];
			dp[r][arr[r]] = true;
			
			for (int c = 1; c <= sum; c++) {
				if (!dp[r - 1][c]) continue;
				
				dp[r][c] = true;
				dp[r][c + arr[r]] = true;
				dp[r][Math.abs(c - arr[r])] = true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int K = Integer.parseInt(st.nextToken());
			
			if (K > 15000) sb.append("N ");
			else sb.append(dp[N - 1][K] ? "Y " : "N ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}