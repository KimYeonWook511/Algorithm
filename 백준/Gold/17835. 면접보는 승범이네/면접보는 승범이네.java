import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i;
        long w;

        Node (int i, long w) {
            this.i = i;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N + 1];
        long dist[] = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[V].add(new Node(U, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(st.nextToken());
            pq.offer(new Node(k, 0));
            dist[k] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (dist[next.i] <= cur.w + next.w) continue;

                pq.offer(new Node(next.i, cur.w + next.w));
                dist[next.i] = cur.w + next.w;
            }
        }

        int maxIndex= -1;
        long maxDist = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxIndex = i;
                maxDist = dist[i];
            }
        }

        System.out.println(maxIndex);
        System.out.println(maxDist);

        br.close();
    }
}