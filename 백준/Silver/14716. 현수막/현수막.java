import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[M][N];
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = st.nextToken().charAt(0) == '1' ? true : false;
            }
        }

        boolean chk[][] = new boolean[M][N];
        Deque<int[]> deque = new ArrayDeque<>();

        int result = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!arr[r][c] || chk[r][c]) continue;

                deque.offer(new int[]{r, c});
                chk[r][c] = true;

                int cur[];
                while (!deque.isEmpty()) {
                    cur = deque.poll();

                    int nr, nc;
                    for (int d = 0; d < 8; d++) {
                        nr = cur[0] + dr[d];
                        nc = cur[1] + dc[d];

                        if (nr < 0 || nc < 0) continue;
                        if (nr >= M || nc >= N) continue;
                        if (chk[nr][nc]) continue;
                        if (!arr[nr][nc]) continue;

                        deque.offer(new int[]{nr, nc});
                        chk[nr][nc] = true;
                    }
                }

                result++;
            }
        }

        System.out.println(result);

        br.close();
    }
}