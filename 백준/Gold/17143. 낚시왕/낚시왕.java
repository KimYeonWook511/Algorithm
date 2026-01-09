import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int r, c;
        int s, d;
        int z;

        Shark (int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int myDir[] = {0, 0, 2, 1, 3};

    static int R, C, M;
    static int ROW, COL;
    static int arr[][];
    static Shark sharks[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ROW = R - 1;
        COL = C - 1;

        arr = new int[R][C];
        sharks = new Shark[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, myDir[d], z);
            arr[r][c] = i;
        }

        int answer = 0;
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (arr[r][c] != 0) {
                    int idx = Math.abs(arr[r][c]);
                    answer += sharks[idx].z;
                    sharks[idx] = null;
                    arr[r][c] = 0;
                    break;
                }
            }

            // 상어 이동
            moveShark(c % 2 == 0 ? -1 : 1);
        }

        System.out.println(answer);

        br.close();
    }

    static void moveShark(int turn) {
        for (int i = 1; i <= M; i++) {
            if (sharks[i] == null) continue;

            Shark cur = sharks[i];
            int nr = cur.r + ((dr[cur.d] * cur.s) % (2 * ROW));
            int nc = cur.c + ((dc[cur.d] * cur.s) % (2 * COL));

            // 0 9 8 7 6 | 5 4 3 2 1 | 0 1 2 3 4 5 | 6 7 8 9 0 | 1 2 3 4 5
            // 0 1 2 3 4 | 5 4 3 2 1 |       x     | 4 3 2 1 0 | 1 2 3 4 5
            if (nr < 0) {
                nr = -nr;
                if (nr <= ROW) {
                    cur.d = (cur.d + 2) % 4;
                } else {
                    nr = ROW - (nr - ROW);
                }
            }

            if (nr >= R) {
                nr -= 2 * ROW;
                if (nr <= 0) {
                    nr = -nr;
                    cur.d = (cur.d + 2) % 4;
                }
            }

            if (nc < 0) {
                nc = -nc;
                if (nc <= COL) {
                    cur.d = (cur.d + 2) % 4;
                } else {
                    nc = COL - (nc - COL);
                }
            }

            if (nc >= C) {
                nc -= 2 * COL;
                if (nc <= 0) {
                    nc = -nc;
                    cur.d = (cur.d + 2) % 4;
                }
            }

            // 이전 흔적 지우기
            if (arr[cur.r][cur.c] == (i * turn * -1)) {
                arr[cur.r][cur.c] = 0;
            }
            cur.r = nr;
            cur.c = nc;

            if (arr[nr][nc] * turn > 0) {
                // 같은 칸에 같은 시간에 움직인 상어 존재함
                if (sharks[arr[nr][nc] * turn].z < cur.z) {
                    // 상어 잡아 먹기
                    sharks[arr[nr][nc] * turn] = null;
                    arr[nr][nc] = i * turn;
                } else {
                    // 현재 상어 잡아 먹힘
                    sharks[i] = null;
                }
            } else {
                arr[nr][nc] = i * turn;
            }
        }
    }
}