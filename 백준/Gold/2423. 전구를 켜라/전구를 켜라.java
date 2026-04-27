import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int dr[] = {-1, -1, 1, 1};
    static int dc[] = {-1, 1, 1, -1};
    static int drTile[] = {-1, -1, 0, 0};
    static int dcTile[] = {-1, 0, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean map[][] = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c) == '\\'; // true: '\' | false: '/'
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        int dist[][] = new int[N + 1][M + 1];
        for (int r = 0; r <= N; r++) {
            for (int c = 0; c <= M; c++) {
                dist[r][c] = Integer.MAX_VALUE;
            }
        }
        deque.offer(new Node(0, 0));
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.r == N && cur.c == M) break;

            for (int d = 0; d < 4; d++) {
                int tileR = cur.r + drTile[d];
                int tileC = cur.c + dcTile[d];
                if (tileR < 0 || tileC < 0) continue;
                if (tileR >= N || tileC >= M) continue;

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < 0 || nc < 0) continue;
                if (nr > N || nc > M) continue;

                int cost = (map[tileR][tileC] == (d % 2 == 0)) ? 0 : 1;
                if (dist[nr][nc] <= dist[cur.r][cur.c] + cost) continue;

                dist[nr][nc] = dist[cur.r][cur.c] + cost;
                if (cost == 0) {
                    deque.offerFirst(new Node(nr, nc));
                } else {
                    deque.offerLast(new Node(nr, nc));
                }
            }
        }

        System.out.println(dist[N][M] == Integer.MAX_VALUE ? "NO SOLUTION" : dist[N][M]);

        br.close();
    }
}