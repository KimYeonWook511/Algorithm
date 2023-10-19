import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int sum [] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[4][n + 1];

        for (int r = 1; r <= 3; r++) {
            for (int c = r * k; c <= n; c++) {
                dp[r][c] = Math.max(dp[r][c - 1], dp[r - 1][c - k] + (sum[c] - sum[c - k]));
            }
        }

        System.out.println(dp[3][n]);

        br.close();
    }
}