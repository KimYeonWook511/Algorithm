import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    static class Node {
        int r, c;

        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) - '0';
            }
        }

        int result = 0;
        boolean chk[][] = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (chk[r][c]) continue;

                result += bfs(r, c, arr, chk);
            }
        }

        System.out.println(result);

        br.close();
    }

    static int bfs(int r, int c, int arr[][], boolean chk[][]) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        deque.offer(new Node(r, c));
        visited[r][c] = true;

        int minWall = 10;
        int cnt = 0;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            cnt++;

            if (arr[cur.r][cur.c] == arr[r][c]) {
                // bfs 덜 돌게 하기
                chk[cur.r][cur.c] = true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    minWall = 0;
                    continue;
                }

                if (visited[nr][nc]) continue;

                if (arr[nr][nc] > arr[r][c]) {
                    minWall = Math.min(minWall, arr[nr][nc]);
                    continue;
                }

                deque.offer(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return minWall == 0 ? 0 : (minWall - arr[r][c]) * cnt;
    }
}