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
    static int N, M, wallCount;
    static boolean map[][];
    static Node virusArr[];
    static int virusIndex = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        virusArr = new Node[10];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    map[r][c] = true;
                    wallCount++;
                } else if (num == 2) {
                    Node virus = new Node(r, c, 0);
                    virusArr[virusIndex++] = virus;
                }
            }
        }

        func(0, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }

    static void func(int start, int selectedCount, int selectedBit) {
        if (selectedCount == M) {
            int ret = bfs(selectedBit);

            if (ret != -1) {
                answer = Math.min(answer, ret);
            }

            return;
        }

        for (int i = start; i < virusIndex; i++) {
            func(i + 1, selectedCount + 1, selectedBit | (1 << i));
        }
    }

    static int bfs(int selectedBit) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][N];

        for (int i = 0; i < virusIndex; i++) {
            if ((selectedBit & (1 << i)) != 0) {
                Node virus = virusArr[i];
                deque.offer(new Node(virus.r, virus.c, 0));
                visited[virus.r][virus.c] = true;
            }
        }

        int cnt = N * N - wallCount;
        int ret = -1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            if (--cnt == 0) {
                ret = cur.t;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (map[nr][nc]) continue;
                if (visited[nr][nc]) continue;

                deque.offer(new Node(nr, nc, cur.t + 1));
                visited[nr][nc] = true;
            }
        }

        return ret;
    }
}