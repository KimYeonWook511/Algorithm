import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int arr[][] = new int[N][N];

            int r[] = {0, 1, 0, -1};
            int c[] = {1, 0, -1, 0};
            int num = N + 1;
            int step = 1;

            int rr = 0;
            int cc = N - 1;
            
            // for (int col = 0; col < N; col++) {
            //     arr[0][col] = col + 1;
            // }

            for (int k = N - 1; k > 0; k--) {
                for (int run = 0; run < 2; run++) {
                    for (int repeat = 0; repeat < k; repeat++) {
                        rr += r[step];
                        cc += c[step];
                        
                        arr[rr][cc] = num++;
                    }

                    step = (step + 1) % 4;
                }
            }

            sb.append("#").append(t).append("\n");

            // 위 주석 부분 바로 출력 하기
            for (int i = 1; i <= N; i++) {
                sb.append(i).append(" ");
            }

            sb.append("\n");

            for (int row = 1; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    sb.append(arr[row][col]).append(" ");
                }

                sb.append("\n");
            }    
        }

        System.out.println(sb.toString());

        br.close();
    }
}