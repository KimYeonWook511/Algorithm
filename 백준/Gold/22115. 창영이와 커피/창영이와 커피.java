import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int dp[] = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            dp[i] = INF;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int C = Integer.parseInt(st.nextToken());

            for (int k = K; k >= C; k--) {
                dp[k] = Math.min(dp[k], dp[k - C] + 1);
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);

        br.close();
    }
}