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
    static int h, w;
    static int arr[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arr = new int[h + 2][w + 2];
            Node prisoners[] = new Node[2];
            int prisonerIndex = 0;
            for (int r = 1; r <= h; r++) {
                String line = br.readLine();
                for (int c = 1; c <= w; c++) {
                    char ch = line.charAt(c - 1);

                    if (ch == '*') {
                        arr[r][c] = -1;
                    } else if (ch == '#') {
                        arr[r][c] = 1;
                    } else if (ch == '$') {
                        prisoners[prisonerIndex++] = new Node(r, c, 0);
                    }
                }
            }

            int dp[][][] = new int[3][h + 2][w + 2];
            for (int i = 0; i < 3; i++) {
                for (int r = 0; r < h + 2; r++) {
                    for (int c = 0; c < w + 2; c++) {
                        dp[i][r][c] = Integer.MAX_VALUE;
                    }
                }
            }

            // 첫 번째 죄수
            bfs(prisoners[0].r, prisoners[0].c, dp[0]);
            // 두 번째 죄수
            bfs(prisoners[1].r, prisoners[1].c, dp[1]);
            // 바깥
            bfs(0, 0, dp[2]);

            int answer = Integer.MAX_VALUE;
            for (int r = 0; r < h + 2; r++) {
                for (int c = 0; c < w + 2; c++) {
                    if (arr[r][c] == -1) continue;

                    answer = Math.min(answer, dp[0][r][c] + dp[1][r][c] + dp[2][r][c] + (arr[r][c] == 1 ? -2 : 0));
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void bfs(int r, int c, int dp[][]) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(r, c, 0));
        dp[r][c] = 0;

        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr > h + 1 || nc > w + 1) continue;
                if (arr[nr][nc] == -1) continue;
                if (dp[nr][nc] != Integer.MAX_VALUE) continue;

                if (arr[nr][nc] == 0) {
                    deque.offerFirst(new Node(nr, nc, cur.cnt));
                    dp[nr][nc] = cur.cnt;
                } else {
                    // 문
                    deque.offerLast(new Node(nr, nc, cur.cnt + 1));
                    dp[nr][nc] = cur.cnt + 1;
                }
            }
        }
    }
}