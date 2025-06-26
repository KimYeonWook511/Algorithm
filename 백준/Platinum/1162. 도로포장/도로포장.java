import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, cnt;
        long w;

        Node (int i, long w, int cnt) {
            this.i = i;
            this.w = w;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        long minW[][] = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();

            for (int k = 0; k <= K; k++) {
                minW[i][k] = Long.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w, 0));
            graph[b].add(new Node(a, w, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.w, o2.w);
            }
        });
        boolean visited[][] = new boolean[N + 1][K + 1];
        pq.offer(new Node(1, 0, 0));
        minW[1][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == N) {
                System.out.println(cur.w);
                break;
            }

            if (visited[cur.i][cur.cnt]) continue;
            visited[cur.i][cur.cnt] = true;

            for (Node next : graph[cur.i]) {
                // 포장 x
                if (minW[next.i][cur.cnt] > cur.w + next.w) {
                    minW[next.i][cur.cnt] = cur.w + next.w;
                    pq.offer(new Node(next.i, cur.w + next.w, cur.cnt));
                }

                // 포장 o
                if (cur.cnt + 1 <= K && minW[next.i][cur.cnt + 1] > cur.w) {
                    minW[next.i][cur.cnt + 1] = cur.w;
                    pq.offer(new Node(next.i, cur.w, cur.cnt + 1));
                }
            }
        }

        br.close();
    }
}