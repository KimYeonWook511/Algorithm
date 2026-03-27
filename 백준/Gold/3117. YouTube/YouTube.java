import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int starts[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            starts[n] = Integer.parseInt(st.nextToken());
        }

        int tops[] = new int[K + 1];
        st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= K; k++) {
            tops[k] = Integer.parseInt(st.nextToken());
        }

        // 희소 테이블
        int next[][] = new int[getLog(M)][K + 1];
        // 희소 테이블 채우기
        for (int k = 1; k <= K; k++) {
            next[0][k] = tops[k];
        }
        for (int l = 1; l < next.length; l++) {
            for (int k = 1; k <= K; k++) {
                next[l][k] = next[l - 1][next[l - 1][k]];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n = 1; n <= N; n++) {
            sb.append(jump(starts[n], M - 1, next)).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static int getLog(int M) {
        int LOG = 0;
        while ((1 << LOG) <= M) {
            LOG++;
        }
        return LOG;
    }

    static int jump(int start, int M, int next[][]) {
        int cur = start;
        for (int l = next.length - 1; l >= 0; l--) {
            int bit = 1 << l;
            if ((bit & M) != 0) {
                cur = next[l][cur];
                M &= ~bit;

                if (M == 0) break;
            }
        }
        return cur;
    }
}