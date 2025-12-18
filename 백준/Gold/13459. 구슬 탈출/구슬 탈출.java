import java.io.*;
import java.util.*;

public class Main {
    static class Bead {
        int r, c;

        Bead(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static class Pair {
        Bead blue;
        Bead red;
        int cnt;

        Pair (Bead blue, Bead red, int cnt) {
            this.blue = blue;
            this.red = red;
            this.cnt = cnt;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static char map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        Bead blue = null;
        Bead red = null;
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);

                if (map[r][c] == 'B') {
                    blue = new Bead(r, c);
                    map[r][c] = '.'; // 굳이 안 해도 되긴 함
                } else if (map[r][c] == 'R') {
                    red = new Bead(r, c);
                    map[r][c] = '.'; // 굳이 안 해도 되긴 함
                }
            }
        }

        Deque<Pair> deque = new ArrayDeque<>();
        boolean visited[][][][] = new boolean[N][M][N][M]; // Blue, Red 순
        deque.offer(new Pair(blue, red, 0));
        visited[blue.r][blue.c][red.r][red.c] = true;

        boolean flag = false;
        while (!deque.isEmpty()) {
            Pair cur = deque.poll();

            for (int d = 0; d < 4; d++) {
                Bead nextBlue = move(cur.blue, d);
                if (map[nextBlue.r][nextBlue.c] == 'O') {
                    continue;
                }

                Bead nextRed = move(cur.red, d);
                if (map[nextRed.r][nextRed.c] == 'O') {
                    flag = true;
                    break;
                }

                // 위치 조정 (구슬이 겹치는 경우)
                if (nextBlue.r == nextRed.r && nextBlue.c == nextRed.c) {
                    adjust(cur.blue, cur.red, nextBlue, nextRed, d);
                }

                if (!visited[nextBlue.r][nextBlue.c][nextRed.r][nextRed.c] && cur.cnt + 1 < 10) {
                    deque.offer(new Pair(nextBlue, nextRed, cur.cnt + 1));
                    visited[nextBlue.r][nextBlue.c][nextRed.r][nextRed.c] = true;
                }
            }

            if (flag) break;
        }

        System.out.println(flag ? 1 : 0);

        br.close();
    }

    static Bead move(Bead bead, int d) {
        Bead ret = new Bead(bead.r, bead.c);

        while (true) {
            int nr = ret.r + dr[d];
            int nc = ret.c + dc[d];
            if (map[nr][nc] == '#') {
                break;
            }

            ret.r = nr;
            ret.c = nc;
            if (map[nr][nc] == 'O') {
                break;
            }
        }

        return ret;
    }

    static void adjust(Bead originBlue, Bead originRed, Bead nextBlue, Bead nextRed, int d) {
        if (d == 0) {
            if (originBlue.r > originRed.r) {
                nextBlue.r += 1;
            } else {
                nextRed.r += 1;
            }
        } else if (d == 1) {
            if (originBlue.c < originRed.c) {
                nextBlue.c -= 1;
            } else {
                nextRed.c -= 1;
            }
        } else if (d == 2) {
            if (originBlue.r < originRed.r) {
                nextBlue.r -= 1;
            } else {
                nextRed.r -= 1;
            }
        } else if (d == 3) {
            if (originBlue.c > originRed.c) {
                nextBlue.c += 1;
            } else {
                nextRed.c += 1;
            }
        }
    }
}