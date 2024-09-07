import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        Deque<int[]> deque = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                char ch = line.charAt(c);

                if (ch == 'O') continue;

                if (ch == 'X') arr[r][c] = -1;
                else if (ch == 'P') arr[r][c] = 1;
                else {
                    arr[r][c] = -1;
                    deque.offer(new int[]{r, c});
                }
            }
        }

        int cnt = 0;
        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= N) continue;
                if (nc < 0 || nc >= M) continue;
                if (arr[nr][nc] == -1) continue;

                if (arr[nr][nc] == 1) cnt++;

                arr[nr][nc] = -1;
                deque.offer(new int[]{nr, nc});
            }
        }

        System.out.println(cnt == 0 ? "TT" : cnt);

        br.close();
    }
}