import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[M + 1][N + 1];
        for (int r = 1; r <= M; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++) {
                arr[r][c] = st.nextToken().equals("0");
            }
        }

        int dp[][] = new int[M + 1][N + 1];
        int result = 0;
        for (int r = 1; r <= M; r++) {
            for (int c = 1; c <= N; c++) {
                if (!arr[r][c]) continue;

                dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                result = Math.max(result, dp[r][c]);
            }
        }

        System.out.println(result);

        br.close();
    }
}