import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int D[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        int dp[][] = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int k = 0; k <= M; k++) {
                dp[i][k] = -1;
            }

        }
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0];

            for (int k = 1; k <= M; k++) {
                if (i - k >= 0) {
                    dp[i][0] = Math.max(dp[i][0], dp[i - k][k]);
                }
            }

            for (int k = 1; k <= M; k++) {
                if (dp[i - 1][k - 1] != -1) {
                    dp[i][k] = dp[i - 1][k - 1] + D[i];
                }
            }
        }

        System.out.println(dp[N][0]);

        br.close();
    }
}