import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, cnt;
        boolean isBreak;

        Node (int r, int c, int cnt, boolean isBreak) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N][M];
        boolean chk[][][] = new boolean[2][N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) == '0' ? true : false;
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(0, 0, 1, false));
        chk[0][0][0] = true;

        int result = -1;
        Node cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                result = cur.cnt;
                break;
            }

            int nr, nc;
            if (!cur.isBreak) {
                for (int d = 0; d < 4; d++) {
                    nr = cur.r + dr[d];
                    nc = cur.c + dc[d];
    
                    if (nr < 0 || nc < 0) continue;
                    if (nr >= N || nc >= M) continue;
                    
                    if (arr[nr][nc]) {
                        if (chk[0][nr][nc]) continue;

                        deque.offer(new Node(nr, nc, cur.cnt + 1, false));
                        chk[0][nr][nc] = true;

                    } else {
                        if (chk[1][nr][nc]) continue;

                        deque.offer(new Node(nr, nc, cur.cnt + 1, true));
                        chk[1][nr][nc] = true;
                    }
                }

            } else {
                for (int d = 0; d < 4; d++) {
                    nr = cur.r + dr[d];
                    nc = cur.c + dc[d];
    
                    if (nr < 0 || nc < 0) continue;
                    if (nr >= N || nc >= M) continue;
                    if (!arr[nr][nc]) continue;
                    if (chk[1][nr][nc]) continue;
    
                    deque.offer(new Node(nr, nc, cur.cnt + 1, true));
                    chk[1][nr][nc] = true;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}