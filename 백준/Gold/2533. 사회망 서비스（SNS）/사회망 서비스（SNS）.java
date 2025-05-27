import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        dp = new int[N + 1][2];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(N); // 무슨 수를 스타트(root)로 해도 트리이기 때문에 상관없음

        System.out.println(Math.min(dp[N][0], dp[N][1]));

        br.close();
    }

    static void dfs(int cur) {
        dp[cur][1] = 1;

        for (int next : graph[cur]) {
            if (dp[next][1] != 0) continue;

            dfs(next);
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}