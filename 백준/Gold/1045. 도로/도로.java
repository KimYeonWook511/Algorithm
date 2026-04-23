import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int a, b;

        Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static int parents[];
    static int ranks[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        parents = new int[N];
        ranks = new int[N];
        for (int a = 0; a < N; a++) {
            String line = br.readLine();
            for (int b = a + 1; b < N; b++) {
                char ch = line.charAt(b);

                if (ch == 'Y') {
                    edges.add(new Edge(a, b));
                }
            }
            parents[a] = a;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        if (edges.size() >= M) {
            int edgeCount = 0;
            boolean chk[] = new boolean[edges.size()];
            int count[] = new int[N];
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if (union(edge.a, edge.b)) {
                    chk[i] = true;
                    count[edge.a]++;
                    count[edge.b]++;
                    if (++edgeCount == N - 1) break;
                }
            }

            if (edgeCount == N - 1) {
                for (int i = 0; i < edges.size(); i++) {
                    if (edgeCount == M) break;

                    if (!chk[i]) {
                        Edge edge = edges.get(i);
                        count[edge.a]++;
                        count[edge.b]++;
                        edgeCount++;
                    }
                }

                for (int i = 0; i < N; i++) {
                    sb.append(count[i]).append(" ");
                }
                flag = true;
            }
        }

        System.out.println(flag ? sb.toString() : "-1");

        br.close();
    }

    static int find(int x) {
        if (parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (ranks[a] < ranks[b]) {
            parents[a] = b;
        } else if (ranks[a] > ranks[b]) {
            parents[b] = a;
        } else {
            parents[b] = a;
            ranks[a]++;
        }
        return true;
    }
}