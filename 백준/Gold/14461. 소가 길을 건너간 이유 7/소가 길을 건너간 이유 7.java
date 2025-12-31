import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        int cnt;
        int t;

        public Node(int r, int c, int cnt, int t) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.t = t;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][N];
        int dist[][][] = new int[N][N][3];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                for (int cnt = 0; cnt < 3; cnt++) {
                    dist[r][c][cnt] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.t, o2.t);
            }
        });
        boolean visited[][][] = new boolean[N][N][3];
        pq.offer(new Node(0, 0, 0, 0));
        dist[0][0][0] = 0;

        int answer = -1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.r == N - 1 && cur.c == N - 1) {
                answer = cur.t;
                break;
            }

            if (visited[cur.r][cur.c][cur.cnt]) continue;
            visited[cur.r][cur.c][cur.cnt] = true;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nCnt = (cur.cnt + 1) % 3;

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (visited[nr][nc][nCnt]) continue;

                int nt = cur.t + T;
                if (nCnt == 0) {
                    nt += map[nr][nc];
                }

                if (dist[nr][nc][nCnt] <= nt) continue;

                pq.offer(new Node(nr, nc, nCnt, nt));
                dist[nr][nc][nCnt] = nt;
            }
        }

        // 문제 개념상 int형 범위를 넘어갈 수 없을 것 같은데..?
        System.out.println(answer);

        br.close();
    }
}