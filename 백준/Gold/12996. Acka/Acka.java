import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        long dp[][][][] = new long[S + 1][D + 1][K + 1][H + 1];
        dp[0][0][0][0] = 1;

        for (int s = 0; s < S; s++) {
            for (int d = 0; d <= D; d++) {
                for (int k = 0; k <= K; k++) {
                    for (int h = 0; h <= H; h++) {
                        if (dp[s][d][k][h] == 0) continue;

                        long cur = dp[s][d][k][h];
                        // 1명
                        if (d + 1 <= D) {
                            dp[s + 1][d + 1][k][h] = (dp[s + 1][d + 1][k][h] + cur) % MOD;
                        }

                        if (k + 1 <= K) {
                            dp[s + 1][d][k + 1][h] = (dp[s + 1][d][k + 1][h] + cur) % MOD;
                        }

                        if (h + 1 <= H) {
                            dp[s + 1][d][k][h + 1] = (dp[s + 1][d][k][h + 1] + cur) % MOD;
                        }

                        // 2명
                        if (d + 1 <= D && k + 1 <= K) {
                            dp[s + 1][d + 1][k + 1][h] = (dp[s + 1][d + 1][k + 1][h] + cur) % MOD;
                        }

                        if (d + 1 <= D && h + 1 <= H) {
                            dp[s + 1][d + 1][k][h + 1] = (dp[s + 1][d + 1][k][h + 1] + cur) % MOD;
                        }

                        if (k + 1 <= K && h + 1 <= H) {
                            dp[s + 1][d][k + 1][h + 1] = (dp[s + 1][d][k + 1][h + 1] + cur) % MOD;
                        }

                        // 3명
                        if (d + 1 <= D && k + 1 <= K && h + 1 <= H) {
                            dp[s + 1][d + 1][k + 1][h + 1] = (dp[s + 1][d + 1][k + 1][h + 1] + cur) % MOD;
                        }
                    }
                }
            }
        }

        System.out.println(dp[S][D][K][H]);

        br.close();
    }
}
