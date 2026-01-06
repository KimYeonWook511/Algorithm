import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int u, v, w;

        Edge (int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static int parents[];
    static int ranks[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            Edge edges[] = new Edge[M];
            parents = new int[N + 1];
            ranks = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(u, v, w);
            }

            Arrays.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Integer.compare(o1.w, o2.w);
                }
            });

            boolean flag = false;
            for (int i = 0; i < M; i++) {
                Edge cur = edges[i];

                if (union(cur.u, cur.v)) {
                    if ((cur.u == p && cur.v == q) || (cur.u == q && cur.v == p)) {
                        flag = true;
                        break;
                    }
                }
            }

            sb.append(flag ? "YES\n" : "NO\n");
        }

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
            parents[y] = x;
            ranks[x]++;
        }
        return true;
    }
}