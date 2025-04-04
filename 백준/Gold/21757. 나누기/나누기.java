import java.io.*;
import java.util.*;

public class Main {
    static int N, sum[], pieceVal;
    static long dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sum = new int[N + 1];
        dp = new long[3][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

            for (int r = 0; r < 3; r++) {
                dp[r][i] = -1;
            }
        }

        pieceVal = sum[N] / 4;

        System.out.println(func(0, 1));

        br.close();
    }

    static long func(int pieceCnt, int startIdx) {
        if (pieceCnt == 3) return pieceVal == sum[N] - sum[startIdx - 1] ? 1 : 0;
        if (dp[pieceCnt][startIdx] != -1) return dp[pieceCnt][startIdx];

        dp[pieceCnt][startIdx] = 0;

        for (int endIdx = startIdx; endIdx <= N - 3 + pieceCnt; endIdx++) {
            if (pieceVal != sum[endIdx] - sum[startIdx - 1]) continue;

            dp[pieceCnt][startIdx] += func(pieceCnt + 1, endIdx + 1);
        }

        return dp[pieceCnt][startIdx];
    }
}