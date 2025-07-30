import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();

            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) == '1';
            }
        }

        int result = 0;
        for (int r = N - 1; r >= 0; r--) {
            for (int c = M - 1; c >= 0; c--) {
                if (!arr[r][c]) continue;

                func(r, c);
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }

    static void func(int rr, int cc) {
        for (int r = 0; r <= rr; r++) {
            for (int c = 0; c <= cc; c++) {
                arr[r][c] = !arr[r][c];
            }
        }
    }
}