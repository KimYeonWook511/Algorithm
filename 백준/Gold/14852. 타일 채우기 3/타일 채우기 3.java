import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_007;

        int dp[] = new int[N + 3];
        int tempDP[] = new int[N + 3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for (int i = 3; i <= N; i++) {
            // 2*1, 1*1 2개
            dp[i] = (dp[i - 1] << 1) % MOD;

            // 1*2 2개, 1*2 + 1*1 2개, 1*1 2개 + 1*2
            dp[i] = (dp[i] + dp[i - 2]) % MOD; 
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
            dp[i] = (dp[i] + dp[i - 2]) % MOD;

            tempDP[i] = (dp[i - 3] << 1) % MOD;
            tempDP[i] = (tempDP[i] + tempDP[i - 1]) % MOD;

            // 엇각
            dp[i] = (dp[i] + tempDP[i]) % MOD;
        }   

        System.out.println(dp[N]);

        br.close();
    }
}