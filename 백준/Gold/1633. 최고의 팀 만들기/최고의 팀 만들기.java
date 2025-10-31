import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int white[] = new int[1001];
    static int black[] = new int[1001];
    static int dp[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while (true) {
            input = br.readLine();

            if (input == null) break;

            N++;
            StringTokenizer st = new StringTokenizer(input);
            white[N] = Integer.parseInt(st.nextToken());
            black[N] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][16][16];
        func(N, 15, 15);

        System.out.println(dp[N][15][15]);

        br.close();
    }

    static int func(int i, int wIdx, int bIdx) {
        if (i == 0) return 0;
        if (wIdx==0 && bIdx==0) return 0;
        if (dp[i][wIdx][bIdx] != 0) return dp[i][wIdx][bIdx];

        int ans = Math.max(dp[i][wIdx][bIdx], func(i - 1, wIdx, bIdx));
        if (wIdx > 0) ans = Math.max(ans, func(i - 1, wIdx - 1, bIdx) + white[i]);
        if (bIdx > 0) ans = Math.max(ans, func(i - 1, wIdx, bIdx - 1) + black[i]);

        return dp[i][wIdx][bIdx] = ans;
    }
}