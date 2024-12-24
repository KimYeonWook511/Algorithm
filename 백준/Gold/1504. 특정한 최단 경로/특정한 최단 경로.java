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

    static int N, E;
    static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        int minW[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int result1 = func(1, v1) + func(v1, v2) + func(v2, N);

        // 1 -> v2 -> v1 -> N
        int result2 = func(1, v2) + func(v2, v1) + func(v1, N);

        System.out.println(result1 > 200_000_000 && result2 > 200_000_000 ? -1 : Math.min(result1, result2));

        br.close();
    }

    static int func(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean chk[] = new boolean[N + 1];
        int minW[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            minW[i] = 200_000_001;
        }

        pq.offer(new Node(start, 0));
        minW[start] = 0;

        Node cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (chk[cur.i]) continue;
            if (cur.w > minW[cur.i]) continue;
            if (cur.i == end) break;

            chk[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (chk[next.i]) continue;
                if (cur.w + next.w >= minW[next.i]) continue;

                minW[next.i] = cur.w + next.w;
                pq.offer(new Node(next.i, cur.w + next.w));
            }
        }

        return minW[end];
    }
}