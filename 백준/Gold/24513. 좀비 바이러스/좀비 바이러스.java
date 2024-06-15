import java.io.*;
import java.util.*;

public class Main {
    static class Virus {
        int r, c, num, time;

        Virus (int r, int c, int num, int time) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.time = time;
        }
    }

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        int time[][] = new int[N][M];
        int cnt[] = new int[4];
        Deque<Virus> deque = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());

                if (arr[r][c] > 0) {
                    deque.offer(new Virus(r, c, arr[r][c], 1));
                    time[r][c] = 1;
                }
            }
        }

        Virus cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (arr[cur.r][cur.c] == -1) continue;

            cnt[cur.num]++;

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = cur.r + dr[d];
                nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (arr[nr][nc] == -1) continue;
                if (time[nr][nc] == cur.time) continue; // time[nr][nc] < cur.time + 1
                if (arr[nr][nc] == cur.num) continue;

                if (arr[nr][nc] != 0) {
                    cnt[3]++;
                    arr[nr][nc] = -1;
                    continue;
                }

                arr[nr][nc] = cur.num;
                time[nr][nc] = cur.time + 1;
                deque.offer(new Virus(nr, nc, cur.num, cur.time + 1));
            }
        }

        System.out.println(cnt[1] + " " + cnt[2] + " " + cnt[3]);

        br.close();
    }
}