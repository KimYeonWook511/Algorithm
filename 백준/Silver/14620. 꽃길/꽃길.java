import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[][];
    static boolean chk[][];
    static int min = Integer.MAX_VALUE;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        chk = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0);

        System.out.println(min);

        br.close();
    }

    static void func(int cnt, int val) {
        if (val >= min) return;
        
        if (cnt == 3) {
            min = Math.min(min, val);
            return;
        }
        
        for (int r = 1; r < N - 1; r++) {
            for (int c = 1; c < N - 1; c++) {
                
                if (chk[r][c]) continue;
                if (!checkNext(r, c)) continue;

                int nr, nc;

                int sum = arr[r][c];
                chk[r][c] = true;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];
                    
                    sum += arr[nr][nc];
                    chk[nr][nc] = true;
                }

                func(cnt + 1, val + sum);

                chk[r][c] = false;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];

                    chk[nr][nc] = false;
                }
            }
        }
    }

    static boolean checkNext(int r, int c) {
        for (int d = 0; d < 4; d++) {
            if (chk[r + dr[d]][c + dc[d]]) return false;;
        }

        return true;
    }
}