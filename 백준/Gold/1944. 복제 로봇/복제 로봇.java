import java.io.*;
import java.util.*;

public class Main {
    static class Key {
        int r, c;

        Key (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][N];
        Key keys[] = new Key[M + 2];
        int keyIndex = 1;
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < N; c++) {
                char ch = line.charAt(c);

                if (ch == 'S') {
                    keys[M + 1] = new Key(r, c); // 시작점
                    arr[r][c] = M + 1;
                } else if (ch == 'K') {
                    keys[keyIndex] = new Key(r, c);
                    arr[r][c] = keyIndex;
                    keyIndex++;
                } else if (ch == '1') {
                    arr[r][c] = -1;
                }
            }
        }

        int dist[][] = new int[M + 2][M + 2];
        for (int i = 1; i <= M + 1; i++) {
            for (int k = 1; k <= M + 1; k++) {
                dist[i][k] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= M; i++) {
            Key key = keys[i];

            // bfs
            Deque<int[]> deque = new ArrayDeque<>();
            boolean visited[][] = new boolean[N][N];
            deque.offer(new int[]{key.r, key.c, 0});
            visited[key.r][key.c] = true;

            while (!deque.isEmpty()) {
                int cur[] = deque.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (arr[nr][nc] == -1) continue;
                    if (visited[nr][nc]) continue;

                    if (arr[nr][nc] > 0) {
                        dist[i][arr[nr][nc]] = cur[2] + 1;
                        dist[arr[nr][nc]][i] = cur[2] + 1;
                    }
                    deque.offer(new int[]{nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println(mst(M, dist));

        br.close();
    }

    static int mst(int M, int dist[][]) {
        int minDist[] = new int[M + 2];
        for (int i = 1; i <= M + 1; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        boolean visited[] = new boolean[M + 2];
        pq.offer(new int[]{M + 1, 0});
        minDist[M + 1] = 0;

        int sum = 0;
        int cnt = M + 1;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;

            sum += cur[1];
            if (--cnt == 0) {
                break;
            }

            for (int next = 1; next <= M; next++) {
                if (visited[next]) continue;
                if (minDist[next] <= dist[cur[0]][next]) continue;

                pq.offer(new int[]{next, dist[cur[0]][next]});
                minDist[next] = dist[cur[0]][next];
            }
        }

        return cnt == 0 ? sum : -1;
    }
}