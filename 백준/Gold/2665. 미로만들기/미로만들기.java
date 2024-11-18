import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    static class Node {
        int r, c, w;

        Node (int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean arr[][] = new boolean[n][n];
        int chk[][] = new int[n][n];

        for (int r = 0; r < n; r++) {
            String line = br.readLine();

            for (int c = 0; c < n; c++) {
                arr[r][c] = line.charAt(c) == '1' ? true : false;
                chk[r][c] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        pq.offer(new Node(0, 0, 0));
        chk[0][0] = 0;

        Node cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (cur.w > chk[cur.r][cur.c]) continue;
            if (cur.r == n - 1 && cur.c == n - 1) {
                System.out.println(cur.w);
                break;
            }

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = cur.r + dr[d];
                nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= n || nc >= n) continue;

                if (arr[nr][nc]) {
                    if (chk[nr][nc] <= cur.w) continue;

                    pq.offer(new Node(nr, nc, cur.w));
                    chk[nr][nc] = cur.w;

                } else if (chk[nr][nc] > cur.w + 1) {
                    pq.offer(new Node(nr, nc, cur.w + 1));
                    chk[nr][nc] = cur.w + 1;
                }
            }
        }

        br.close();
    }
}