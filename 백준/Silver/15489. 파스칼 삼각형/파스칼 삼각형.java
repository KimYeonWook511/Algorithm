import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int max = R + W;
        int dp[][] = new int[max + 1][max + 1];
        dp[1][1] = 1;

        for (int r = 2; r <= max; r++) {
            for (int c = 1; c <= r; c++) {
                dp[r][c] = dp[r - 1][c - 1] + dp[r - 1][c];
            }
        }

        int sum = 0;
        for (int r = 0; r < W; r++) {
            for (int c = 0; c <= r; c++) {
                sum += dp[R + r][C + c];
            }
        }

        System.out.println(sum);

        br.close();
    }
}