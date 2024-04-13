import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> graph[] = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());

            graph[cur].add(pre);
        }

        int dp[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int pre : graph[i]) {
                dp[i] = Math.max(dp[i], dp[pre] + 1);
            }

            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}