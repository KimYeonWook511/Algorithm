import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int a[] = new int[N + 1];
        int dp[] = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        a[0] = 1;
        dp[4] = 1;
        int sum = 0;

        for (int i = 1; i <= 4; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[4] *= a[i];
        }

        sum = dp[4];

        for (int i = 5; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());

            dp[i] = dp[i - 1] / a[i - 4] * a[i];

            sum += dp[i];
        }

        dp[0] = dp[N];

        for (int i = 1; i < 4; i++) {
            dp[i] = dp[i - 1] / a[N - 4 + i] * a[i];
            sum += dp[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int run = 0; run < Q; run++) {
            int Qi = Integer.parseInt(st.nextToken());

            for (int p = 0; p < 4; p++) {
                int idx = (Qi + p) % N;
                
                if (idx == 0) idx = N;

                dp[idx] = -dp[idx];
                sum += (dp[idx] << 1);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}