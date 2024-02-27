import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int I[] = new int[K];
		int T[] = new int[K];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			I[i] = Integer.parseInt(st.nextToken());
			T[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N + 1];
		
		for (int r = 0; r < K; r++) {
			for (int c = N; c > 0; c--) {
				if (c >= T[r]) dp[c] = Math.max(dp[c], dp[c - T[r]] + I[r]);
			}
		}
		
		System.out.println(dp[N]);
		
		br.close();
	}
}