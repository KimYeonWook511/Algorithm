import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer> graph[] = new ArrayList[V + 1];
            int chk[] = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
                chk[i] = -1;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean flag = true;
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 1; i <= V; i++) {
                if (!flag) break;
                if (chk[i] != -1) continue;

                deque.offer(i);
                chk[i] = 1;

                int cur;
                while (!deque.isEmpty()) {
                    cur = deque.poll();

                    for (int next : graph[cur]) {
                        if (chk[next] == chk[cur]) {
                            flag = false;
                            break;
                        }

                        if (chk[next] == -1) {
                            deque.offer(next);
                            chk[next] = chk[cur] ^ 1;
                        }
                    }

                    if (!flag) break;
                }
            }

            sb.append(flag ? "YES\n" : "NO\n");
        }

        System.out.println(sb);

        br.close();
    }
}