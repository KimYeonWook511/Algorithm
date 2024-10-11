import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, w;

        Node (int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        List<Node> graphRev[] = new ArrayList[N + 1];
        int minW[] = new int[N + 1];
        int minWRev[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            graphRev[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
            minWRev[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, w));
            graphRev[e].add(new Node(s, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });

        pq.offer(new Node(X, 0));
        minW[X] = 0;

        Node cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (minW[cur.idx] < cur.w) continue;

            for (Node next : graph[cur.idx]) {
                if (minW[next.idx] <= cur.w + next.w) continue;

                minW[next.idx] = cur.w + next.w;
                pq.offer(new Node(next.idx, cur.w + next.w));
            }
        }

        int max = 0;

        pq.offer(new Node(X, 0));
        minWRev[X] = 0;

        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (minWRev[cur.idx] < cur.w) continue;

            max = Math.max(max, cur.w + minW[cur.idx]);

            for (Node next : graphRev[cur.idx]) {
                if (minWRev[next.idx] <= cur.w + next.w) continue;

                minWRev[next.idx] = cur.w + next.w;
                pq.offer(new Node(next.idx, cur.w + next.w));
            }
        }

        System.out.println(max);

        br.close();
    }
}