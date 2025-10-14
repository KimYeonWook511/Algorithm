import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[] = new int[N + 1];
            int dp[][] = new int[N + 2][N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean isGeunwoo = N % 2 == 1;
            for (int i = 1; i <= N; i++) { // 몇개 선택
                for (int r = 1; r <= N; r++) {
                    int c = r + i - 1;
                    if (c > N) break;

                    if (isGeunwoo) {
                        // 근우 턴: 근우는 최대로 먹는 값을 찾음 -> 근우가 최대로 먹는 값이 dp에 들어감
                        dp[r][c] = Math.max(dp[r][c - 1] + arr[c], dp[r + 1][c] + arr[r]);
                    } else {
                        // 명우 턴: 명우는 근우가 최소로 먹어야 좋음 -> 근우가 최소로 먹는 값이 dp에 들어감
                        dp[r][c] = Math.min(dp[r][c - 1], dp[r + 1][c]);
                    }
                }

                isGeunwoo = !isGeunwoo;
            }

            sb.append(dp[1][N]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}