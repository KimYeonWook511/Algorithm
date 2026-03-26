import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        int f[] = new int[m + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            f[i] = Integer.parseInt(st.nextToken());
        }

        // 희소 테이블
        int LOG = getLog(500_000); // n은 최대 500,000
        int next[][] = new int[LOG][m + 1];
        // 희소 테이블 채우기
        for (int i = 1; i <= m; i++) {
            next[0][i] = f[i];
        }
        for (int l = 1; l < LOG; l++) {
            for (int i = 1; i <= m; i++) {
                next[l][i] = next[l - 1][next[l - 1][i]];
            }
        }

        int Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            // 500,000 -> 19번
            sb.append(jump(n, x, next)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int getLog(int n) {
        int LOG = 0;
        while ((1 << LOG) <= n) {
            LOG++;
        }
        return LOG;
    }

    static int jump(int n, int x, int next[][]) {
        int cur = x;
        for (int l = 0; l <= next.length; l++) {
            if (((1 << l) & n) != 0) {
                cur = next[l][cur];
            }
        }
        return cur;
    }
}