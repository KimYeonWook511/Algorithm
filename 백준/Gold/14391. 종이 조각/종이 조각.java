import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) - '0';
            }
        }

        int result = 0;
        for (int bit = (1 << N * M) - 1; bit >= 0; bit--) {
            int sum = 0;

            // 가로 블럭 (0)
            for (int r = 0; r < N; r++) {
                int temp = 0;

                for (int c = 0; c < M; c++) {
                    if ((bit & (1 << (r * M + c))) == 0) {
                        // 가로 모양
                        temp = temp * 10 + arr[r][c];

                    } else {
                        // 세로 모양
                        sum += temp;
                        temp = 0;
                    }
                }

                sum += temp;
            }

            // 세로 블럭 (1)
            for (int c = 0; c < M; c++) {
                int temp = 0;

                for (int r = 0; r < N; r++) {
                    if ((bit & (1 << (r * M + c))) == 0) {
                        // 가로 모양
                        sum += temp;
                        temp = 0;

                    } else {
                        // 세로 모양
                        temp = temp * 10 + arr[r][c];
                    }
                }

                sum += temp;
            }

            result = Math.max(result, sum);
        }

        System.out.println(result);

        br.close();
    }
}