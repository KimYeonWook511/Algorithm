import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, cost;

        Node (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        boolean chk[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
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
                return Integer.compare(o1.cost, o2.cost);
            }
        });
        pq.offer(new Node(1, 0));

        int sum = 0;
        int max = 0;

        Node cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (chk[cur.idx]) continue;

            chk[cur.idx] = true;
            sum += cur.cost;
            max = Math.max(max, cur.cost);

            for (Node next : graph[cur.idx]) {
                if (chk[next.idx]) continue;

                pq.offer(next);
            }
        }

        System.out.println(sum - max);

        br.close();
    }
}