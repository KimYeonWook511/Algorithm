import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= C; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int broken[] = new int[N + 1];
            for (int r = 1; r <= N; r++) {
                String line = br.readLine();
                for (int i = 0; i < M; i++) {
                    if (line.charAt(i) == 'x') {
                        broken[r] |= (1 << ((M - 1) - i));
                    }
                }
            }

            int dp[][] = new int[N + 1][1 << M];
            for (int r = 0; r < dp.length; r++) {
                for (int c = 0; c < dp[0].length; c++) {
                    dp[r][c] = -1;
                }
            }
            dp[0][0] = 0;

            for (int r = 1; r <= N; r++) {
                for (int prev = 0; prev < dp[0].length; prev++) {
                    if (dp[r - 1][prev] == -1) continue;

                    for (int cur = 0; cur < dp[0].length; cur++) {
                        if ((prev & (cur << 1)) != 0) continue; // 왼쪽 위
                        if ((prev & (cur >> 1)) != 0) continue; // 오른쪽 위
                        if ((cur & (cur << 1)) != 0) continue; // 같은 행 좌,우 인접
                        if ((cur & broken[r]) != 0) continue; // 부숴진 자리에 사람 앉음

                        int cnt = Integer.bitCount(cur);
                        dp[r][cur] = Math.max(dp[r][cur], dp[r - 1][prev] + cnt);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < dp[0].length; i++) {
                answer = Math.max(answer, dp[N][i]);
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}