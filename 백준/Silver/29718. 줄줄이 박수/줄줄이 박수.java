import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][M + 1];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= M; c++) {
                arr[r][c] = arr[r][c - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = A; i <= M; i++) {
            int sum = 0;

            for (int r = 0; r < N; r++) {
                sum += arr[r][i] - arr[r][i - A];
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
        
        br.close();
    }
}