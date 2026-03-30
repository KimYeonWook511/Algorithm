import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        int cnt;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                int val = Integer.parseInt(st.nextToken());
                arr[r][c] = (arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1]) + val;
            }
        }

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int finishR = Integer.parseInt(st.nextToken());
        int finishC = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N + 1][M + 1];
        deque.offer(new Node(startR, startC, 0));
        visited[startR][startC] = true;

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.r == finishR && cur.c == finishC) {
                answer = cur.cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr <= 0 || nc <= 0) continue; // 좌상단
                if (nr + (H - 1) > N || nc + (W - 1) > M) continue; // 우하단
                if (visited[nr][nc]) continue;

                if (arr[nr + (H - 1)][nc + (W - 1)] - arr[nr + (H - 1)][nc - 1] - arr[nr - 1][nc + (W - 1)] + arr[nr - 1][nc - 1] == 0) {
                    deque.offer(new Node(nr, nc, cur.cnt + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}