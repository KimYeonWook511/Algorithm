import java.io.*;
import java.util.*;

public class Main {
    static class Dot {
        int r, c;

        Dot(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int arr[][] = new int[R][C];
        boolean chk[][] = new boolean[R][C];
        Deque<Dot> deque = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            String line = br.readLine();

            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c);

                if (arr[r][c] == '.') continue;

                if (arr[r][c] == '#') chk[r][c] = true;
                else deque.offer(new Dot(r, c));
            }
        }

        Deque<Dot> deque2 = new ArrayDeque<>();
        int result[] = new int[2];
        Dot cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (chk[cur.r][cur.c]) continue;

            deque2.offer(cur);
            chk[cur.r][cur.c] = true;

            int cnt[] = new int[2];
            Dot cur2;
            while (!deque2.isEmpty()) {
                cur2 = deque2.poll();

                if (arr[cur2.r][cur2.c] == 'o') cnt[0]++;
                else if (arr[cur2.r][cur2.c] == 'v') cnt[1]++;

                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = cur2.r + dr[d];
                    nc = cur2.c + dc[d];

                    if (nr < 0 || nc < 0) continue;
                    if (nr >= R || nc >= C) continue;
                    if (chk[nr][nc]) continue;

                    deque2.offer(new Dot(nr, nc));
                    chk[nr][nc] = true;
                }
            }

            if (cnt[0] > cnt[1]) result[0] += cnt[0];
            else result[1] += cnt[1];
        }

        System.out.println(result[0] + " " + result[1]);

        br.close();
    }
}