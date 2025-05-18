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
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new ArrayList[N];
        int minW[] = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
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
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N];
        pq.offer(new Node(Y, 0));
        minW[Y] = 0;

        int cnt = 0;
        int day = 1;
        int dist = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            if ((cur.w << 1) > X) {
                day = -1;
                break;
            }

            cnt++;
            dist += (cur.w << 1);
            if (dist > X) {
                day++;
                dist = (cur.w << 1);
            }

            for (Node next : graph[cur.i]) {
                if (minW[next.i] < cur.w + next.w) continue;

                minW[next.i] = cur.w + next.w;
                pq.offer(new Node(next.i, cur.w + next.w));
            }
        }

        System.out.println(cnt == N ? day : -1);

        br.close();
    }
}