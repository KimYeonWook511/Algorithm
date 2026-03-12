import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a[] = new int[N + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[M + 1][N + 3];
        for (int t = 0; t <= M; t++) {
            Arrays.fill(dp[t], -1);
        }
        dp[0][0] = 1;

        int answer = 1;
        for (int t = 0; t < M; t++) {
            for (int i = 0; i <= N; i++) {
                if (dp[t][i] == -1) continue;

                int cur = dp[t][i];
                answer = Math.max(answer, cur);

                // 1칸
                dp[t + 1][i + 1] = Math.max(dp[t + 1][i + 1], cur + a[i + 1]);
                // 2칸
                dp[t + 1][i + 2] = Math.max(dp[t + 1][i + 2], cur / 2 + a[i + 2]);
            }
        }

        for (int i = 0; i <= N; i++) {
            answer = Math.max(answer, dp[M][i]);
        }

        System.out.println(answer);

        br.close();
    }
}