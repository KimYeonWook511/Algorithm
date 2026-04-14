import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, c, d;

        Node(int i, int c, int d) {
            this.i = i;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 항상 1

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Node> graph[] = new List[N + 1];
            int dp[][] = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                for (int m = 0; m <= M; m++) {
                    dp[i][m] = Integer.MAX_VALUE;
                }
            }

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v, c, d));
            }

            dp[1][0] = 0;

            int answer = Integer.MAX_VALUE;
            for (int m = 0; m <= M; m++) {
                for (int i = 1; i <= N; i++) {
                    if (dp[i][m] == Integer.MAX_VALUE) continue;

                    for (Node next : graph[i]) {
                        if (m + next.c > M) continue;
                        dp[next.i][m + next.c] = Math.min(dp[next.i][m + next.c], dp[i][m] + next.d);
                    }
                }

                answer = Math.min(answer, dp[N][m]);
            }

            sb.append(answer == Integer.MAX_VALUE ? "Poor KCM" : answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}