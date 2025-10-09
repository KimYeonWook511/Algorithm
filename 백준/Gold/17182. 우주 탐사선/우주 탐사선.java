import java.io.*;
import java.util.*;

public class Main {
    static int N, K, arr[][];
    static int maxBit, dp[][];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (s == m) continue;

                for (int e = 0; e < N; e++) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
                }
            }
        }

        maxBit = 1 << N;
        dp = new int[N][maxBit];
        for (int i = 0; i < N; i++) {
            for (int k = maxBit - 1; k >= 0; k--) {
                dp[i][k] = Integer.MAX_VALUE;
            }
        }

        dp[K][1 << K] = 0;
        func(K, 1 << K);

        System.out.println(result);

        br.close();
    }

    static void func(int s, int bit) {
        if (bit == maxBit - 1) {
            result = Math.min(result, dp[s][bit]);
            return;
        }
        if (dp[s][bit] >= result) return;

        for (int e = 0; e < N; e++) {
            if ((bit & (1 << e)) != 0) continue;

            int nextBit = bit | (1 << e);
            if (dp[e][nextBit] <= dp[s][bit] + arr[s][e]) continue;

            dp[e][nextBit] = dp[s][bit] + arr[s][e];
            func(e, nextBit);
        }
    }
}