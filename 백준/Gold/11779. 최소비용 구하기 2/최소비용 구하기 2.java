import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int i, w, depth;

        Node (int i, int w, int depth) {
            this.i = i;
            this.w = w;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node> graph[] = new ArrayList[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        int minW[] = new int[n + 1];
        boolean chk[] = new boolean[n + 1];

        int depth = 0;
        List<Integer> path[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            minW[i] = Integer.MAX_VALUE;
            path[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            graph[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        pq.offer(new Node(start, 0, 1));
        minW[start] = 0;
        path[start].add(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.i == end) {
                sb.append(cur.w).append("\n");
                sb.append(cur.depth).append("\n");
                depth = cur.depth;
                break;
            }

            if (cur.w > minW[cur.i]) continue;
            if (chk[cur.i]) continue;

            chk[cur.i] = true;

            for (Node next : graph[cur.i]) {
                if (minW[next.i] < cur.w + next.w) continue;

                if (minW[next.i] > cur.w + next.w) {
                    path[next.i].clear();
                    pq.offer(new Node(next.i, cur.w + next.w, cur.depth + 1));
                    minW[next.i] = cur.w + next.w;
                }

                path[next.i].add(cur.i);
            }
        }

        int pathResult[] = new int[depth];

        for (int i = depth - 1; i >= 0; i--) {
            pathResult[i] = end;

            end = path[end].get(0);
        }

        for (int i = 0; i < depth; i++) {
            sb.append(pathResult[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}