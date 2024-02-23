import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char chk[][] = new char[N + 2][M + 2];
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) + 1;
			int c1 = Integer.parseInt(st.nextToken()) + 1;
			int r2 = Integer.parseInt(st.nextToken()) + 1;
			int c2 = Integer.parseInt(st.nextToken()) + 1;
			
			if (r1 < r2) chk[r2][c2] |= 1; // 'D'
			else if (r1 > r2) chk[r1][c1] |= 1; // 'D'
			else if (c1 < c2) chk[r2][c2] |= 2; // 'L'
			else chk[r1][c1] |= 2; // 'L'
		}
		
		long dp[][] = new long[N + 2][M + 2];
		dp[0][1] = 1;
		
		for (int r = 1; r <= N + 1; r++) {
			for (int c = 1; c <= M + 1; c++) {
				if ((chk[r][c] & 1) == 0) dp[r][c] += dp[r - 1][c];
				if ((chk[r][c] & 2) == 0) dp[r][c] += dp[r][c - 1];
			}
		}
		
		System.out.println(dp[N + 1][M + 1]);
		
		br.close();
	}
}