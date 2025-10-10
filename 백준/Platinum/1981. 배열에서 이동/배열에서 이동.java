import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int n, arr[][];
    static boolean visited[][];
    static int min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int left = 0;
        int right = 200;
        while (left <= right) {
            int gap = (left + right) / 2;

            boolean flag = false;
            for (int i = gap; i <= 200; i++) {
                visited = new boolean[n][n];
                min = i - gap;
                max = i;

                if (arr[0][0] < min) break;
                if (arr[0][0] > max) continue;

                if (dfs(0, 0)) {
                    flag = true;
                    break;
                }
            }

            if (flag) right = gap - 1;
            else left = gap + 1;
        }

        System.out.println(left);

        br.close();
    }

    static boolean dfs(int r, int c) {
        if (r == n - 1 && c == n - 1) return true;

        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0) continue;
            if (nr >= n || nc >= n) continue;
            if (arr[nr][nc] < min || arr[nr][nc] > max) continue;
            if (visited[nr][nc]) continue;

            if (dfs(nr, nc)) return true;
        }

        return false;
    }
}