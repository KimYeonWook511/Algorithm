import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[][] = new int[N][N];

            for (int r = 0; r < N; r++) {
                String str = br.readLine();

                for (int c = 0; c < N; c++) {
                    arr[r][c] = str.charAt(c) - '0';
                }
            }
            
            int sum = 0;
            int mid = N / 2;

            for (int r = 0; r < mid; r++) {
                int right = mid + r;

                for (int left = mid - r; left <= right; left++) {
                    sum += arr[r][left];
                    sum += arr[N - 1 - r][left];
                }
            }

            for (int c = 0; c < N; c++) {
                sum += arr[mid][c];
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}