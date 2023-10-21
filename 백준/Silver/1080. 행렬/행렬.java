import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean A[][] = new boolean[N][M];
        boolean B[][] = new boolean[N][M];
        boolean arr[][] = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();

            for (int c = 0; c < M; c++) {
                if (str.charAt(c) == '1') A[r][c] = true;
            }
        }

        for (int r = 0; r < N; r++) {
            String str = br.readLine();

            for (int c = 0; c < M; c++) {
                if (str.charAt(c) == '1') B[r][c] = true;
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (A[r][c] == B[r][c]) arr[r][c] = true;
            }
        }

        boolean flag = true;
        int cnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c]) continue;

                if (N - r < 3 || M - c < 3) {
                    flag = false;
                    break;
                }
                
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 3; k++) {
                        arr[r + i][c + k] = !arr[r + i][c + k];
                    }
                }

                cnt++;
            }
        }

        System.out.println(flag ? cnt : "-1");

        br.close();
    }
}