import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w;

        Node (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }
    static List<Node> graph[];
    static int dist[];
    static int dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        dist = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            dp[i] = -1;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];
        pq.offer(new Node(2, 0));
        dist[2] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;
                if (dist[next.i] <= cur.w + next.w) continue;

                pq.offer(new Node(next.i, cur.w + next.w));
                dist[next.i] = cur.w + next.w;
            }
        }

        int answer = dfs(1);

        System.out.println(answer);

        br.close();
    }

    static int dfs(int cur) {
        if (cur == 2) return 1;
        if (dp[cur] != -1) return dp[cur];

        dp[cur] = 0;
        for (Node next : graph[cur]) {
            if (dist[cur] > dist[next.i]) {
                dp[cur] += dfs(next.i);
            }
        }
        return dp[cur];
    }
}