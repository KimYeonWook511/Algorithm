import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st.nextToken(); // M
        int H = Integer.parseInt(st.nextToken());

        List<Integer> blocks[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            blocks[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int dp[][] = new int[N + 1][H + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int h = 0; h <= H; h++) {
                // 블록 안 쓰는 경우
                dp[i][h] = dp[i - 1][h];

                // 블록 하나 쓰는 경우
                for (int block : blocks[i]) {
                    if (h >= block) {
                        dp[i][h] = (dp[i][h] + dp[i - 1][h - block]) % MOD;
                    }
                }
            }
        }

        System.out.println(dp[N][H]);

        br.close();
    }
}