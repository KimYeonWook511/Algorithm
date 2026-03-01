import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[100001][2];
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;

        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = (dp[i][1] + dp[i - 1][0]) % MOD;
            dp[i][0] = (dp[i][0] + dp[i - 2][1]) % MOD;
            dp[i][1] = (dp[i][1] + dp[i - 2][0]) % MOD;
            dp[i][0] = (dp[i][0] + dp[i - 3][1]) % MOD;
            dp[i][1] = (dp[i][1] + dp[i - 3][0]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1]).append(" ").append(dp[n][0]).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}