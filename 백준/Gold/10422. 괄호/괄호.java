import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long MOD = 1_000_000_007L;

        long dp[] = new long[5001];
        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i <= 5000; i += 2) {
            dp[i] = dp[i - 2];

            for (int k = 2; k < i; k += 2) {
                dp[i] = (dp[i] + dp[i - k] * dp[k - 2]) % MOD;
            }
        }

        for (int t = 0; t < T; t++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}