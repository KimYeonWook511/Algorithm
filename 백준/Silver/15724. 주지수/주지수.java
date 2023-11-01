import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][M + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int run = 0; run < K; run++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}