import java.io.*;
import java.util.*;

public class Main {
    static class G {
        int r, c;

        G (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        Deque<G> deque = new ArrayDeque<>();
        int max = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!arr[r][c]) continue;

                int size = 1;
                arr[r][c] = false;
                deque.offer(new G(r, c));

                G cur;
                while (!deque.isEmpty()) {
                    cur = deque.poll();

                    int nr, nc;
                    for (int d = 0; d < 4; d++) {
                        nr = cur.r + dr[d];
                        nc = cur.c + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= N || nc >= M) continue;
                        if (!arr[nr][nc]) continue;

                        arr[nr][nc] = false;
                        deque.offer(new G(nr, nc));
                        size++;
                    }
                }

                max = Math.max(max, size);
            }
        }

        System.out.println(max);

        br.close();
    }
}