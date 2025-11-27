import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[][][] = new int[N + 1][M + 2][3]; // 0: 좌상, 1: 직상, 2: 우상

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i - 1][0][1] = dp[i - 1][0][2] = 1_000_000_000;
            dp[i - 1][M + 1][0] = dp[i - 1][M + 1][1] = 1_000_000_000;

            for (int k = 1; k <= M; k++) {
                int val = Integer.parseInt(st.nextToken());
                // 좌상
                dp[i][k][0] = Math.min(dp[i - 1][k - 1][1], dp[i - 1][k - 1][2]) + val;
                // 직상
                dp[i][k][1] = Math.min(dp[i - 1][k][0], dp[i - 1][k][2]) + val;
                // 우상
                dp[i][k][2] = Math.min(dp[i - 1][k + 1][0], dp[i - 1][k + 1][1]) + val;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int k = 1; k <= M; k++) {
            answer = Math.min(answer, Math.min(dp[N][k][0], Math.min(dp[N][k][1], dp[N][k][2])));
        }

        System.out.println(answer);

        br.close();
    }
}