import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long dp[][] = new long[11][2001]; // n, m

        for (int m = 1; m <= 2000; m++) {
            dp[1][m] = m;
        }

        for (int n = 2; n <= 10; n++) {
            for (int m = (1 << (n - 1)); m <= 2000; m++) {
                dp[n][m] = dp[n][m - 1] + dp[n - 1][m >> 1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[n][m]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}