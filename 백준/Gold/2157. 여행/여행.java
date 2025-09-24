import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.max(arr[a][b], c);
        }

        int dp[][] = new int[M + 1][N + 1];
        for (int b = 2; b <= N; b++) {
            dp[2][b] = arr[1][b];
        }

        for (int m = 3; m <= M; m++) {
            for (int a = 1; a <= N; a++) {
                for (int b = a + 1; b <= N; b++) {
                    if (arr[a][b] == 0) continue;
                    if (dp[m - 1][a] == 0) continue;

                    dp[m][b] = Math.max(dp[m][b], dp[m - 1][a] + arr[a][b]);
                }
            }
        }

        int result = 0;
        for (int m = 2; m <= M; m++) {
            result = Math.max(result, dp[m][N]);
        }

        System.out.println(result);

        br.close();
    }
}