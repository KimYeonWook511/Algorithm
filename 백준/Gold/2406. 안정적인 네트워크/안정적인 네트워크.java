import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from, to, w;

        Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        // 1을 제외하고 연결되어야 함
        // 프림, 크루스칼 다 가능해 보임
        solvePrim();
        // solveKruskal();
    }

    static void solvePrim() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new List[n + 1];
        int dist[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(x, y, 0));
            graph[y].add(new Node(y, x, 0));
        }

        for (int x = 1; x <= n; x++) {
            st = new StringTokenizer(br.readLine());
            if (x == 1) continue;

            for (int y = 1; y <= n; y++) {
                int w = Integer.parseInt(st.nextToken());

                if (x == y) continue;
                if (y == 1) continue;

                graph[x].add(new Node(x, y, w));
                graph[y].add(new Node(y, x, w));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[n + 1];
        pq.offer(new Node(0, 2, 0));
        dist[2] = 0;

        int X = 0;
        int K = 0;
        StringBuilder sb = new StringBuilder();

        int cnt = n - 1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;

            if (cur.w > 0) {
                X += cur.w;
                K++;
                sb.append(cur.from).append(" ").append(cur.to).append("\n");
            }

            if (--cnt == 0) break;

            for (Node next : graph[cur.to]) {
                if (visited[next.to]) continue;
                if (dist[next.to] <= next.w) continue;

                pq.offer(next);
                dist[next.to] = next.w;
            }
        }

        System.out.println(X + " " + K);
        System.out.println(sb);

        br.close();
    }

    static void solveKruskal() {

    }
}