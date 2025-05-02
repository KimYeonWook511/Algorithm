import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> graph[];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            int treeCnt = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;

                if (bfs(i)) treeCnt++;
            }

            sb.append("Case ").append(t++).append(": ");

            if (treeCnt == 0) sb.append("No trees.\n");
            else if (treeCnt == 1) sb.append("There is one tree.\n");
            else sb.append("A forest of ").append(treeCnt).append(" trees.\n");
        }

        System.out.println(sb);

        br.close();
    }

    static boolean bfs(int i) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(i);
        visited[i] = true;

        int nodeCnt = 0;
        int edgeCnt = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            nodeCnt++;

            for (int next : graph[cur]) {
                edgeCnt++;

                if (visited[next]) continue;

                deque.offer(next);
                visited[next] = true;
            }
        }

        return nodeCnt == (edgeCnt >> 1) + 1;
    }
}