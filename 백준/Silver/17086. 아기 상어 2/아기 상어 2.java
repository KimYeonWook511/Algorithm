import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, dist;

        Node (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        boolean chk[][] = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                if (st.nextToken().equals("0")) continue;

                deque.offer(new Node(r, c, 0));
                chk[r][c] = true;
            }
        }

        Node cur = null;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            int nr, nc;
            for (int d = 0; d < 8; d++) {
                nr = cur.r + dr[d];
                nc = cur.c + dc[d];

                if (nr < 0 || nr >= N) continue;
                if (nc < 0 || nc >= M) continue;
                if (chk[nr][nc]) continue;

                deque.offer(new Node(nr, nc, cur.dist + 1));
                chk[nr][nc] = true;
            }
        }

        System.out.println(cur.dist);

        br.close();
    }
}