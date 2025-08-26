import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());

            int val[] = new int[N];
            int cnt[] = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                val[i] = Integer.parseInt(st.nextToken());
                cnt[i] = Integer.parseInt(st.nextToken());

                sum += val[i] * cnt[i];
            }

            boolean result = false;
            if (sum % 2 == 0) {
                int target = sum >> 1;
                int dp[] = new int[target + 1];
                for (int i = 1; i <= target; i++) {
                    dp[i] = -1;
                }

                for (int i = 0; i < N; i++) {
                    int v = val[i];
                    int c = cnt[i];

                    for (int k = Math.min(target, v - 1); k >= 0; k--) {
                        if (dp[k] >= 0) dp[k] = c; // k에서 v를 c만큼 더 쓸 수 있음
                    }

                    for (int k = v; k <= target; k++) {
                        if (dp[k] >= 0) dp[k] = c; // 이미 만들 수 있던 경우
                        else dp[k] = dp[k - v] - 1; // k-v의 값에서 코인 1개를 더 써서 만들 수 있는가 (음수면 못 만드는 것)
                    }
                }

                result = dp[target] >= 0;
            }

            sb.append(result ? "1\n" : "0\n");
        }

        System.out.println(sb);

        br.close();
    }
}