import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> graph[] = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int K = Integer.parseInt(br.readLine());
        int P[] = new int[K];
        boolean isBroken[] = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            isBroken[P[i]] = true;
        }

        boolean isNotBoom[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            // 폭탄이 될 수 없는 도시 체크
            if (!isBroken[i]) {
                isNotBoom[i] = true;
                for (int next : graph[i]) {
                    isNotBoom[next] = true;
                }
            }
        }

        // solve
        boolean isBoom[] = new boolean[N + 1];
        boolean chk[] = new boolean[N + 1]; // 폭탄으로 부숴지는 도시 체크

        int T = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int cur = P[i];

            if (isNotBoom[cur]) {
                continue;
            }

            isBoom[cur] = true;
            chk[cur] = true;
            for (int next : graph[cur]) {
                chk[next] = true;
            }

            T++;
            sb.append(cur).append(" ");
        }

        for (int i = 0; i < K; i++) {
            if (!chk[P[i]]) {
                T = -1;
                break;
            }
        }

        System.out.println(T);
        if (T != -1) {
            System.out.println(sb);
        }

        br.close();
    }
}