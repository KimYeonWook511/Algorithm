import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());

            if (w == 0) break;

            int h = Integer.parseInt(st.nextToken());

            boolean arr[][] = new boolean[h + 2][w + 2];
            for (int r = 1; r <= h; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 1; c <= w; c++) {
                    if (st.nextToken().charAt(0) == '1') arr[r][c] = true;
                }
            }

            boolean chk[][] = new boolean[h + 2][w + 2];
            Deque<int[]> deque = new ArrayDeque<>();
            int cnt = 0;

            for (int r = 1; r <= h; r++) {
                for (int c = 1; c <= w; c++) {
                    if (!arr[r][c] || chk[r][c]) continue;

                    cnt++;
                    deque.offer(new int[]{r, c});
                    chk[r][c] = true;

                    while (!deque.isEmpty()) {
                        int cur[] = deque.poll();
                        int nr, nc;

                        for (int i = 0; i < 8; i++) {
                            nr = cur[0] + dr[i];
                            nc = cur[1] + dc[i];

                            if (chk[nr][nc]) continue;
                            if (!arr[nr][nc]) continue;

                            chk[nr][nc] = true;
                            deque.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}