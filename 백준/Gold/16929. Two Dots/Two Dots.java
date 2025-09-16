import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char map[][];
    static boolean visited[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int startDot[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);
            }
        }

        startDot = new int[2];
        boolean flag = false;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                startDot[0] = r;
                startDot[1] = c;
                if (func(r, c, 1)) {
                    flag = true;
                    r = N;
                    break;
                }
            }
        }

        System.out.println(flag ? "Yes" : "No");

        br.close();
    }

    static boolean func(int r, int c, int cnt) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0) continue;
            if (nr >= N || nc >= M) continue;
            if (map[nr][nc] != map[startDot[0]][startDot[1]]) continue;
            if (visited[nr][nc]) continue;

            if (nr == startDot[0] && nc == startDot[1]) {
                if (cnt >= 4) return true;

                continue;
            }

            visited[nr][nc] = true;
            if (func(nr, nc, cnt + 1)) return true;
            visited[nr][nc] = false;
        }

        return false;
    }
}