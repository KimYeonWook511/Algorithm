import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> graph[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        int parent[] = new int[N + 1];
        int depth[] = new int[N + 1];
        deque.offer(1);
        parent[1] = -1;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : graph[cur]) {
                if (parent[next] != 0) continue;

                parent[next] = cur;
                depth[next] = depth[cur] + 1;
                deque.offer(next);
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (depth[a] > depth[b]) {
                a = parent[a];
            }

            while (depth[a] < depth[b]) {
                b = parent[b];
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
            }

            sb.append(a).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}