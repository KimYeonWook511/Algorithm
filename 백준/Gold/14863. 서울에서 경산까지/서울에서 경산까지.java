import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int walk[][] = new int[N][2];
        int bike[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            walk[i][0] = Integer.parseInt(st.nextToken());
            walk[i][1] = Integer.parseInt(st.nextToken());
            bike[i][0] = Integer.parseInt(st.nextToken());
            bike[i][1] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[N][K + 1];
        dp[0][walk[0][0]] = walk[0][1];
        dp[0][bike[0][0]] = Math.max(dp[0][bike[0][0]], bike[0][1]);

        for (int i = 1; i < N; i++) {
            for (int k = K; k >= walk[i][0]; k--) {
                if (dp[i - 1][k - walk[i][0]] != 0) {
                    dp[i][k] = dp[i - 1][k - walk[i][0]] +  walk[i][1];
                }
            }

            for (int k = K; k >= bike[i][0]; k--) {
                if (dp[i - 1][k - bike[i][0]] != 0) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 1][k - bike[i][0]] +  bike[i][1]);
                }
            }
        }

        int answer = 0;
        for (int k = 0; k <= K; k++) {
            answer = Math.max(answer, dp[N - 1][k]);
        }

        System.out.println(answer);

        br.close();
    }
}