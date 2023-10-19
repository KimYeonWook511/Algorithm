import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int arr[][] = new int[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];
            }
        }

        for (int run = 0; run < Q; run++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append((arr[r2][c2] - arr[r2][c1] - arr[r1][c2] + arr[r1][c1]) / ((r2 - r1) * (c2 - c1))).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}