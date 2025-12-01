import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 10_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int map[][] = new int[n + 1][n + 1];
        int next[][] = new int[n + 1][n + 1];
        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {
                map[start][end] = INF;
            }
            map[start][start] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
            next[a][b] = b;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                if (map[start][mid] == INF) continue;

                for (int end = 1; end <= n; end++) {
                    if (start == end || map[mid][end] == INF) continue;
                    if (map[start][end] <= map[start][mid] + map[mid][end]) continue;

                    map[start][end] = map[start][mid] + map[mid][end];
                    next[start][end] = next[start][mid];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {
                if (map[start][end] == INF) {
                    map[start][end] = 0;
                }

                sb.append(map[start][end]).append(" ");
            }
            sb.append("\n");
        }

        for (int start = 1; start <= n; start++) {
            for (int end = 1; end <= n; end++) {
                if (map[start][end] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }

                StringBuilder temp = new StringBuilder();
                int cur = start;
                int cnt = 0;
                while (cur != 0) {
                    temp.append(cur).append(" ");
                    cur = next[cur][end];
                    cnt++;
                }
                sb.append(cnt).append(" ").append(temp).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}