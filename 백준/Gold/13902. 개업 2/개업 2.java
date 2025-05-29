import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[] = new int[(N << 1) + 1];
        int S[] = new int[M];

        for (int i = 1; i <= N; i++) {
            dp[i] = 10001;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            S[i] = Integer.parseInt(st.nextToken());

            dp[S[i]] = 1;
            for (int k = 0; k < i; k++) {
                dp[S[k] + S[i]] = 1;
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int k = i >> 1; k > 0; k--) {
                dp[i] = Math.min(dp[i], dp[k] + dp[i - k]);
            }
        }

        System.out.println(dp[N] == 10001 ? "-1" : dp[N]);

        br.close();
    }
}