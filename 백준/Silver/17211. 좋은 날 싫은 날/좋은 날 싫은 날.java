import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int status = Integer.parseInt(st.nextToken());

        double arr[][] = new double[2][2];
        st = new StringTokenizer(br.readLine());
        arr[0][0] = Double.parseDouble(st.nextToken()); // 좋은 -> 좋은
        arr[0][1] = Double.parseDouble(st.nextToken()); // 좋은 -> 싫은
        arr[1][0] = Double.parseDouble(st.nextToken()); // 싫은 -> 좋은
        arr[1][1] = Double.parseDouble(st.nextToken()); // 싫은 -> 싫은

        double dp[][] = new double[N + 1][2];
        dp[0][status] = 1.0;
        dp[0][1 - status] = 0.0;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] * arr[0][0] + dp[i - 1][1] * arr[1][0];
            dp[i][1] = dp[i - 1][0] * arr[0][1] + dp[i - 1][1] * arr[1][1];
        }

        System.out.println(Math.round(dp[N][0] * 1000));
        System.out.println(Math.round(dp[N][1] * 1000));

        br.close();
    }
}
