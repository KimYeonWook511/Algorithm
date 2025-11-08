import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            List<Integer> graph[] = new List[M + 1];
            int indegree[] = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graph[A].add(B);
                indegree[B]++;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            int strahler[] = new int[M + 1];
            int cnt[] = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                if (indegree[i] == 0) {
                    deque.offer(i);
                    strahler[i] = 1;
                }
            }

            int answer = 0;
            while (!deque.isEmpty()) {
                int cur = deque.poll();

                for (int next : graph[cur]) {
                    indegree[next]--;

                    if (strahler[next] < strahler[cur]) {
                        strahler[next] = strahler[cur];
                        cnt[next] = 1;
                    } else if (strahler[next] == strahler[cur]) {
                        cnt[next]++;
                    }

                    if (indegree[next] == 0) {
                        deque.offer(next);
                        if (cnt[next] >= 2) {
                            strahler[next] += 1;
                        }
                        answer = Math.max(answer, strahler[next]);
                    }
                }
            }

            sb.append(K).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}