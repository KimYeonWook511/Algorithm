import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx;
        long i;

        Node (int idx, long i) {
            this.idx = idx;
            this.i = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        long dist[] = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }

        for (long i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, i));
            graph[B].add(new Node(A, i));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.i, o2.i);
            }
        });
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.idx == N) {
                System.out.println(cur.i);
                break;
            }

            if (cur.i > dist[cur.idx]) continue; // 같은 것은 아래 for문에서 넣질 않을거라 거를 필요가 없음

            for (Node next : graph[cur.idx]) {
                long preI = cur.i % M;
                long nextI = cur.i - preI + next.i + (preI > next.i ? M : 0);

                if (dist[next.idx] <= nextI + 1) continue;

                pq.offer(new Node(next.idx, nextI + 1));
                dist[next.idx] = nextI + 1;
            }
        }

        br.close();
    }
}