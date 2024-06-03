import java.io.*;
import java.util.*;

public class Main {
    static int arr[][] = new int[5][5];
    static Set<Integer> set = new HashSet<>();
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < 5; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                func(1, arr[r][c], r, c);
            }
        }

        System.out.println(set.size());

        br.close();
    }

    static void func(int cnt, int num, int r, int c) {
        if (cnt == 6) {
            set.add(num);

            return;
        }

        int nr, nc;
        for (int d = 0; d < 4; d++) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 0 || nr >= 5) continue;
            if (nc < 0 || nc >= 5) continue;

            func(cnt + 1, num * 10 + arr[nr][nc], nr, nc);
        }
    }
}