import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double arr[] = new double[4];
    static boolean visited[][] = new boolean[30][30];
    static double result;
    static int dr[] = {0, 0, 1, -1};
    static int dc[] = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            arr[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        func(15, 15, 0, 1);

        System.out.println(result);

        br.close();
    }

    static void func(int r, int c, int cnt, double val) {
        if (cnt == N) {
            result += val;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr <= 0 || nc <= 0) continue;
            if (nr >= 30 || nc >= 30) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            func(nr, nc, cnt + 1, val * arr[d]);
            visited[nr][nc] = false;
        }
    }
}