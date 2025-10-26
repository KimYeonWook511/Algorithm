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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph[h1].add(new Node(h2, k));
            graph[h2].add(new Node(h1, k));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -Integer.compare(o1.w, o2.w);
            }
        });
        int maxW[] = new int[N + 1];
        boolean visited[] = new boolean[N + 1];
        pq.offer(new Node(start, Integer.MAX_VALUE));
        maxW[start] = Integer.MAX_VALUE;

        int answer = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            if (cur.i == end) {
                answer = cur.w;
                break;
            }

            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;

                int val = Math.min(cur.w, next.w);
                if (maxW[next.i] >= val) continue;

                pq.offer(new Node(next.i, val));
                maxW[next.i] = val;
            }
        }

        System.out.println(answer);

        br.close();
    }
}