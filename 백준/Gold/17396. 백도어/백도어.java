import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i;
        long t;

        Node (int i, long t) {
            this.i = i;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean isWard[] = new boolean[N];
        List<Node> graph[] = new ArrayList[N];
        long minT[] = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isWard[i] = st.nextToken().equals("1");
            graph[i] = new ArrayList<>();
            minT[i] = Long.MAX_VALUE;
        }

        isWard[N - 1] = false;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isWard[a] || isWard[b]) continue;

            int t = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, t));
            graph[b].add(new Node(a, t));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.t, o2.t);
            }
        });
        boolean chk[] = new boolean[N];
        pq.offer(new Node(0, 0));
        minT[0] = 0;

        long result = -1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == N - 1) {
                result = cur.t;
                break;
            }   

            if (chk[cur.i]) continue;
            chk[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (minT[next.i] <= cur.t + next.t) continue;

                minT[next.i] = cur.t + next.t;
                pq.offer(new Node(next.i, cur.t + next.t));
            }
        }

        System.out.println(result);

        br.close();
    }
}