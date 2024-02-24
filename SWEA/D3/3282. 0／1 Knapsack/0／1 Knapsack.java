import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int V[] = new int[N];
            int C[] = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            int dp[] = new int[K + 1];

            for (int i = 0; i < N; i++) {
                for (int k = K; k > 0; k--) {
                    if (k < V[i]) dp[k] = Math.max(dp[k], dp[k - 1]);
                    else dp[k] = Math.max(dp[k], C[i] + dp[k - V[i]]);
                }
            }

            sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}