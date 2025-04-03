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

            int dp[] = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int)((Double.parseDouble(st.nextToken()) + 0.001) * 100);

                for (int curM = p; curM <= m; curM++) {
                    dp[curM] = Math.max(dp[curM], dp[curM - p] + c);
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
        
        br.close();
    }
}