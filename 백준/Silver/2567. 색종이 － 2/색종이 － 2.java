import java.io.*;
import java.util.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean arr[][] = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int nr = r; nr < r + 10; nr++) {
                for (int nc = c; nc < c + 10; nc++) {
                    arr[nr][nc] = true;
                }
            }
        }

        int result = 0;
        for (int r = 1; r <= 100; r++) {
            for (int c = 1; c <= 100; c++) {
                if (!arr[r][c]) continue;

                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];

                    if (nr >= 1 && nc >= 1 && nr <= 100 && nc <= 100 && arr[nr][nc]) continue;

                    result++;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}