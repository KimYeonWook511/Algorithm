import java.io.*;
import java.util.*;

public class Main {
    static class Status {
        int rr, rc;
        int br, bc;
        int cnt;

        Status (int red[], int blue[], int cnt) {
            this.rr = red[0];
            this.rc = red[1];
            this.br = blue[0];
            this.bc = blue[1];
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return String.format("red: %d %d  blue: %d %d  cnt: %d", rr, rc, br, bc, cnt);
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N][M];
        int red[] = null;
        int blue[] = null;
        int end[] = null;

        for (int r = 0; r < N; r++) {
            String input = br.readLine();

            for (int c = 0; c < M; c++) {
                char ch = input.charAt(c);

                if (ch == '#') continue;

                arr[r][c] = true;

                if (ch == 'R') red = new int[]{r, c};
                else if (ch == 'B') blue = new int[]{r, c};
                else if (ch == 'O') end = new int[]{r, c};
            }
        }

        boolean chk[][][][] = new boolean[10][10][10][10];

        Deque<Status> deque = new ArrayDeque<>();
        deque.offer(new Status(red, blue, 1));
        chk[red[0]][red[1]][blue[0]][blue[1]] = true;

        int result = -1;
        Status cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            int nrr, nrc, nbr, nbc;
            for (int d = 0; d < 4; d++) {
                red[0] = cur.rr;
                red[1] = cur.rc;
                blue[0] = cur.br;
                blue[1] = cur.bc;

                while (true) {
                    nrr = red[0] + dr[d];
                    nrc = red[1] + dc[d];

                    if (!arr[nrr][nrc]) break;

                    red[0] = nrr;
                    red[1] = nrc;

                    if (nrr == end[0] && nrc == end[1]) break;
                }

                while (true) {
                    nbr = blue[0] + dr[d];
                    nbc = blue[1] + dc[d];

                    if (!arr[nbr][nbc]) break;

                    blue[0] = nbr;
                    blue[1] = nbc;

                    if (nbr == end[0] && nbc == end[1]) break;
                }

                if (blue[0] == end[0] && blue[1] == end[1]) continue;
                if (red[0] == end[0] && red[1] == end[1]) {
                    result = cur.cnt;
                    break;
                }

                if (cur.cnt == 10) continue;

                if (red[0] == blue[0] && red[1] == blue[1]) {
                    if (d == 0) {
                        if (cur.rr > cur.br) red[0]++;
                        else blue[0]++;

                    } else if (d == 1) {
                        if (cur.rc > cur.bc) blue[1]--;
                        else red[1]--;

                    } else if (d == 2) {
                        if (cur.rr > cur.br) blue[0]--;
                        else red[0]--;

                    } else {
                        if (cur.rc > cur.bc) red[1]++;
                        else blue[1]++;
                    }
                }

                if (chk[red[0]][red[1]][blue[0]][blue[1]]) continue;

                chk[red[0]][red[1]][blue[0]][blue[1]] = true;
                deque.offer(new Status(red, blue, cur.cnt + 1));
            }

            if (result != -1) break;
        }

        System.out.println(result);

        br.close();
    }
}