import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;

        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int N;
    static boolean road[][][], cow[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        road = new boolean[N][N][4]; // 0: 남 / 1: 동 / 2: 북 / 3: 서
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            if (r1 - r2 == 0) {
                // 가로 길
                road[r1][c1][c1 - c2 + 2] = true;
                road[r2][c2][c2 - c1 + 2] = true;

            } else {
                // 세로 길
                road[r1][c1][r1 - r2 + 1] = true;
                road[r2][c2][r2 - r1 + 1] = true;
            }
        }

        cow = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            cow[r][c] = true;
        }
        
        boolean visited[][] = new boolean[N][N];

        int result = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) continue;

                int val = bfs(r, c, visited);
                K -= val;
                result += val * K; 
            }
        }

        System.out.println(result);

        br.close();
    }

    static int bfs(int r, int c, boolean visited[][]) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(r, c));
        visited[r][c] = true;
        
        int cnt = 0;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cow[cur.r][cur.c]) cnt++;

            for (int d = 0; d < 4; d++) {
                if (road[cur.r][cur.c][d]) continue; // 길을 건너야 함

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;

                deque.offer(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return cnt;
    }
}