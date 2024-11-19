import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][M + 2];
        int dp[][][] = new int[N + 1][M + 2][3];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }

            for (int d = 0; d < 3; d++) {
                dp[r][0][d] = dp[r][M + 1][d] = 1_000_000_000;
            }
        }

        for (int d = 0; d < 3; d++) {
            dp[0][0][d] = dp[0][M + 1][d] = 1_000_000_000;
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                dp[r][c][0] = Math.min(dp[r - 1][c + 1][1], dp[r - 1][c + 1][2]) + arr[r][c];
                dp[r][c][1] = Math.min(dp[r - 1][c][0], dp[r - 1][c][2]) + arr[r][c];
                dp[r][c][2] = Math.min(dp[r - 1][c - 1][0], dp[r - 1][c - 1][1]) + arr[r][c];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int c = 1; c <= M; c++) {
            for (int d = 0; d < 3; d++) {
                min = Math.min(min, dp[N][c][d]);
            }
        }

        System.out.println(min);

        br.close();
    }
}