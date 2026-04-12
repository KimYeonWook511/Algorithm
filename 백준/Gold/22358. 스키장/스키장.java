import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int a, b, t;

        Edge(int a, int b, int t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        long dp[][] = new long[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int k = 0; k <= K; k++) {
                dp[k][i] = -1;
            }
        }

        Edge edges[] = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, t);
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.a == o2.a) return Integer.compare(o1.b, o2.b);
                return Integer.compare(o1.a, o2.a);
            }
        });

        dp[0][S] = 0;
        for (int k = 0; k <= K; k++) {
            for (Edge edge : edges) {
                // 내려가기
                if (dp[k][edge.a] != -1) {
                    dp[k][edge.b] = Math.max(dp[k][edge.b], dp[k][edge.a] + edge.t);
                }
            }
            if (k == K) break;
            for (Edge edge : edges) {
                // 리프트 이용
                if (dp[k][edge.b] != -1) {
                    dp[k + 1][edge.a] = Math.max(dp[k + 1][edge.a], dp[k][edge.b]);
                }
            }
        }

        // long answer = -1;
        // for (int k = 0; k <= K; k++) {
        //     answer = Math.max(answer, dp[k][T]);
        // }
        //
        // System.out.println(answer);
        System.out.println(dp[K][T]);

        br.close();
    }
}