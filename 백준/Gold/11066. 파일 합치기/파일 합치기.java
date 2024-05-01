import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int run = 0; run < T; run++) {
            int K = Integer.parseInt(br.readLine());

            int dp[][] = new int[K + 1][K + 1];
            int sum[] = new int[K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                dp[i][i] = Integer.parseInt(st.nextToken());

                dp[i - 1][i] = dp[i - 1][i - 1] + dp[i][i];
                sum[i] = sum[i - 1] + dp[i][i];
            }

            for (int s = 2; s < K; s++) {
                for (int r = 1; r <= K - s; r++) {
                    int end = r + s;
                    dp[r][end] = sum[end] - sum[r - 1] + Math.min(dp[r + 1][end], dp[r][end - 1]);

                    for (int c = r + 1; c < end - 1; c++) {
                        dp[r][end] = Math.min(dp[r][end], sum[end] - sum[r - 1] + dp[r][c] + dp[c + 1][end]);
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}