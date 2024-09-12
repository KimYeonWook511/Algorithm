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

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            boolean chk[][] = new boolean[h][w];
            Deque<Node> deque = new ArrayDeque<>();
            int start[] = new int[2];

            for (int r = 0; r < h; r++) {
                String line = br.readLine();
                
                for (int c = 0; c < w; c++) {
                    char ch = line.charAt(c);

                    if (ch == '.') continue;

                    if (ch == '@') {
                        start[0] = r;
                        start[1] = c;
                        continue;
                    }

                    if (ch == '*') deque.offer(new Node(r, c, 0));

                    chk[r][c] = true;
                }
            }

            chk[start[0]][start[1]] = true;
            deque.offer(new Node(start[0], start[1], 1));

            int result = 0;
            Node cur;
            while (!deque.isEmpty()) {
                cur = deque.poll();

                if (cur.t > 0) {
                    if (cur.r == 0 || cur.c == 0) {
                        result = cur.t;
                        break;
                    }

                    if (cur.r == h - 1 || cur.c == w - 1) {
                        result = cur.t;
                        break;
                    }
                }

                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = cur.r + dr[d];
                    nc = cur.c + dc[d];

                    if (nr < 0 || nr >= h) continue;
                    if (nc < 0 || nc >= w) continue;
                    if (chk[nr][nc]) continue;

                    chk[nr][nc] = true;
                    deque.offer(new Node(nr, nc, cur.t == 0 ? 0 : cur.t + 1));
                }
            }

            sb.append(result == 0 ? "IMPOSSIBLE" : result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}