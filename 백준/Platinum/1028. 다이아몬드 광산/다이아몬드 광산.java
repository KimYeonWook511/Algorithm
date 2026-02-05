import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[R + 2][C + 2];
        for (int r = 1; r <= R; r++) {
            String line = br.readLine();
            for (int c = 1; c <= C; c++) {
                arr[r][c] = line.charAt(c - 1) == '1';
            }
        }

        int answer = 0;
        int dp[][][] = new int[R + 2][C + 2][2];
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (!arr[r][c]) continue;

                if (arr[r - 1][c - 1]) {
                    dp[r][c][0] = dp[r - 1][c - 1][0] + 1;
                }
                if (arr[r - 1][c + 1]) {
                    dp[r][c][1] = dp[r - 1][c + 1][1] + 1;
                }

                for (int dr = Math.min(dp[r][c][0], dp[r][c][1]); dr >= answer; dr--) {
                    if (Math.min(dp[r - dr][c - dr][1], dp[r - dr][c + dr][0]) >= dr) {
                        answer = Math.max(answer, dr + 1);
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}