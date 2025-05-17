import java.io.*;
import java.util.*;

public class Main {
    static class Virus {
        int num, r, c, cnt;

        Virus (int num, int r, int c, int cnt) {
            this.num = num;
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
        int K = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][N];
        List<Virus> virusList[] = new ArrayList[K + 1];
        for (int i = 1; i <= K; i++) {
            virusList[i] = new ArrayList<>();
        }

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                int num = Integer.parseInt(st.nextToken());

                if (num != 0) {
                    arr[r][c] = num;
                    virusList[num].add(new Virus(num, r, c, 0));
                }
            }
        }

        Deque<Virus> deque = new ArrayDeque<>();
        for (int i = 1; i <= K; i++) {
            for (Virus next : virusList[i]) {
                deque.offer(next);
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while (!deque.isEmpty()) {
            Virus cur = deque.poll();

            if (cur.cnt == S) break;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= N) continue;
                if (arr[nr][nc] != 0) continue;

                arr[nr][nc] = cur.num;
                deque.offer(new Virus(cur.num, nr, nc, cur.cnt + 1));
            }
        }

        System.out.println(arr[X - 1][Y - 1]);

        br.close();
    }
}