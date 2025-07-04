import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, d;

        Node (int i, int d) {
            this.i = i;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean gender[] = new boolean[N + 1]; // true: Man / false: Woman
        List<Node> graph[] = new ArrayList[N + 1];
        int minD[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken().equals("M");
            graph[i] = new ArrayList<>();
            minD[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, d));
            graph[v].add(new Node(u, d));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.d, o2.d);
            }
        });
        boolean visited[] = new boolean[N + 1];
        pq.offer(new Node(1, 0));
        minD[1] = 0;

        int cnt = N;
        int result = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            result += cur.d;
            if (--cnt == 0) break;

            for (Node next : graph[cur.i]) {
                if (minD[next.i] <= next.d) continue;
                if (gender[next.i] == gender[cur.i]) continue;

                pq.offer(next);
                minD[next.i] = next.d;
            }
        }
        
        System.out.println(cnt == 0 ? result : -1);
    
        br.close();
    }
} 