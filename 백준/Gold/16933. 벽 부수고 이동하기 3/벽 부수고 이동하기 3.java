import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, k;
        int cnt;

        Node (int r, int c, int k, int cnt) {
            this.r = r;
            this.c = c;
            this.k = k;
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
        int K = Integer.parseInt(st.nextToken());

        boolean map[][] = new boolean[N][M];
        int visited[][] = new int[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c) == '0';
                visited[r][c] = Integer.MAX_VALUE;
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(0, 0, 0, 1));
        visited[0][0] = 0;

        int answer = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                answer = cur.cnt;
                break;
            }

            // 이미 k가 작은 Node가 있음
            if (visited[cur.r][cur.c] < cur.k) {
                continue;
            }

            if (cur.cnt % 2 == 1) {
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nc < 0) continue;
                    if (nr >= N || nc >= M) continue;

                    if (map[nr][nc]) {
                        if (visited[nr][nc] > cur.k) {
                            deque.offer(new Node(nr, nc, cur.k, cur.cnt + 1));
                            visited[nr][nc] = cur.k;
                        }
                    } else {
                        if (cur.k + 1 <= K && visited[nr][nc] > cur.k + 1) {
                            deque.offer(new Node(nr ,nc, cur.k + 1, cur.cnt + 1));
                            visited[nr][nc] = cur.k + 1;
                        }
                    }
                }
            } else {
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nc < 0) continue;
                    if (nr >= N || nc >= M) continue;
                    if (!map[nr][nc]) continue;
                    if (visited[nr][nc] <= cur.k) continue;

                    deque.offer(new Node(nr, nc, cur.k, cur.cnt + 1));
                    visited[nr][nc] = cur.k;
                }
                // 제자리에 머물기 (밤일때만)
                cur.cnt++;
                deque.offer(cur);
            }
        }

        System.out.println(answer);

        br.close();
    }
}