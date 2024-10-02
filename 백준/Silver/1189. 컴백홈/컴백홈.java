import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K, cnt;
    static boolean arr[][], chk[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[R][C];
        chk = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String line = br.readLine();

            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c) == '.' ? true : false;
            }
        }

        chk[R - 1][0] = true;
        func(R - 1, 0, 1);

        System.out.println(cnt);

        br.close();
    }

    static void func(int r, int c, int sum) {
        if (r == 0 && c == C - 1) {
            if (sum == K) cnt++;

            return;
        }

        int nr, nc;
        for (int d = 0; d < 4; d++) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 0 || nc < 0) continue;
            if (nr >= R || nc >= C) continue;
            if (chk[nr][nc]) continue;
            if (!arr[nr][nc]) continue;

            chk[nr][nc] = true;
            func(nr, nc, sum + 1);
            chk[nr][nc] = false;
        }
    }
}