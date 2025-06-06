import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }

        System.out.println(dp[N]);

        br.close();
    }
}