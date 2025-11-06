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
    static final int INF = 50_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> graph[] = new List[N + 1];
        int dist[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, t));
            graph[b].add(new Node(a, t));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[] = new boolean[N + 1];
        int prev[] = new int[N + 1];
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == N) break;

            if (visited[cur.i]) continue;
            visited[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (visited[next.i]) continue;
                if (dist[next.i] <= cur.w + next.w) continue;

                pq.offer(new Node(next.i, cur.w + next.w));
                dist[next.i] = cur.w + next.w;
                prev[next.i] = cur.i;
            }
        }

        int origin = dist[N];
        int answer = -1;
        int b = N;
        while (b != 1) {
            int a = prev[b];

            // a-b 도로 없애고 다익스트라 다시 돌리기
            pq.clear();
            for (int i = 1; i <= N; i++) {
                dist[i] = INF;
            }
            visited = new boolean[N + 1];
            pq.offer(new Node(1, 0));
            dist[1] = 0;

            boolean flag = false;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.i == N) {
                    flag = true;
                    break;
                }

                if (visited[cur.i]) continue;
                visited[cur.i] = true;

                for (Node next : graph[cur.i]) {
                    if (cur.i == a && next.i == b) continue;
                    if (cur.i == b && next.i == a) continue;
                    if (visited[next.i]) continue;
                    if (dist[next.i] <= cur.w + next.w) continue;

                    pq.offer(new Node(next.i, cur.w + next.w));
                    dist[next.i] = cur.w + next.w;
                }
            }

            if (!flag) {
                answer = -1;
                break;
            }

            answer = Math.max(answer, dist[N] - origin);
            b = prev[b];
        }

        System.out.println(answer);

        br.close();
    }
}