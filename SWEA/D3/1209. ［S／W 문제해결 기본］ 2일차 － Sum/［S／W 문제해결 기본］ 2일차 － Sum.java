import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int T = 1; T <= 10; T++) {
            int t = Integer.parseInt(br.readLine());

            int arr[][] = new int[100][100];
            int max = 0;

            for (int r = 0; r < 100; r++) {
                st = new StringTokenizer(br.readLine());
                int sum = 0;

                for (int c = 0; c < 100; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                    sum += arr[r][c];
                }

                max = Math.max(max, sum);
            }

            for (int c = 0; c < 100; c++) {
                int sum = 0;

                for (int r = 0; r < 100; r++) {
                    sum += arr[r][c];
                }

                max = Math.max(max, sum);
            }

            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < 100; i++) {
                sum1 += arr[i][i];
                sum2 += arr[i][99 - i];
            }

            max = Math.max(max, Math.max(sum1, sum2));

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}