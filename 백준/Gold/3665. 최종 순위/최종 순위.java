import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            boolean graph[][] = new boolean[n + 1][n + 1]; // r to c
            int indegree[] = new int[n + 1];

            int arr[] = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                for (int k = 1; k < i; k++) {
                    graph[arr[k]][arr[i]] = true;
                    indegree[arr[i]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[b][a] = true;
                    indegree[a]++;
                    graph[a][b] = false;
                    indegree[b]--;
                } else {
                    graph[a][b] = true;
                    indegree[b]++;
                    graph[b][a] = false;
                    indegree[a]--;
                }
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    // indegree가 0인 것은 무조건 하나만 존재함
                    // 최상 루트(1등)이랑은 다 연결돼 있어서 이걸 뒤집으면 결국 indegree[1] > 0이 되기 때문임
                    deque.offer(i);
                    break;
                }
            }

            int result[] = new int[n];
            int resultIndex = 0;
            while (!deque.isEmpty()) {
                int cur = deque.poll();

                // indegree가 동시에 0(공동 순위)이 될 수가 있나?
                result[resultIndex++] = cur;

                for (int next = 1; next <= n; next++) {
                    if (!graph[cur][next]) continue;

                    if (--indegree[next] == 0) deque.offer(next);
                }
            }

            if (resultIndex != n) {
                // 기존 순위의 연관관계 때문에 edge수가 보존되므로 "?"(indegree가0인 것이 동시에 두 개 이상)인 경우는 안 나오지 않나?
                sb.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(result[i]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}