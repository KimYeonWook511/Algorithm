import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[1001][1001];
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
		dp[3][2] = 2;

        for (int i = 4; i <= 1000; i++) {
            for (int k = 2; k < i; k++) {
                dp[i][k] = (dp[i - 1][k - 1] + dp[i - 2][k - 1] + dp[i - 3][k - 1]) % MOD;
            }
            dp[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int k = 1; k <= b; k++) {
                sum = (sum + dp[a][k]) % MOD;
            }
            sb.append(sum).append("\n");
        }
        
		System.out.println(sb);

        br.close();
    }
}