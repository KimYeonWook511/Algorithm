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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        deque.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        int result = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                result = Math.min(result, cur.t);
                break;
            }

            if (cur.t == T) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (arr[nr][nc] == 1) continue;
                
                if (arr[nr][nc] == 2) {
                    int nt = (cur.t + 1) + (N - 1 - nr) + (M - 1 - nc);

                    if (nt <= T) result = Math.min(result, nt);
                    visited[nr][nc] = true;

                    continue;
                }

                deque.offer(new Node(nr, nc, cur.t + 1));
                visited[nr][nc] = true;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? "Fail" : result);

        br.close();
    }
}