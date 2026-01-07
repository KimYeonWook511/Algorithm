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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N + 1][N + 1];
        for (int r = 1; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = r + 1; c <= N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
            arr[r][r] = Integer.MAX_VALUE;
        }

        // 크루스칼
        // List<Integer> anwer[] = kruskal(N, arr);
        // 프림
        List<Integer> answer[] = prim(N, arr);

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