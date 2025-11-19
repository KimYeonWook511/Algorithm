import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int D = Integer.parseInt(br.readLine());

        // 0: 정보과학관 / 1: 전산관 / 2: 미래관 / 3: 신양관
        // 4: 한경직기념관 / 5: 진리관 / 6: 학생회관 / 7: 형남공학관
        long dp[][] = new long[2][8];
        dp[1][1] = 1;
        dp[1][2] = 1;
        int pre = 1;
        int cur = 0;
        for (int i = 2; i <= D; i++) {
            dp[cur][0] = (dp[pre][1] + dp[pre][2]) % MOD;
            dp[cur][1] = (dp[pre][0] + dp[pre][2] + dp[pre][3]) % MOD;
            dp[cur][2] = (dp[pre][0] + dp[pre][1] + dp[pre][3] + dp[pre][4]) % MOD;
            dp[cur][3] = (dp[pre][1] + dp[pre][2] + dp[pre][4] + dp[pre][5]) % MOD;
            dp[cur][4] = (dp[pre][2] + dp[pre][3] + dp[pre][5] + dp[pre][7]) % MOD;
            dp[cur][5] = (dp[pre][3] + dp[pre][4] + dp[pre][6]) % MOD;
            dp[cur][6] = (dp[pre][5] + dp[pre][7]) % MOD;
            dp[cur][7] = (dp[pre][4] + dp[pre][6]) % MOD;
            pre = cur;
            cur = 1 - cur;
        }

        System.out.println(dp[pre][0]);

        br.close();
    }
}