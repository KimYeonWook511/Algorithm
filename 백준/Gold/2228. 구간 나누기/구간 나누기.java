import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dp[][][] = new int[N][M + 1][2];
        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= M; k++) {
                dp[i][k][0] = dp[i][k][1] = Integer.MIN_VALUE;
            }
        }

        dp[0][1][1] = arr[0];
        for (int i = 1; i < N; i++) {
            for (int k = 1; k <= M; k++) {
                // 사용하지 않음
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1]);

                // 새로운 조각
                if (dp[i - 1][k - 1][0] != Integer.MIN_VALUE) dp[i][k][1] = dp[i - 1][k - 1][0] + arr[i];

                // 이어 붙이기
                if (dp[i - 1][k][1] != Integer.MIN_VALUE) dp[i][k][1] = Math.max(dp[i][k][1], dp[i - 1][k][1] + arr[i]);
            }
        }

        System.out.println(Math.max(dp[N - 1][M][0], dp[N - 1][M][1]));

        br.close();
    }
}