import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[21];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i <= N; i++) {
            dp[i] = dp[i - 1] << 1;
            dp[i] -= i % 2 == 0 ? dp[i - 4] + dp[i - 5] : 0;
        }

        System.out.println(dp[N]);

        br.close();
    }
}