import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long dp[][][] = new long[N + 1][N + 1][N + 1];
        dp[1][1][1] = 1;
        for (int n = 2; n <= N; n++) {
            for (int l = 2; l <= n; l++) {
                for (int r = Math.min(l, n - l + 1); r >= 1; r--) {
                    dp[n][l][r] = dp[n - 1][l][r] * (n - 2); // 중간에 1이 오고 나머지 1씩 키우기 (if n==4 then 312 -> 4123, 4213)
                    dp[n][l][r] += dp[n - 1][l - 1][r]; // 맨 앞에 1이 오고 나머지 1씩 키우기 (if n==4 then 312 -> 1423)
                    dp[n][l][r] += dp[n - 1][l][r - 1]; // 맨 뒤에 1이 오고 나머지 1씩 키우기 (if n==4 then 312 -> 4231)
                    dp[n][l][r] %= MOD;
                    dp[n][r][l] = dp[n][l][r];
                }
            }
        }

        System.out.println(dp[N][L][R]);

        br.close();
    }
}