import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int max = 1 << 10;
        int mod = 1_000_000_000;
        int dp[][][] = new int[N + 1][12][max]; 
        
        // 초기화
        for (int i = 1; i <= 10; i++) {
        	dp[1][i][1 << (i - 1)] = 1;
        }
        
        for (int len = 2; len <= N; len++) {
        	for (int r = 1; r <= 10; r++) {
        		for (int c = 0; c < max; c++) {
        			if ((c & (1 << (r - 1))) > 0) continue;
        			
        			int bit = c | (1 << (r - 1));
        			
    				dp[len][r][bit] += (dp[len - 1][r - 1][bit] + dp[len - 1][r + 1][bit]) % mod;
    				dp[len][r][bit] %= mod;
        			dp[len][r][bit] += (dp[len - 1][r - 1][c] + dp[len - 1][r + 1][c]) % mod;
        			dp[len][r][bit] %= mod;
        		}
        	}
        }
        
        int result = 0;
        for (int i = 2; i <= 10; i++) {
        	result = (result + dp[N][i][max - 1]) % mod;
        }
        
        System.out.println(result);
        
        br.close();
    }
}