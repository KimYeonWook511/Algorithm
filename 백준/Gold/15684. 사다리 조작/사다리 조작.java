import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, arr[][];
    static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = b + 1;
            arr[a][b + 1] = b;
        }

        for (int i = 0; i <= 3; i++) {
            func(1, i, 0);
        }

        System.out.println(result);

        br.close();
    }

    static void func(int h, int max, int cnt) {
        if (result != -1) return;

        if (cnt == max) {
            for (int c = 1; c < N; c++) {
                int col = c;

                for (int r = 1; r <= H; r++) {
                    if (arr[r][col] == 0) continue;

                    col += arr[r][col] > col ? 1 : -1;
                }
                
                if (col != c) return;
            }

            result = max;

            return;
        }

        for (int r = h; r <= H; r++) {
            for (int c = 1; c < N; c++) {
                if (arr[r][c] != 0) continue;
                if (arr[r][c + 1] != 0) continue;

                arr[r][c] = c + 1;
                arr[r][c + 1] = c;
                func(r, max, cnt + 1);
                arr[r][c] = arr[r][c + 1] = 0;
            }
        }
    }
}