import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            // 전체 구하기
            dp[i] = dp[i - 1] + (dp[i - 2] << 1);
        }

        dp[N] += dp[N >> 1] + (N % 2 == 0 ? dp[(N - 2) >> 1] << 1 : 0);
        System.out.println(dp[N] >> 1);

        br.close();
    }
}