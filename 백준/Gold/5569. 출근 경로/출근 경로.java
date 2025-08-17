import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int dp[][][][] = new int[w + 1][h + 1][2][2];
        for (int i = 1; i <= w; i++) {
            dp[i][1][0][0] = 1;
        }
        for (int i = 1; i <= h; i++) {
            dp[1][i][1][0] = 1;
        }

        for (int i = 2; i <= w; i++) {
            for (int k = 2; k <= h; k++) {
                dp[i][k][1][0] = (dp[i][k - 1][1][1] + dp[i][k - 1][1][0]) % MOD;
                dp[i][k][1][1] = dp[i][k - 1][0][0] % MOD;
                dp[i][k][0][0] = (dp[i - 1][k][0][0] + dp[i - 1][k][0][1]) % MOD;
                dp[i][k][0][1] = dp[i - 1][k][1][0];
            }
        }

        System.out.println((dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % MOD);

        br.close();
    }
}