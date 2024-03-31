import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][], dp[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M + 2][N + 2];
        dp = new int[M + 2][N + 2];

        for (int r = 1; r <= M; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }
        
        dp[M][N] = 1;
        dfs(1, 1);

        System.out.println(dp[1][1]);

        br.close();
    }

    static int dfs(int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;

        int val = arr[r][c];
        int nr, nc;

        for (int d = 0; d < 4; d++) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (arr[nr][nc] == 0) continue;
            if (arr[nr][nc] >= val) continue;

            dp[r][c] += dfs(nr, nc);
        }

        return dp[r][c];
    }
}