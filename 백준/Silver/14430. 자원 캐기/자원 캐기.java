import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                arr[r][c] = st.nextToken().charAt(0) == '1';
            }
        }

        int dp[][] = new int[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);

                if (arr[r][c]) {
                    dp[r][c] += 1;
                }
            }
        }

        System.out.println(dp[N][M]);

        br.close();
    }
}
