import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, w;

        Node (int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int N, M, T, D, arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        int distGo[][] = new int[N][M]; // 호텔에서 가는 것
        int distBack[][] = new int[N][M]; // 호텔로 돌아오는 것

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                char ch = line.charAt(c);
                
                if (ch <= 'Z') arr[r][c] = ch - 'A';
                else arr[r][c] = ch - 'a' + 26;

                distGo[r][c] = 1_000_001;
                distBack[r][c] = 1_000_001;
            }
        }

        dijk(distGo, 1);
        dijk(distBack, -1);

        int result = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (distGo[r][c] + distBack[r][c] > D) continue;

                result = Math.max(result, arr[r][c]);
            }
        }

        System.out.println(result);

        br.close();
    }

    static void dijk(int dist[][], int dir) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        boolean visited[][] = new boolean[N][M];
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.r][cur.c]) continue;
            visited[cur.r][cur.c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;

                int diff = dir * (arr[nr][nc] - arr[cur.r][cur.c]);
                if (diff > T || -diff > T) continue;

                int nw = diff > 0 ? cur.w + (diff * diff) : cur.w + 1;
                if (nw > D) continue;
                if (dist[nr][nc] <= nw) continue;

                pq.offer(new Node(nr, nc, nw));
                dist[nr][nc] = nw;
            }
        }
    }
}