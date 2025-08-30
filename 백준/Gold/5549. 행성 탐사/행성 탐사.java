import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        int arr[][][] = new int[M + 1][N + 1][3];
        for (int r = 1; r <= M; r++) {
            String line = br.readLine();

            for (int c = 1; c <= N; c++) {
                for (int i = 0; i < 3; i++) {
                    arr[r][c][i] = arr[r - 1][c][i] + arr[r][c - 1][i] - arr[r - 1][c - 1][i];
                } 

                if (line.charAt(c - 1) == 'J') arr[r][c][0]++;
                else if (line.charAt(c - 1) == 'O') arr[r][c][1]++;
                else arr[r][c][2]++;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int k = 0; k < 3; k++) {
                sb.append(arr[c][d][k] - arr[a - 1][d][k] - arr[c][b - 1][k] + arr[a - 1][b - 1][k]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}