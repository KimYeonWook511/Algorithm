import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, cnt, d;

        Node (int r, int c, int cnt, int d) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.d = d;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int dt[] = {1, 3};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int laser[][] = new int[2][2];
        int laserIdx = 0;
        boolean arr[][] = new boolean[H][W];
        for (int r = 0; r < H; r++) {
            String line = br.readLine();
            
            for (int c = 0; c < W; c++) {
                char ch = line.charAt(c);

                arr[r][c] = ch == '*';

                if (ch == 'C') {
                    laser[laserIdx][0] = r;
                    laser[laserIdx][1] = c;
                    laserIdx++;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.cnt, o2.cnt);
            }
        });
        boolean chk[][][] = new boolean[H][W][4];

        for (int d = 0; d < 4; d++) {
            pq.offer(new Node(laser[0][0], laser[0][1], 0, d));
        }

        boolean flag = false;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (chk[cur.r][cur.c][cur.d]) continue;
            chk[cur.r][cur.c][cur.d] = true;

            int r = cur.r;
            int c = cur.c;
            while (true) {
                int nr = r + dr[cur.d];
                int nc = c + dc[cur.d];

                if (nr < 0 || nc < 0) break;
                if (nr >= H || nc >= W) break;
                if (arr[nr][nc]) break;
                if (chk[nr][nc][cur.d]) break;
                
                if (nr == laser[1][0] && nc == laser[1][1]) {
                    System.out.println(cur.cnt);
                    flag = true;
                    break;
                }

                // 우측, 좌측
                for (int d = 0; d < 2; d++) {
                    int nd = (cur.d + dt[d]) % 4;

                    if (chk[nr][nc][nd]) continue;

                    pq.offer(new Node(nr, nc, cur.cnt + 1, nd));
                }

                chk[nr][nc][cur.d] = true;
                r = nr;
                c = nc;
            }

            if (flag) break;
        }

        br.close();
    }
}