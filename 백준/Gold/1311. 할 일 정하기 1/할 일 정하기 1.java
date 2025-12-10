import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][], dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[1 << N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(func(0, 0));

        br.close();
    }

    static int func(int cur, int bit) {
        if (cur == N) {
            return 0;
        }
        if (dp[bit] != 0) {
            return dp[bit];
        }

        dp[bit] = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((bit & (1 << i)) == 0) {
                dp[bit] = Math.min(dp[bit], arr[cur][i] + func(cur + 1, bit | (1 << i)));
            }
        }

        return dp[bit];
    }
}