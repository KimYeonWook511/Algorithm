import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int S[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int D[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 희소 배열
        int pre[][] = new int[getLog(K)][N + 1];
        // 희소 배열 채우기 (역추적)
        for (int i = 1; i <= N; i++) {
            pre[0][D[i]] = i;
        }
        for (int l = 1; l < pre.length; l++) {
            for (int i = 1; i <= N; i++) {
                pre[l][i] = pre[l - 1][pre[l - 1][i]];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(S[jump(i, K, pre)]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    static int getLog(long K) {
        int LOG = 0;
        while ((1L << LOG) <= K) {
            LOG++;
        }
        return LOG;
    }

    static int jump(int cur, long K, int pre[][]) {
        for (int l = pre.length - 1; l >= 0; l--) {
            long bit = 1L << l;
            if ((K & bit) != 0) {
                cur = pre[l][cur];
                K &= ~bit;

                if (bit == 0) break;
            }
        }
        return cur;
    }
}