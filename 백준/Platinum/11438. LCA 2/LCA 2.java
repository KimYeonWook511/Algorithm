import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> graph[] = new ArrayList[N + 1]; // tree
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int parent[] = new int[N + 1];
        int depth[] = new int[N + 1];
        deque.offer(1);
        parent[1] = 1;
        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : graph[cur]) {
                if (parent[next] != 0) continue;

                deque.offer(next);
                parent[next] = cur;
                depth[next] = depth[cur] + 1;
            }
        }

        // 희소 배열
        int LOG = 1;
        while ((1 << LOG) <= N - 1) {
            LOG++;
        }
        int next[][] = new int[LOG][N + 1]; // v에서 출발하여 2^k후엔 도착
        for (int v = 1; v <= N; v++) {
            next[0][v] = parent[v];
        }
        // v에서 출발하여 2^k번
        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= N; v++) {
                next[k][v] = next[k - 1][next[k - 1][v]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (depth[a] < depth[b]) {
                b = jump(depth[b] - depth[a], b, next);
            } else if (depth[a] > depth[b]) {
                a = jump(depth[a] - depth[b], a, next);
            }

            if (a == b) {
                sb.append(a).append("\n");
                continue;
            }

            for (int k = LOG - 1; k >= 0; k--) {
                if (next[k][a] != next[k][b]) {
                    a = next[k][a];
                    b = next[k][b];
                }
            }

            sb.append(next[0][a]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int jump(int bit, int v, int next[][]) {
        int cur = v;
        for (int i = 0; i < next.length; i++) { // next.length == LOG
            if (((1 << i) & bit) != 0) {
                cur = next[i][cur];
            }
        }
        return cur;
    }
}