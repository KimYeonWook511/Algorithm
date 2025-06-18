import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> path[];
    static boolean chk[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Integer> graph[] = new ArrayList[N + 1];
            path = new ArrayList[N + 1];
            int visited[] = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                path[i] = new ArrayList<>();
                visited[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph[A].add(B);
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.offer(new int[]{1, 0});
            visited[1] = 0;

            while (!deque.isEmpty()) {
                int cur[] = deque.poll();

                if (cur[0] == N) break;

                for (int next : graph[cur[0]]) {
                    if (visited[next] < cur[1] + 1) continue;

                    if (visited[next] > cur[1] + 1) {
                        deque.offer(new int[]{next, cur[1] + 1});
                        visited[next] = cur[1] + 1;
                    }
                    path[next].add(cur[0]);    
                }
            }

            chk = new boolean[N + 1];
            func(N);

            for (int i = 1; i <= N; i++) {
                if (!chk[i]) continue;

                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int N) {
        chk[N] = true;

        for (int pre : path[N]) {
            if (chk[pre]) continue;

            func(pre);
        }
    }
}