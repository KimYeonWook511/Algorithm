import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int arr[][] = new int[N * 3][N * 3];

            for (int r = N; r < N * 2; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = N; c < N * 2; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for (int r = N; r < N * 2; r++) { // 15
                for (int c = N; c < N * 2; c++) { // 15
                    int sum1 = -arr[r][c]; // +
                    int sum2 = -arr[r][c]; // x

                    for (int target = 1 - M; target < M; target++) {
                        sum1 += arr[r + target][c] + arr[r][c + target];
                        sum2 += arr[r + target][c + target] + arr[r + target][c - target];
                    }

                    max = Math.max(max, Math.max(sum1, sum2));
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}