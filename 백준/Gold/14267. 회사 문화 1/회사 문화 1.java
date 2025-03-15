import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n + 1];
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dp[i] += w;
        }

        sb.append(0).append(" ");
        for (int i = 2; i <= n; i++) {
            dp[i] += dp[arr[i]];
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
