import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[M + 1][K + 1];

        for (int i = 0; i < N; i++) {
            int cheese = x[i];
            int fries = y[i];
            for (int c = M; c >= cheese; c--) {
                for (int f = K; f >= fries; f--) {
                    dp[c][f] = Math.max(dp[c][f], dp[c - cheese][f - fries] + 1);
                }
            }
        }

        System.out.println(dp[M][K]);

        br.close();
    }
}
