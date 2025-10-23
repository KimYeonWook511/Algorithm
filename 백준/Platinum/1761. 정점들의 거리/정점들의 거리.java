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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Node> graph[] = new ArrayList[N + 1]; // tree
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        int LOG = 1;
        while ((1 << LOG) <= N - 1) {
            LOG++;
        }
        int next[][] = new int[LOG][N + 1];
        int dist[][] = new int[LOG][N + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        int parent[] = new int[N + 1];
        int depth[] = new int[N + 1];
        deque.offer(1);
        parent[1] = 1;
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (Node nextNode : graph[cur]) {
                if (parent[nextNode.i] != 0) continue;

                deque.offer(nextNode.i);
                parent[nextNode.i] = cur;
                depth[nextNode.i] = depth[cur] + 1;
                next[0][nextNode.i] = cur;
                dist[0][nextNode.i] = nextNode.w;
            }
        }

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= N; v++) {
                next[k][v] = next[k - 1][next[k - 1][v]];
                dist[k][v] = dist[k - 1][v] + dist[k - 1][next[k - 1][v]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = 0;
            if (depth[a] < depth[b]) {
                int val[] = jump(b, depth[b] - depth[a], next, dist);
                b = val[0];
                sum += val[1];
            } else {
                int val[] = jump(a, depth[a] - depth[b], next, dist);
                a = val[0];
                sum += val[1];
            }

            if (a != b) {
                for (int k = LOG - 1; k >= 0; k--) {
                    if (next[k][a] != next[k][b]) {
                        sum += dist[k][a];
                        sum += dist[k][b];
                        a = next[k][a];
                        b = next[k][b];
                    }
                }

                sum += dist[0][a];
                sum += dist[0][b];
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int[] jump(int start, int bit, int next[][], int dist[][]) {
        int cur = start;
        int sum = 0;
        for (int k = 0; k < next.length; k++) {
            if (((1 << k) & bit) != 0) {
                sum += dist[k][cur];
                cur = next[k][cur];
            }
        }
        return new int[]{cur, sum};
    }
}