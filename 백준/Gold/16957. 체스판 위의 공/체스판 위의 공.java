import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int parent[][];
    static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int map[][] = new int[R][C];
        parent = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                parent[r][c] = -1;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int min = map[r][c];
                int minIndex = -1;
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0) continue;
                    if (nr >= R || nc >= C) continue;

                    if (map[nr][nc] < min) {
                        min = map[nr][nc];
                        minIndex = nr * C + nc;
                    }
                }

                if (minIndex != -1) {
                    union(r * C + c, minIndex);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(parent[r][c] > 0 ? 0 : -parent[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int find(int x) {
        int r = x / C;
        int c = x % C;

        if (parent[r][c] < 0) return x;

        return parent[r][c] = find(parent[r][c]);
    }

    static void union(int from, int to) {
        from = find(from);
        to = find(to);

        if (from == to) return;

        parent[to / C][to % C] += parent[from / C][from % C]; // 개수 증가
        parent[from / C][from % C] = to;
    }
}