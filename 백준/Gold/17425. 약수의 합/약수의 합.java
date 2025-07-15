import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long dp[] = new long[1_000_001];
        for (int i = 1; i <= 1_000_000; i++) {
            dp[i] += dp[i - 1];

            for (int k = i; k <= 1_000_000; k += i) {
                dp[k] += i;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}