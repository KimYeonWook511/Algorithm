import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v, p;

        Node (int v, int p) {
            this.v = v;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            List<Node> graph[] = new ArrayList[N];
            int minP[] = new int[N];
            boolean remove[][] = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                minP[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                graph[u].add(new Node(v, p));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.p, o2.p);
                }
            });
            boolean chk[] = new boolean[N];
            List<Integer> path[] = new ArrayList[N];

            pq.offer(new Node(S, 0));
            minP[S] = 0;
            path[S] = new ArrayList<>();
            path[D] = new ArrayList<>();

            Node cur;
            while (!pq.isEmpty()) {
                cur = pq.poll();

                if (cur.p > minP[cur.v]) continue;
                if (cur.v == D) continue;
                if (chk[cur.v]) continue;

                chk[cur.v] = true;

                for (Node next : graph[cur.v]) {
                    if (minP[next.v] < cur.p + next.p) continue;

                    if (minP[next.v] > cur.p + next.p) {
                        path[next.v] = new ArrayList<>();
                        minP[next.v] = cur.p + next.p;
                        pq.offer(new Node(next.v, cur.p + next.p));
                    }

                    path[next.v].add(cur.v);
                }
            }

            Deque<Integer> removeDeque = new ArrayDeque<>();
            removeDeque.offer(D);

            while (!removeDeque.isEmpty()) {
                int curIdx = removeDeque.poll();

                if (remove[curIdx][curIdx]) continue;
                remove[curIdx][curIdx] = true;
                
                for (int pre : path[curIdx]) {
                    if (remove[pre][curIdx]) continue;

                    removeDeque.offer(pre);
                    remove[pre][curIdx] = true;
                }
            }

            for (int i = 0; i < N; i++) {
                minP[i] = Integer.MAX_VALUE;
                chk[i] = false;
            }
            
            pq.offer(new Node(S, 0));
            minP[S] = 0;

            int result = -1;
            while (!pq.isEmpty()) {
                cur = pq.poll();

                if (cur.v == D) {
                    result = cur.p;
                    break;
                }

                if (cur.p > minP[cur.v]) continue;
                if (chk[cur.v]) continue;

                chk[cur.v] = true;

                for (Node next : graph[cur.v]) {
                    if (remove[cur.v][next.v]) continue;
                    if (minP[next.v] <= cur.p + next.p) continue;

                    minP[next.v] = cur.p + next.p;
                    pq.offer(new Node(next.v, cur.p + next.p));
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}