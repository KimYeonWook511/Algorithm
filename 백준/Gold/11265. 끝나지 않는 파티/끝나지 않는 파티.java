import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (s == m) continue;

                for (int e = 0; e < N; e++) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            sb.append(arr[A][B] <= C ? "Enjoy other party\n" : "Stay here\n");
        }

        System.out.println(sb);

        br.close();
    }
}