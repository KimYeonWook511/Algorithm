import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum[] = new int[N + 1];
        long dp[][] = new long[N][4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        if (sum[N] % 4 == 0) { // 4의 배수 체크해야 함 -> 안 하면 pieceVal이 이상해질 수 있음
            int pieceVal = sum[N] / 4;
    
            // 3조각만 구하면 나머지는 pieceVal이 되기 때문에 N까지 돌지 않음
            for (int i = 1; i < N; i++) {
                dp[i][1] = dp[i - 1][1] + (sum[i] == pieceVal ? 1 : 0);
    
                for (int pieceCnt = 2; pieceCnt <= 3; pieceCnt++) {
                    dp[i][pieceCnt] = dp[i - 1][pieceCnt];
    
                    if (sum[i] == pieceCnt * pieceVal) dp[i][pieceCnt] += dp[i - 1][pieceCnt - 1];
                }
            }
        }

        System.out.println(dp[N - 1][3]);

        br.close();
    }
}