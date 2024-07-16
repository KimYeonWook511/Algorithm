import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][] = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int B[][] = new int[M][K];

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < K; c++) {
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                int sum = 0;

                for (int m = 0; m < M; m++) {
                    sum += A[n][m] * B[m][k];
                }

                sb.append(sum).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}