import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();

        int arr[][] = new int[n + 2][m + 2];
        for (int r = 1; r <= n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= m; c++) {
                char ch = st.nextToken().charAt(0);

                if (ch == '1') arr[r][c] = -1;
                if (ch == '2') deque.offer(new int[]{r, c});
            }
        }

        while (!deque.isEmpty()) {
            int cur[] = deque.poll();

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = cur[0] + dr[i];
                nc = cur[1] + dc[i];

                if (arr[nr][nc] >= 0) continue;

                arr[nr][nc] = arr[cur[0]][cur[1]] + 1;
                deque.offer(new int[]{nr, nc});
            }
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                sb.append(arr[r][c]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}