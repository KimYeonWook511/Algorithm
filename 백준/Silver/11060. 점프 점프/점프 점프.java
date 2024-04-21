import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 100];

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (dp[i] == Integer.MAX_VALUE) continue;

            for (int k = 1; k <= num; k++) {
                dp[i + k] = Math.min(dp[i + k], dp[i] + 1);
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? "-1" : dp[N - 1]);

        br.close();
    }
}