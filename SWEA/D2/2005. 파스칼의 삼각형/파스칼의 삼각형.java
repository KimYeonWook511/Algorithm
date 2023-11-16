import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[][] = new int[N][N];

            sb.append("#").append(t).append("\n");

            for (int r = 0; r < N; r++) {
                arr[r][0] = 1;
                sb.append(arr[r][0]).append(" ");

                for (int c = 1; c <= r; c++) {
                    arr[r][c] = arr[r - 1][c - 1] + arr[r - 1][c];
                    
                    sb.append(arr[r][c]).append(" ");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}