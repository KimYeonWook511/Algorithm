import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dp[] = new int[12];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        if (dp[n] < k) {
            sb.append(-1);
        } else {
            while (n > 0) {
                if (n - 1 >= 0 && k <= dp[n - 1]) {
                    // 1을 선택하는 경우
                    sb.append("1");
                    n -= 1;
                } else if (n - 2 >= 0 && k <= dp[n - 1] + dp[n - 2]) {
                    // 2를 선택하는 경우
                    sb.append("2");
                    k -= dp[n - 1];
                    n -= 2;
                } else {
                    // 3을 선택하는 경우
                    sb.append("3");
                    k -= dp[n - 1] + (n - 2 >= 0 ? dp[n - 2] : 0);
                    n -= 3;
                }

                if (n > 0) sb.append("+");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
