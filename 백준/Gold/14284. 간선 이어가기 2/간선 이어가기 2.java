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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[n + 1];
        int minW[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
        }   

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        pq.offer(new Node(s, 0));
        minW[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == t) {
                System.out.println(cur.w);
                break;
            }

            for (Node next : graph[cur.i]) {
                if (minW[next.i] <= cur.w + next.w) continue;

                minW[next.i] = cur.w + next.w;
                pq.offer(new Node(next.i, cur.w + next.w));
            }
        }

        br.close();
    }
}