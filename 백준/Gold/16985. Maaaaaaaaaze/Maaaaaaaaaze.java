import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_LAYER = 5;
    static final int MAX_SIZE = 5;
    static boolean cube[][][][] = new boolean[MAX_LAYER][4][MAX_SIZE][MAX_SIZE];
    static int selected[] = new int[MAX_LAYER];
    static int rotation[] = new int[MAX_LAYER];

    static class Node {
        int l, r, c;
        int cnt;

        Node (int l, int r, int c, int cnt) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < MAX_LAYER; i++) {
            for (int r = 0; r < MAX_SIZE; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < MAX_SIZE; c++) {
                    boolean canMove = st.nextToken().equals("1");
                    // 시계 0도
                    cube[i][0][r][c] = canMove;
                    // 시계 90도 (c, N - r)
                    cube[i][1][c][(MAX_SIZE - 1) - r] = canMove;
                    // 시계 180도
                    cube[i][2][(MAX_SIZE - 1) - r][(MAX_SIZE - 1) - c] = canMove;
                    // 시계 270도
                    cube[i][3][(MAX_SIZE - 1) - c][r] = canMove;
                }
            }
        }

        permute(0, 0);

        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);

        br.close();
    }

    static void permute(int layer, int bit) {
        if (layer == MAX_LAYER) {
            setRotation(0);
            return;
        }

        for (int i = 0; i < MAX_SIZE; i++) {
            if ((bit & (1 << i)) != 0) continue;

            selected[layer] = i;
            permute(layer + 1, bit | (1 << i));
        }
    }

    static void setRotation(int layer) {
        if (layer == MAX_LAYER) {
            bfs();
            return;
        }

        for (int rot = 0; rot < 4; rot++) {
            rotation[layer] = rot;
            setRotation(layer + 1);
        }
    }

    static void bfs() {
        // 시작하는 점이 막혀있는가
        if (!cube[selected[0]][rotation[0]][0][0]) return;
        // 도착하는 점이 막혀있는가
        if (!cube[selected[MAX_LAYER - 1]][rotation[MAX_LAYER - 1]][MAX_SIZE - 1][MAX_SIZE - 1]) return;

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][][] = new boolean[MAX_LAYER][MAX_SIZE][MAX_SIZE];
        deque.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if ((cur.l == MAX_LAYER - 1) && (cur.r == MAX_SIZE - 1) && (cur.c == MAX_SIZE - 1)) {
                answer = Math.min(answer, cur.cnt);
                return;
            }

            if (cur.cnt >= answer) {
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= MAX_SIZE || nc >= MAX_SIZE) continue;
                if (visited[cur.l][nr][nc]) continue;
                if (!cube[selected[cur.l]][rotation[cur.l]][nr][nc]) continue;

                deque.offer(new Node(cur.l, nr, nc, cur.cnt + 1));
                visited[cur.l][nr][nc] = true;
            }

            if (cur.l - 1 >= 0) {
                if (!visited[cur.l - 1][cur.r][cur.c] && cube[selected[cur.l - 1]][rotation[cur.l - 1]][cur.r][cur.c]) {
                    deque.offer(new Node(cur.l - 1, cur.r, cur.c, cur.cnt + 1));
                    visited[cur.l - 1][cur.r][cur.c] = true;
                }
            }

            if (cur.l + 1 < MAX_LAYER) {
                if (!visited[cur.l + 1][cur.r][cur.c] && cube[selected[cur.l + 1]][rotation[cur.l + 1]][cur.r][cur.c]) {
                    deque.offer(new Node(cur.l + 1, cur.r, cur.c, cur.cnt + 1));
                    visited[cur.l + 1][cur.r][cur.c] = true;
                }
            }
        }
    }
}