import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[] = new int[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; ++i) {
            dp[i] = i < M ? dp[i - 1] : (dp[i - 1] + dp[i - M]) % MOD;
        }

        System.out.println(dp[N]);

        br.close();
    }
}
