import java.io.*;
import java.util.*;

public class Main {
    static class Wave {
        int r, c, cnt;

        Wave (int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
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

        st = new StringTokenizer(br.readLine());
        int start[] = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        int end[] = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            
            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) == '1';
            }
        }

        arr[end[0]][end[1]] = false;

        Deque<Wave> deque = new ArrayDeque<>();
        boolean chk[][] = new boolean[N][M];
        deque.offer(new Wave(start[0], start[1], 0));
        chk[start[0]][start[1]] = true;

        while (!deque.isEmpty()) {
            Wave cur = deque.poll();

            if (cur.r == end[0] && cur.c == end[1]) {
                System.out.println(cur.cnt + 1);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (chk[nr][nc]) continue;

                chk[nr][nc] = true;

                if (arr[nr][nc]) deque.offer(new Wave(nr, nc, cur.cnt + 1));
                else deque.offerFirst(new Wave(nr, nc, cur.cnt));
            }
        }

        br.close();
    }
}