import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int bef = Integer.parseInt(st.nextToken());
            int af = Integer.parseInt(st.nextToken());

            arr[bef][af] = true;
        }

        for (int m = 1; m <= n; m++) {
            for (int s = 1; s <= n; s++) {
                if (m == s) continue;

                for (int e = 1; e <= n; e++) {
                    arr[s][e] |= arr[s][m] & arr[m][e];
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!arr[start][end] && !arr[end][start]) sb.append(0).append("\n");
            else sb.append(arr[start][end] ? -1 : 1).append("\n");
        }

        System.out.println(sb);

        br.close();;
    }
}