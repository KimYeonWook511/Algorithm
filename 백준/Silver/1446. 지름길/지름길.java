import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][3];
        int dp[] = new int[10001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 10_000; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < D; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

            for (int k = 0; k < N; k++) {
                if (arr[k][0] != i) continue;

                dp[arr[k][1]] = Math.min(dp[arr[k][1]], dp[i] + arr[k][2]);
            }
        }

        System.out.println(dp[D]);

        br.close();
    }
}