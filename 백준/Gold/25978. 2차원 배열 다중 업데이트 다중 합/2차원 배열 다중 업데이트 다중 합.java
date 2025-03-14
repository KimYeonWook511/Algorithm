import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long arr[][] = new long[n + 2][n + 2];
        long sum[][] = new long[n + 2][n + 2];

        for (int r = 1; r <= n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= n; c++) {
                arr[r][c] = Long.parseLong(st.nextToken());
            }
        }
    
        boolean isCal = false;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = st.nextToken().charAt(0);
            int i1 = Integer.parseInt(st.nextToken()) + 1;
            int j1 = Integer.parseInt(st.nextToken()) + 1;
            int i2 = Integer.parseInt(st.nextToken()) + 1;
            int j2 = Integer.parseInt(st.nextToken()) + 1;

            if (cmd == '1') {
                int k = Integer.parseInt(st.nextToken());

                sum[i1][j1] += k;
                sum[i1][j2 + 1] -= k;
                sum[i2 + 1][j1] -= k;
                sum[i2 + 1][j2 + 1] += k;
                continue;
            }
            
            if (!isCal) {
                // 최초 한 번만 계산
                for (int r = 1; r <= n; r++) {
                    for (int c = 1; c <= n; c++) {
                        sum[r][c] += sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1]; // r-1 : imos 열 계산 , c-1 - (r-1, c-1) : imos 첫 행 계산
                        arr[r][c] += arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1] + sum[r][c];
                    }
                }

                isCal = true;
            }

            sb.append(arr[i2][j2] - arr[i2][j1 - 1] - arr[i1 - 1][j2] + arr[i1 - 1][j1 - 1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}