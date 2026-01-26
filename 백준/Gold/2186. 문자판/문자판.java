import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static String target;
    static int arr[][];
    static int dp[][][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c);
            }
        }

        target = br.readLine();
        dp = new int[target.length()][N][M];

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] != target.charAt(0)) continue;

                int val = dfs(0, r, c);
                if (val != -1) {
                    answer += val;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    static int dfs(int idx, int r, int c) {
        if (idx == target.length() - 1) return 1;
        if (dp[idx][r][c] != 0) return dp[idx][r][c];

        int sum = 0;
        for (int d = 0; d < 4; d++) {
            for (int k = 1; k <= K; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;

                if (nr < 0 || nc < 0) continue;
                if (nr >= N || nc >= M) continue;
                if (arr[nr][nc] != target.charAt(idx + 1)) continue;

                int val = dfs(idx + 1, nr, nc);
                if (val != -1) {
                    sum += val;
                }
            }
        }

        return dp[idx][r][c] = (sum == 0 ? -1 : sum);
    }
}