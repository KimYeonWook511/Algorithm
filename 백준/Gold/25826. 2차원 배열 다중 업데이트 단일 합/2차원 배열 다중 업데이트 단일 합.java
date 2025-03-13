import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long arr[][] = new long[n + 2][n + 2];
        for (int r = 1; r <= n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        long sum[][] = new long[n + 2][n + 2];
        for (int i = 1; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int i1 = Integer.parseInt(st.nextToken()) + 1;
            int j1 = Integer.parseInt(st.nextToken()) + 1;
            int i2 = Integer.parseInt(st.nextToken()) + 1;
            int j2 = Integer.parseInt(st.nextToken()) + 1;
            int k = Integer.parseInt(st.nextToken());

            sum[i1][j1] += k;
            sum[i1][j2 + 1] -= k;
            sum[i2 + 1][j1] -= k;
            sum[i2 + 1][j2 + 1] += k;
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] += sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
                arr[r][c] += arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1] + sum[r][c];
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int r1 = Integer.parseInt(st.nextToken()) + 1;
        int c1 = Integer.parseInt(st.nextToken()) + 1;
        int r2 = Integer.parseInt(st.nextToken()) + 1;
        int c2 = Integer.parseInt(st.nextToken()) + 1;

        System.out.println(arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1]);

        br.close();
    }
}