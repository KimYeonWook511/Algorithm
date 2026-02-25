import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, t;

        Node (int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    static int dr[] = {-1, 0, 1, 0, -1, -1, 1, 1, 0};
    static int dc[] = {0, 1, 0, -1, -1, 1, -1, 1, 0};
    static final int SIZE = 8;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean map[][] = new boolean[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++) {
            String line = br.readLine();
            for (int c = 0; c < SIZE; c++) {
                map[r][c] = line.charAt(c) == '.';
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][][] = new boolean[SIZE + 1][SIZE][SIZE];
        deque.offer(new Node(SIZE - 1, 0, 0));
        visited[0][SIZE - 1][0] = true;

        int answer = 0;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.t == SIZE) {
                answer = 1;
                break;
            }

            for (int d = 0; d < 9; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nt = cur.t + 1;

                if (nr < 0 || nc < 0) continue;
                if (nr >= SIZE || nc >= SIZE) continue;
                if (visited[nt][nr][nc]) continue;

                // 벽이라서 못감
                if (nr - cur.t >= 0 && !map[nr - cur.t][nc]) continue;
                // 벽에 부딪힘
                if (nr - nt >= 0 && !map[nr - nt][nc]) continue;

                deque.offer(new Node(nr, nc, nt));
                visited[nt][nr][nc] = true;
            }
        }

        System.out.println(answer);

        br.close();
    }
}