import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pre = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            int lv = Integer.parseInt(st.nextToken());

            dp[i] = dp[i - 1] + (lv < pre ? 1 : 0);

            pre = lv;
        }

        int Q = Integer.parseInt(br.readLine());
        for (int run = 0; run < Q; run++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[end] - dp[start]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}