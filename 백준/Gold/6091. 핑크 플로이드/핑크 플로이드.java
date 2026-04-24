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
    static class Edge {
        int u, v;
        int w;

        Edge (int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 프림 전용 input 처리
        // int arr[][] = new int[N + 1][N + 1];
        // for (int r = 1; r < N; r++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     for (int c = r + 1; c <= N; c++) {
        //         arr[r][c] = Integer.parseInt(st.nextToken());
        //     }
        //     arr[r][r] = Integer.MAX_VALUE;
        // }

        // 크루스칼 전용 input 처리
        Edge edges[] = new Edge[N * (N - 1) / 2];
        int index = 0;
        for (int r = 1; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = r + 1; c <= N; c++) {
                edges[index++] = new Edge(r, c, Integer.parseInt(st.nextToken()));
            }
        }

        // 크루스칼
        List<Integer> answer[] = kruskal(N, edges);
        // 프림
        // List<Integer> answer[] = prim(N, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i].size()).append(" ");

            Collections.sort(answer[i]);
            for (int next : answer[i]) {
                sb.append(next).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static List[] kruskal(int N, Edge edges[]) {
        List<Integer> graph[] = new List[N + 1];
        int parents[] = new int[N + 1];
        int ranks[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            parents[i] = i;
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        int cnt = N - 1;
        for (Edge edge : edges) {
            if (union(edge.u, edge.v, parents, ranks)) {
                graph[edge.u].add(edge.v);
                graph[edge.v].add(edge.u);

                if (--cnt == 0) {
                    break;
                }
            }
        }

        return graph;
    }

    static int find(int x, int parents[]) {
        if (parents[x] == x) return x;

        return parents[x] = find(parents[x], parents);
    }

    static boolean union(int x, int y, int parents[], int ranks[]) {
        x = find(x, parents);
        y = find(y, parents);

        if (x == y) return false;

        if (ranks[x] < ranks[y]) {
            parents[x] = y;
        } else if (ranks[x] > ranks[y]) {
            parents[y] = x;
        } else {
            parents[y] = x;
            ranks[x]++;
        }
        return true;
    }

    static List[] prim(int N, int arr[][]) {
        List<Integer> graph[] = new List[N + 1];
        int dist[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];
        int pre[] = new int[N + 1];
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        int cnt = N;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            if (cur.i != 1) {
                graph[pre[cur.i]].add(cur.i);
                graph[cur.i].add(pre[cur.i]);
            }
            if (--cnt == 0) break;

            for (int next = 1; next <= N; next++) {
                int nw = Math.abs(arr[cur.i][next] - arr[next][cur.i]);
                if (dist[next] <= nw) continue;

                pq.offer(new Node(next, nw));
                dist[next] = nw;
                pre[next] = cur.i;
            }
        }

        return graph;
    }
}