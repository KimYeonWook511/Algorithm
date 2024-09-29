import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, val;

        Node (int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();

            for (int c = 0 ; c < C; c++) {
                arr[r][c] = line.charAt(c) == 'L' ? true : false;
            }
        }

        boolean chk[][];
        Deque<Node> deque;
        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!arr[r][c]) continue;

                chk = new boolean[R][C];
                deque = new ArrayDeque<>();

                deque.offer(new Node(r, c, 0));
                chk[r][c] = true;

                Node cur;
                while (!deque.isEmpty()) {
                    cur = deque.poll();

                    max = Math.max(max, cur.val);

                    int nr, nc;
                    for (int d = 0; d < 4; d++) {
                        nr = cur.r + dr[d];
                        nc = cur.c + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= R || nc >= C) continue;
                        if (chk[nr][nc]) continue;
                        if (!arr[nr][nc]) continue;

                        chk[nr][nc] = true;
                        deque.offer(new Node(nr, nc, cur.val + 1));
                    }
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}