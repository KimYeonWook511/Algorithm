import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> graph[] = new ArrayList[N + 1];
        int parent[] = new int[N + 1];

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
        deque.offer(1);
        parent[1] = 1;

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (int next : graph[cur]) {
                if (parent[next] != 0) continue;

                parent[next] = cur;
                deque.offer(next);
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}