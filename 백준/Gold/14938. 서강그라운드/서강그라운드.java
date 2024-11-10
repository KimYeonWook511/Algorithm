import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int item[] = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int arr[][] = new int[n + 1][n + 1];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = l;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                if (arr[start][mid] == 0) continue;

                for (int end = 1; end <= n; end++) {
                    if (arr[mid][end] == 0) continue;
                    if (arr[start][end] != 0 && arr[start][end] <= arr[start][mid] + arr[mid][end]) continue;

                    arr[start][end] = arr[start][mid] + arr[mid][end];
                }
            }
        }

        int max = 0;
        for (int row = 1; row <= n; row++) {
            int sum = item[row];

            for (int col = 1; col <= n; col++) {
                if (row == col) continue;
                if (arr[row][col] == 0) continue;
                if (arr[row][col] > m) continue;

                 sum += item[col];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);

        br.close();
    }
}