import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 500;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int b3 = Integer.parseInt(st.nextToken());

        int[] arr = {b1, b2, b3};
        boolean[][] dp = new boolean[MAX + 1][MAX + 1];

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                if (i == 0 && j == 0) continue;

                boolean win = false;
                for (int b = 0; b < 3; b++) {
                    if (i - arr[b] >= 0 && !dp[i - arr[b]][j]) {
                        win = true;
                        break;
                    }
                    if (j - arr[b] >= 0 && !dp[i][j - arr[b]]) {
                        win = true;
                        break;
                    }
                }
                dp[i][j] = win;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 5; t++) {
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());
            sb.append(dp[k1][k2] ? "A\n" : "B\n");
        }

        System.out.print(sb);

        br.close();
    }
}
