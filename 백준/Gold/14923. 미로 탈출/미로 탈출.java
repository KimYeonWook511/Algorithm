import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        int cnt;
        boolean isUsed;

        Node (int r, int c, int cnt, boolean isUsed) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isUsed = isUsed;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        int Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        int Ey = Integer.parseInt(st.nextToken()) - 1;

        boolean map[][] = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][][] = new boolean[2][N][M];
        deque.offer(new Node(Hx, Hy, 0, false));
        visited[0][Hx][Hy] = true;

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.r == Ex && cur.c == Ey) {
                answer = cur.cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;

                if (map[nr][nc]) {
                    if (!cur.isUsed && !visited[1][nr][nc]) {
                        deque.offer(new Node(nr, nc, cur.cnt + 1, true));
                        visited[1][nr][nc] = true;
                    }
                } else {
                    if (!visited[cur.isUsed ? 1 : 0][nr][nc]) {
                        deque.offer(new Node(nr, nc, cur.cnt + 1, cur.isUsed));
                        visited[cur.isUsed ? 1 : 0][nr][nc] = true;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}