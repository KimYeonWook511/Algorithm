import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
    
        int arr[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int minT = 512 * 500 * 500;
        int minH = 0;

        for (int h = 0; h <= 256; h++) {
            int sumT = 0;
            int tempB = B;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    int val = h - arr[r][c];

                    if (val < 0) {
                        val = Math.abs(val);
                        sumT += 2 * val;
                        tempB += val;

                    } else {
                        sumT += val;
                        tempB -= val;
                    }
                }
            }

            if (tempB < 0) break;

            if (sumT <= minT) {
                minT = sumT;
                minH = h;
            }
        }

        System.out.println(minT + " " + minH);

        br.close();
    }
}