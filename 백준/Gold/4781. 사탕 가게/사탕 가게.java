import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            int m = (int)((Double.parseDouble(st.nextToken()) + 0.001) * 100);
            int c[] = new int[n + 1];
            int p[] = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                c[i] = Integer.parseInt(st.nextToken());
                p[i] = (int)((Double.parseDouble(st.nextToken()) + 0.001) * 100);
            }

            int dp[] = new int[m + 1];
            for (int curM = 1; curM <= m; curM++) {
                dp[curM] = dp[curM - 1];

                for (int i = 1; i <= n; i++) {
                    if (curM < p[i]) continue;

                    dp[curM] = Math.max(dp[curM], dp[curM - p[i]] + c[i]);
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
        
        br.close();
    }
}