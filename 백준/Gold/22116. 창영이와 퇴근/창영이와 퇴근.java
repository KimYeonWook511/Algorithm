import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, max;

        Node (int r, int c, int max) {
            this.r = r;
            this.c = c;
            this.max = max;
        }
    }
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];
        int visited[][] = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                visited[r][c] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.max, o2.max);
            }
        });
        pq.offer(new Node(0, 0, 0));
        visited[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.r == N - 1 && cur.c == N - 1) {
                System.out.println(cur.max);
                break;
            }

            if (cur.max > visited[cur.r][cur.c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;

                int nMax = Math.max(cur.max, Math.abs(arr[nr][nc] - arr[cur.r][cur.c]));
                if (nMax >= visited[nr][nc]) continue;

                pq.offer(new Node(nr, nc, nMax));
                visited[nr][nc] = nMax;
            }
        }

        br.close();
    }
}