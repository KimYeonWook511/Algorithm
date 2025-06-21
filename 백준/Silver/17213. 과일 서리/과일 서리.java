import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[N + 1][M + 1];
        dp[0][0] = 1; 
        
        for (int r = 1; r <= N; r++) {
        	for (int c = r; c <= M; c++) {
        		dp[r][c] = dp[r][c - 1] + dp[r - 1][c - 1]; 
        	}
        }
        
        System.out.print(dp[N][M]);

		br.close();
	}
}