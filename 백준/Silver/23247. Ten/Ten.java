import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[][] = new int[m + 1][n + 1];

        for (int r = 1; r <= m; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int sum[][] = new int[m + 1][n + 1];

        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = arr[r][c] + sum[r][c - 1] + sum[r - 1][c] - sum[r - 1][c - 1];
            }
        }

        int cnt = 0;

        for (int mr = 1; mr <= 10; mr++) {
            for (int mc = 1; mr * mc <= 10; mc++) {
                for (int r = mr; r <= m; r++) {
                    for (int c = mc; c <= n; c++) {
                        if (sum[r][c] - sum[r - mr][c] - sum[r][c - mc] + sum[r - mr][c - mc] == 10) cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}