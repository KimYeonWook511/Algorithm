import java.io.*;
import java.util.*;

public class Main {
    static boolean arr[][] = new boolean[5][5];
    static int selected[] = new int[7];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 5; r++) {
            String line = br.readLine();

            for (int c = 0; c < 5; c++) {
                arr[r][c] = line.charAt(c) == 'S';
            }
        }

        selectFunc(0, -1, 0);

        System.out.println(result);

        br.close();
    }

    static void selectFunc(int i, int pre, int cntY) {
        if (i == 7) {
            if (cal()) result++;

            return;
        }

        for (int now = pre + 1; now < 25 - (6 - i); now++) {
            boolean isS = arr[now / 5][now % 5];

            if (!isS && cntY == 3) continue;

            selected[i] = now;
            selectFunc(i + 1, now, cntY + (isS ? 0 : 1));
        }
    }

    static boolean cal() {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean chk[][] = new boolean[5][5];

        for (int i = 0; i < 7; i++) {
            int r = selected[i] / 5;
            int c = selected[i] % 5;

            chk[r][c] = true;
        }

        deque.offer(new int[]{selected[0] / 5, selected[0] % 5});
        chk[selected[0] / 5][selected[0] % 5] = false;

        int cnt = 0;
        while (!deque.isEmpty()) {
            int cur[] = deque.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= 5 || nc >= 5) continue;
                if (!chk[nr][nc]) continue;

                deque.offer(new int[]{nr, nc});
                chk[nr][nc] = false;
            }
        }

        return cnt == 7;
    }
}