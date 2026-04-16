import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w;

        Node(int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    static List<Node> graph[];
    static int dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new List[N + 1];
            dp = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                dp[i] = -1;
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, w));
                graph[b].add(new Node(a, w));
            }

            sb.append(dfs(1, Integer.MAX_VALUE)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int dfs(int cur, int preW) {
        if (graph[cur].size() == 1 && cur != 1) return preW;

        if (dp[cur] != -1) return dp[cur];
        dp[cur] = 0;

        int sum = 0;
        for (Node next : graph[cur]) {
            if (dp[next.i] == 0) continue;
            sum += dfs(next.i, next.w);
        }

        return dp[cur] = Math.min(preW, sum);
    }
}