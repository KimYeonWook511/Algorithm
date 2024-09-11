import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, cnt;

        Node (int r, int c, int cnt) {
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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N][M];
        boolean chk[][] = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                if (line.charAt(c) == '0') continue;

                arr[r][c] = true;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.cnt, o2.cnt);
            }
        });
        pq.offer(new Node(0, 0, 0));
        chk[0][0] = true;

        Node cur = null;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (cur.r == N - 1 && cur.c == M - 1) break;

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = cur.r + dr[d];
                nc = cur.c + dc[d];

                if (nr < 0 || nr >= N) continue;
                if (nc < 0 || nc >= M) continue;
                if (chk[nr][nc]) continue;

                chk[nr][nc] = true;
                pq.offer(new Node(nr, nc, cur.cnt + (arr[nr][nc] ? 1 : 0)));
            }
        }

        System.out.println(cur.cnt);

        br.close();
    }
}