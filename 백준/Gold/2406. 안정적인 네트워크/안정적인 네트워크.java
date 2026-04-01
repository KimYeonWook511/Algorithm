import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, w;

        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    static int parents[];
    static int ranks[];

    public static void main(String[] args) throws Exception {
        // 1을 제외하고 연결되어야 함
        // 프림, 크루스칼 다 가능해 보임
        // solvePrim();
        solveKruskal();
    }

    static void solvePrim() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> graph[] = new List[n + 1];
        int dist[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(new Edge(x, y, 0));
            graph[y].add(new Edge(y, x, 0));
        }

        for (int x = 1; x <= n; x++) {
            st = new StringTokenizer(br.readLine());
            if (x == 1) continue;

            for (int y = 1; y <= n; y++) {
                int w = Integer.parseInt(st.nextToken());

                if (x == y) continue;
                if (y == 1) continue;

                graph[x].add(new Edge(x, y, w));
                graph[y].add(new Edge(y, x, w));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[n + 1];
        pq.offer(new Edge(0, 2, 0));
        dist[2] = 0;

        int X = 0;
        int K = 0;
        StringBuilder sb = new StringBuilder();

        int cnt = n - 1;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;

            if (cur.w > 0) {
                X += cur.w;
                K++;
                sb.append(cur.from).append(" ").append(cur.to).append("\n");
            }

            if (--cnt == 0) break;

            for (Edge next : graph[cur.to]) {
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

    static void solveKruskal() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        ranks = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int cnt = n - 2;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // x,y는 1이 아닌가??
            if (union(x, y)) {
                cnt--;
            }
        }

        for (int x = 1; x <= n; x++) {
            st = new StringTokenizer(br.readLine());
            if (x == 1) continue;

            for (int y = 1; y <= n; y++) {
                int w = Integer.parseInt(st.nextToken());

                if (x < y) {
                    edges.add(new Edge(x, y, w));
                }
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        int X = 0;
        int K = 0;
        StringBuilder sb = new StringBuilder();

        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int w = edge.w;

            if (union(from, to)) {
                X += w;
                K++;
                sb.append(from).append(" ").append(to).append("\n");
                if (--cnt == 0) break;
            }
        }

        System.out.println(X + " " + K);
        System.out.println(sb);

        br.close();
    }

    static int find(int x) {
        if (parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (ranks[x] < ranks[y]) {
            parents[x] = y;
        } else if (ranks[x] > ranks[y]) {
            parents[y] = x;
        } else {
            parents[x] = y;
            ranks[y]++;
        }
        return true;
    }
}