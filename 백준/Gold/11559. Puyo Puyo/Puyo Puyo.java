import java.io.*;
import java.util.*;

public class Main {
    static int arr[][];
    static boolean chk[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[12][6];
        int cnt[] = new int[6];

        for (int r = 11; r >= 0; r--) {
            String line = br.readLine();

            for (int c = 0; c < 6; c++) {
                arr[r][c] = line.charAt(c);

                if (arr[r][c] != '.') cnt[c]++;
            }
        }
        
        int result = 0;
        while (true) {
            boolean isEnd = true;
            chk = new boolean[12][6];
            
            for (int c = 0; c < 6; c++) {
                for (int r = 0; r < cnt[c]; r++) {
                    if (arr[r][c] == '.') continue;
                    if (chk[r][c]) continue;
                    if (countFunc(r, c) < 4) continue;

                    brokenFunc(r, c);
                    isEnd = false;
                }
            }

            setting(cnt);

            if (isEnd) break;

            result++;
        }

        System.out.println(result);

        br.close();
    }

    static int countFunc(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{r, c});
        chk[r][c] = true;

        int count = 1;
        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= 12 || nc >= 6) continue;
                if (chk[nr][nc]) continue;
                if (arr[nr][nc] != arr[r][c]) continue;

                deque.offer(new int[]{nr ,nc});
                chk[nr][nc] = true;
                count++;
            }
        }

        return count;
    }

    static void brokenFunc(int r, int c) {
        int color = arr[r][c];

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{r, c});
        arr[r][c] = '.';

        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0) continue;
                if (nr >= 12 || nc >= 6) continue;
                if (arr[nr][nc] != color) continue;

                deque.offer(new int[]{nr ,nc});
                arr[nr][nc] = '.';
            }
        }
    }

    static void setting(int cnt[]) {
        for (int c = 0; c < 6; c++) {
            int blankIdx = -1;
            int topIdx = cnt[c];

            for (int r = 0; r < topIdx; r++) {
                if (arr[r][c] == '.') {
                    cnt[c]--;

                    if (blankIdx == -1) blankIdx = r;

                } else if (blankIdx != -1) {
                    arr[blankIdx++][c] = arr[r][c];
                    arr[r][c] = '.';
                }
            }
        }
    }
}
