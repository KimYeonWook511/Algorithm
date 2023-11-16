import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[][] = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t).append("\n");

            for (int run = 0; run < N; run++) {
                for (int r = N - 1; r >= 0; r--) {
                    sb.append(arr[r][run]);
                }

                sb.append(" ");

                for (int c = N - 1; c >= 0; c--) {
                    sb.append(arr[N - run - 1][c]);
                }

                sb.append(" ");

                for (int r = 0; r < N; r++) {
                    sb.append(arr[r][N - run - 1]);
                }

                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}