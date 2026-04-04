import java.io.*;
import java.util.*;

public class Main {
    static class Chess {
        int r, c;
        int d;
        Chess up;
        Chess down;

        Chess(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static final int WHITE = 0;
    static final int RED = 1;
    static final int BLUE = 2;

    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int color[][] = new int[N + 2][N + 2];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                color[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= N; i++) {
            color[0][i] = color[N + 1][i] = color[i][0] = color[i][N + 1] = BLUE;
        }

        Chess chess[] = new Chess[K + 1];
        Chess top[][] = new Chess[N + 2][N + 2]; // 최상단
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            chess[i] = new Chess(r, c, d - 1);
            top[r][c] = chess[i];
        }

        int answer = -1;
        for (int t = 1; t <= 1000; t++) {
            for (int i = 1; i <= K; i++) {
                Chess cur = chess[i];

                int nr = cur.r + dr[cur.d];
                int nc = cur.c + dc[cur.d];

                if (color[nr][nc] == BLUE) {
                    cur.d = (cur.d % 2 == 0 ? cur.d + 1 : cur.d - 1);
                    nr = cur.r + dr[cur.d];
                    nc = cur.c + dc[cur.d];
                    if (color[nr][nc] == BLUE) continue;
                }

                Chess nextTop = top[cur.r][cur.c]; // 현재 위치였던 최상단 말 저장
                top[cur.r][cur.c] = cur.down; // 아래에 있던 체스를 지도상 최상단으로
                if (cur.down != null) {
                    // 연결 해제
                    cur.down.up = null;
                    cur.down = null;
                }

                // 뒤집기
                if (color[nr][nc] == RED) {
                    nextTop = cur;
                    while (true) {
                        Chess temp = cur.up;
                        cur.up = cur.down;
                        cur.down = temp;

                        if (temp == null) break;
                        cur = temp;
                    }
                }

                if (top[nr][nc] != null) {
                    if (cur == top[nr][nc]) {
                        System.out.println("t:"+t);
                        System.out.println(nr+" "+nc);
                    }
                    cur.down = top[nr][nc];
                    top[nr][nc].up = cur;
                }
                top[nr][nc] = nextTop;

                if (checkSize(nr, nc, top)) {
                    answer = t;
                    break;
                }
            }

            if (answer != -1) break;
        }

        System.out.println(answer);

        br.close();
    }

    static boolean checkSize(int r, int c, Chess top[][]) {
        Chess cur = top[r][c];
        int size = 0;
        while (cur != null) {
            size++;
            // 좌표 수정
            cur.r = r;
            cur.c = c;
            cur = cur.down;
        }
        return size >= 4;
    }
}