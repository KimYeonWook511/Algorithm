import java.io.*;
import java.util.*;

public class Main {
    static int N, guiltVal[], R[][], eunjin;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        guiltVal = new int[N];
        R = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            guiltVal[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                R[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        eunjin = Integer.parseInt(br.readLine());

        func(0, N, 0);

        System.out.println(result);

        br.close();
    }

    static boolean func(int killed, int alive, int cnt) {
        if (alive == 1) {
            result = cnt;
            return true;
        }

        if (alive % 2 == 0) {
            // 밤
            for (int i = 0; i < N; i++) {
                if ((killed & (1 << i)) > 0) continue;
                if (i == eunjin) continue;

                for (int k = 0; k < N; k++) {
                    guiltVal[k] += R[i][k];
                }

                if (func(killed | (1 << i), alive - 1, cnt + 1)) return true;

                for (int k = 0; k < N; k++) {
                    guiltVal[k] -= R[i][k];
                }
            }

        } else {
            // 낮
            long max = 0;
            int killIdx = -1;

            for (int i = 0; i < N; i++) {
                if ((killed & (1 << i)) > 0) continue;

                if (guiltVal[i] > max) {
                    max = guiltVal[i];
                    killIdx = i;
                }
            }

            if (killIdx == eunjin) {
                result = Math.max(result, cnt);
                return false;
            }

            if (func(killed | (1 << killIdx), alive - 1, cnt)) return true;
        }

        return false;
    }
}