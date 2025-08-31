import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][];
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};
    static final int WHITE = 0;
    static final int RED = 1;
    static final int BLUE = 2;

    static class Piece {
        int r, c, d;
        int cnt, i;
        Piece link;

        Piece (int r, int c, int d, int cnt, int i) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
            this.i = i;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Piece pieces[] = new Piece[K];
        Piece map[][] = new Piece[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            Piece cur = new Piece(r, c, d, 1, i);
            cur.link = cur;
            pieces[i] = cur;
            map[r][c] = cur;
        }

        int result = -1;
        for (int t = 1; t <= 1000; t++) {
            for (int i = 0; i < K; i++) {
                if (pieces[i] == null) continue;

                Piece cur = pieces[i];
                int nr = cur.r + dr[cur.d];
                int nc = cur.c + dc[cur.d];

                if (isBlue(nr, nc)) {
                    cur.d = cur.d % 2 == 0 ? cur.d + 1 : cur.d - 1;
                    nr = cur.r + dr[cur.d];
                    nc = cur.c + dc[cur.d];

                    if (isBlue(nr, nc)) continue;
                }

                if (arr[nr][nc] == RED) {
                    pieces[cur.i] = null;
                    cur = cur.link;
                    pieces[cur.i] = cur;
                }

                Piece bottom = cur;
                Piece top = cur.link;
                map[cur.r][cur.c] = null;
                bottom.r = nr;
                bottom.c = nc;
                top.r = nr;
                top.c = nc;

                if (map[nr][nc] == null) {
                    map[nr][nc] = bottom;

                } else {
                    pieces[bottom.i] = null; // 업힘 표시
                    bottom = map[nr][nc];
                    
                    int ncnt = bottom.cnt + top.cnt;
                    bottom.cnt = ncnt;
                    top.cnt = ncnt;

                    bottom.link = top;
                    top.link = bottom;

                    if (ncnt >= 4) {
                        result = t;
                        break;
                    }
                }
            }

            if (result != -1) break;
        }

        System.out.println(result);

        br.close();
    }

    static boolean isBlue(int nr, int nc) {
        return (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] == BLUE);
    }
}