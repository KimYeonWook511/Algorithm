import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            boolean arr[][] = new boolean[H][W];

            for (int r = 0; r < H; r++) {
                String input = br.readLine();

                for (int c = 0; c < W; c++) {
                    arr[r][c] = input.charAt(c) == '#';
                }
            }

            Deque<int[]> deque = new ArrayDeque<>();
            boolean chk[][] = new boolean[H][W];

            int result = 0;
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (!arr[r][c]) continue;
                    if (chk[r][c]) continue;

                    result++;

                    deque.offer(new int[]{r, c});
                    chk[r][c] = true;

                    int cur[];
                    while (!deque.isEmpty()) {
                        cur = deque.poll();

                        int nr, nc;
                        for (int d = 0; d < 4; d++) {
                            nr = cur[0] + dr[d];
                            nc = cur[1] + dc[d];

                            if (nr < 0 || nc < 0) continue;
                            if (nr >= H || nc >= W) continue;
                            if (!arr[nr][nc]) continue;
                            if (chk[nr][nc]) continue;

                            deque.offer(new int[]{nr, nc});
                            chk[nr][nc] = true;
                        }
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}