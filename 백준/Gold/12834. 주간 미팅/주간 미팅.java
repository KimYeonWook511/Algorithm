import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, l;

        Node (int i, int l) {
            this.i = i;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;

        int home[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        List<Node> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, l));
            graph[b].add(new Node(a, l));
        }
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.l, o2.l);
                }
            });
            boolean visited[] = new boolean[V];
            int minL[] = new int[V];

            for (int k = 0; k < V; k++) {
                minL[k] = Integer.MAX_VALUE;
            }

            pq.offer(new Node(home[i], 0));
            minL[home[i]] = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (visited[cur.i]) continue;
                visited[cur.i] = true;

                for (Node next : graph[cur.i]) {
                    if (minL[next.i] <= cur.l + next.l) continue;

                    minL[next.i] = cur.l + next.l;
                    pq.offer(new Node(next.i, cur.l + next.l));
                }
            }

            result += (minL[A] == Integer.MAX_VALUE ? -1 : minL[A]) + (minL[B] == Integer.MAX_VALUE ? -1 : minL[B]);
        }

        System.out.println(result);

        br.close();
    }
}