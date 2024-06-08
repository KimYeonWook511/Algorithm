import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int dist[] = new int[N + 1];
        int time[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N + 2];
        int node[] = new int[N + 2];

        for (int i = N + 1; i > 0; i--) {
            dp[i] = -1; // 합이 Integer.MAX_VALUE 이하여서 -1로 초기화
        }

        for (int i = 0; i <= N; i++) {
            int sum = 0;
            int val = dp[i] + time[i];

            for (int k = i; k <= N; k++) {
                sum += dist[k];

                if (sum > M) break;

                if (dp[k + 1] == -1 || val < dp[k + 1]) {
                    dp[k + 1] = val;
                    node[k + 1] = i;
                }
            }
        }

        sb.append(dp[N + 1]).append("\n");
        
        if (dp[N + 1] == 0) {
            sb.append("0");
        } else {
            int idx = node[N + 1];
            int result[] = new int[N + 1];
            int cnt = 0;

            while (idx > 0) {
                result[cnt++] = idx;
                idx = node[idx];
            }
    
            sb.append(cnt).append("\n");

            for (int i = cnt - 1; i >= 0; i--) {
                sb.append(result[i]).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}