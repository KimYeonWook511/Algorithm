import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][], dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c);
            }
        }

        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (dfs(r, c) == 1) cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }

    static int dfs(int r, int c) {
        if (r < 0 || c < 0) return 1;
        if (r >= N || c >= M) return 1;

        if (dp[r][c] != 0) return dp[r][c];

        dp[r][c] = -1;

        if (arr[r][c] == 'U') return dp[r][c] = dfs(r - 1, c);
        else if (arr[r][c] == 'R') return dp[r][c] = dfs(r, c + 1);
        else if (arr[r][c] == 'D') return dp[r][c] = dfs(r + 1, c);
        else return dp[r][c] = dfs(r, c - 1);
    }
}