import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean graph[][] = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                if (!graph[s][m]) continue;

                for (int e = 1; e <= N; e++) {
                    graph[s][e] |= graph[s][m] && graph[m][e];
                }
            }
        }

        int result = 0;
        for (int m = 1; m <= N; m++) {
            int cnt = 0;

            for (int s = 1; s <= N; s++) {
                if (s == m) continue;
                if (graph[s][m]) cnt++;
            }

            for (int e = 1; e <= N; e++) {
                if (m == e) continue;
                if (graph[m][e]) cnt++;
            }

            if (cnt == N - 1) result++;
        }

        System.out.println(result);

        br.close();
    }
}