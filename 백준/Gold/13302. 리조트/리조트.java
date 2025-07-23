import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean arr[];
    static int dp[][];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1];
        dp = new int [N + 1][N + 1];

        if (M > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int r = 0; r <= N; r++) {
            for (int c = 0; c <= N; c++) {
                dp[r][c] = -1;
            }
        }

        System.out.println(func(1, 0));

        br.close();
    }

    static int func(int i, int coupon) {
        if (i > N) return 0;
        if (dp[i][coupon] != -1) return dp[i][coupon];

        dp[i][coupon] = Integer.MAX_VALUE;

        if (arr[i]) {
            dp[i][coupon] = func(i + 1, coupon);

        } else {
            if (coupon >= 3) dp[i][coupon] = func(i + 1, coupon - 3);
            dp[i][coupon] = Math.min(dp[i][coupon], func(i + 1, coupon) + 10000);
            dp[i][coupon] = Math.min(dp[i][coupon], func(i + 3, coupon + 1) + 25000);
            dp[i][coupon] = Math.min(dp[i][coupon], func(i + 5, coupon + 2) + 37000);
        }
            
        return dp[i][coupon];
    }
}