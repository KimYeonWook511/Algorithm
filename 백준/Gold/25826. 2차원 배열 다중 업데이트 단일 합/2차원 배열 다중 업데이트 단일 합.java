import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long arr[][] = new long[n + 1][n + 1];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        long sum[][] = new long[n + 1][n + 1];
        for (int i = 1; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[i1][j1] += k;
            sum[i1][j2 + 1] -= k;
            sum[i2 + 1][j1] -= k;
            sum[i2 + 1][j2 + 1] += k;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                sum[r][c] += sum[r][c - 1];
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < n; r++) {
                sum[r][c] += sum[r - 1][c];
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        long result = 0;

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                result += arr[r][c] + sum[r][c];
            }
        }

        System.out.println(result);

        br.close();
    }
}