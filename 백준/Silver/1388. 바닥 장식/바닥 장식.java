import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean arr[][], chk[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        String line = "";

        for (int r = 0; r < N; r++) {
            line = br.readLine();

            for (int c = 0; c < M; c++) {
                if (line.charAt(c) == '-') arr[r][c] = true;
            }
        }

        chk = new boolean[N][M];
        int cnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (chk[r][c]) continue;

                cnt++;
                chk[r][c] = true;

                if (arr[r][c]) func(r, c + 1, true);
                else func(r + 1, c, false);
            }
        }

        System.out.println(cnt);

        br.close();
    }

    static void func(int r, int c, boolean b) {
        if (r >= N) return;
        if (c >= M) return;
        if (chk[r][c]) return;
        if (arr[r][c] != b) return;

        chk[r][c] = true;

        if (arr[r][c]) func(r, c + 1, true);
        else func(r + 1, c, false);
    }
}