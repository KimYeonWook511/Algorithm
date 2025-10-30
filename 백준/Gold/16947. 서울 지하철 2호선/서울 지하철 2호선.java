import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> graph[];
    static int chk[];
    static int cycleStart;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        chk = new int[N + 1];
        int dist[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1, 0);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(cycleStart);
        dist[cycleStart] = 0;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                deque.offer(next);
                dist[next] = chk[next] > 0 ? 0 : dist[cur] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static int dfs(int cur, int pre) {
        if (chk[cur] == Integer.MIN_VALUE) {
            cycleStart = cur;
            return cur;
        }

        chk[cur] = Integer.MIN_VALUE;
        int ret = -1;
        for (int next : graph[cur]) {
            if (next == pre) continue;
            if (chk[next] > 0 || chk[next] == -1) continue;

            ret = Math.max(ret, dfs(next, cur));
        }

        chk[cur] = ret;
        if (cur == ret) ret = -1; // 사이클의 끝

        return ret;
    }
}