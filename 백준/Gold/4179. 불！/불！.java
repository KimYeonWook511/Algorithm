import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        int arr[][] = new int[R][C];
        int start[] = new int[2];

        for (int r = 0; r < R; r++) {
            String line = br.readLine();

            for (int c = 0; c < C; c++) {
                char ch = line.charAt(c);

                if (ch == '#') {
                    arr[r][c] = -1;

                } else if (ch == 'J') {
                    start[0] = r;
                    start[1] = c;

                } else if (ch == 'F') {
                    deque.offer(new int[]{r, c, 0});
                    arr[r][c] = 1;
                }
            }
        }

        int cur[];
        while (!deque.isEmpty()) {
            cur = deque.poll();

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = dr[d] + cur[0];
                nc = dc[d] + cur[1];

                if (nr < 0 || nc < 0) continue;
                if (nr >= R || nc >= C) continue;
                if (arr[nr][nc] == -1) continue;
                if (arr[nr][nc] > 0) continue;

                deque.offer(new int[]{nr, nc, cur[2] + 1});
                arr[nr][nc] = cur[2] + 1;
            }
        }

        deque.offer(new int[]{start[0], start[1], 0});
        arr[start[0]][start[1]] = -1;

        int result = 0;
        while (!deque.isEmpty()) {
            cur = deque.poll();

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = dr[d] + cur[0];
                nc = dc[d] + cur[1];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    result = cur[2] + 1;
                    break;
                }

                if (arr[nr][nc] != 0 && arr[nr][nc] <= cur[2] + 1) continue;

                deque.offer(new int[]{nr, nc, cur[2] + 1});
                arr[nr][nc] = -1;
            }

            if (result != 0) break;
        }

        System.out.println(result == 0 ? "IMPOSSIBLE" : result);

        br.close();
    }
}