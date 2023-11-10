import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int arr[][] = new int[N + 1][N + 1];
            int max = 0;

            for (int r = 1; r < M; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 1; c <= N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];
                }
            }

            // row : M (사실 간편하게 할 수 있지만 코드 돌아가는 시간을 최대한 줄이기 위한 작업)
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < M; c++) {
                arr[M][c] = Integer.parseInt(st.nextToken()) + arr[M - 1][c] + arr[M][c - 1] - arr[M - 1][c - 1];
            }

            for (int c = M; c <= N; c++) {
                arr[M][c] = Integer.parseInt(st.nextToken()) + arr[M - 1][c] + arr[M][c - 1] - arr[M - 1][c - 1];

                int val = arr[M][c] - arr[M][c - M];

                max = Math.max(max, val);
            }

            for (int r = M + 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 1; c < M; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];
                }

                for (int c = M; c <= N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];

                    int val = arr[r][c] - arr[r - M][c] - arr[r][c - M] + arr[r - M][c - M];

                    max = Math.max(max, val);
                }
            }

            // 이하 간단하게 하는법
            // for (int r = 1; r <= N; r++) {
            //     st = new StringTokenizer(br.readLine());

            //     for (int c = 1; c <= N; c++) {
            //         arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];
            //     }
            // }

            // for (int r = M; r <= N; r++) {
            //     for (int c = M; c <= N; c++) {
            //         max = Math.max(max, arr[r][c] - arr[r - M][c] - arr[r][c - M] + arr[r - M][c - M]);
            //     }
            // }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}