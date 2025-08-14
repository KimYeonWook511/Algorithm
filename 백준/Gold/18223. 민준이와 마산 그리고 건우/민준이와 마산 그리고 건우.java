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

    static int V, E, P;
    static List<Node> graph[];
    static int minWFrom1[], minWFromP[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V + 1];
        minWFrom1 = new int[V + 1];
        minWFromP = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            minWFrom1[i] = Integer.MAX_VALUE;
            minWFromP[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dijk(1, minWFrom1);
        dijk(P, minWFromP);

        System.out.println(minWFrom1[P] != Integer.MAX_VALUE && minWFrom1[V] == minWFrom1[P] + minWFromP[V] ? "SAVE HIM" : "GOOD BYE");

        br.close();
    }

    static void dijk(int start, int minW[]) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[V + 1];
        pq.offer(new Node(start, 0));
        minW[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == V) return;
            
            if (visited[cur.i]) continue;
            visited[cur.i] = true;
            
            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;
                if (minW[next.i] <= cur.w + next.w) continue;

                pq.offer(new Node(next.i, cur.w + next.w));
                minW[next.i] = cur.w + next.w;
            }
        }
    }
}