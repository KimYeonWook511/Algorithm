import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int dp[][][] = new int[K + 1][N + 1][3];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            dp[0][r][0] = Integer.parseInt(st.nextToken());
            dp[0][r][1] = Integer.parseInt(st.nextToken());
            dp[0][r][2] = dp[0][r][0] + dp[0][r][1] + dp[0][r - 1][2];
        }

        br.readLine();

        for (int k = 1; k <= K; k++) {
            for (int r = 1; r <= k; r++) {
                dp[k][r][0] = Math.max(dp[k - 1][r - 1][0], dp[k - 1][r - 1][2]) + dp[0][r][0];
                dp[k][r][1] = Math.max(dp[k - 1][r - 1][1], dp[k - 1][r - 1][2]) + dp[0][r][1];
            }

            for (int r = k + 1; r <= N; r++) {
                dp[k][r][0] = Math.max(dp[k - 1][r - 1][0], dp[k - 1][r - 1][2]) + dp[0][r][0];
                dp[k][r][1] = Math.max(dp[k - 1][r - 1][1], dp[k - 1][r - 1][2]) + dp[0][r][1];
                dp[k][r][2] = Math.max(Math.max(dp[k][r - 1][0], dp[k][r - 1][1]), dp[k][r - 1][2]) + dp[0][r][0] + dp[0][r][1];
            }
        }

        System.out.println(Math.max(Math.max(dp[K][N][0], dp[K][N][1]), dp[K][N][2]));

        br.close();
    }
}