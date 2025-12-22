import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, d;

        Node (int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int dr[] = {0, -1, 0};
    static int dc[] = {-1, 0, 1};

    static int N, M, D, select[];
    static boolean arr[][];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++){
                arr[r][c] = st.nextToken().charAt(0) == '1';
            }
        }

        select = new int[3];
        comb(0, 0);

        System.out.println(answer);

        br.close();
    }

    static void comb(int cnt, int startIdx) {
        if (cnt == 3) {
            run();
            return;
        }

        for (int i = startIdx; i < M; i++) {
            select[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
    static void run() {
        boolean isKilled[][] = new boolean[N][M];
        Node targets[] = new Node[3];
        int cnt = 0;
        for (int r = N; r > 0; r--) {
            if (cnt + N * 3 <= answer) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                targets[i] = searchTarget(r - 1, select[i], isKilled);
            }

            for (int i = 0; i < 3; i++) {
                if (targets[i] != null && !isKilled[targets[i].r][targets[i].c]) {
                    isKilled[targets[i].r][targets[i].c] = true;
                    cnt++;
                }
            }
        }

        answer = Math.max(answer, cnt);
    }

    static Node searchTarget(int r, int c, boolean isKilled[][]) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        deque.add(new Node(r, c, 1));
        visited[r][c] = true;

        Node ret = null;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();

            // 적이 있는 칸 && 죽이지도 않은 칸
            if (arr[cur.r][cur.c] && !isKilled[cur.r][cur.c]) {
                ret = cur;
                break;
            }

            // 최대 사거리인 상태
            if (cur.d == D) continue;

            for (int d = 0; d < 3; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nc < 0 || nr < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;

                deque.offer(new Node(nr, nc, cur.d + 1));
                visited[nr][nc] = true;
            }
        }

        return ret;
    }
}