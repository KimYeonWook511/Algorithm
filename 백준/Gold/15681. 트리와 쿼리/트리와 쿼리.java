import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[]; // 여기선 트리임
    static int dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph[U].add(V);
            graph[V].add(U);
        }

        dfs(R);

        for (int q = 0; q < Q; q++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int dfs(int cur) {
        dp[cur] = 1;

        for (int next : graph[cur]) {
            if (dp[next] != 0) continue;

            dp[cur] += dfs(next);
        }

        return dp[cur];
    }
}