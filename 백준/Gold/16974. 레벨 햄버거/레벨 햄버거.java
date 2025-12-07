import java.io.*;
import java.util.*;

public class Main {
    static long len[], pat[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        len = new long[N + 1];
        pat = new long[N + 1];
        len[0] = 1;
        pat[0] = 1;

        for (int i = 1; i <= N; i++) {
            len[i] = len[i - 1] * 2 + 3;
            pat[i] = pat[i - 1] * 2 + 1;
        }

        System.out.println(func(N, X));

        br.close();
    }

    static long func(int level, long cnt) {
        if (level == 0) return cnt == 0 ? 0 : 1;
        if (cnt == 1) return 0;

        if (cnt == len[level - 1] + 2) {
            return pat[level - 1] + 1;
        }

        if (cnt < len[level - 1] + 2) {
            return func(level - 1, cnt - 1);
        }

        if (cnt > len[level - 1] + 2) {
            return pat[level - 1] + 1 + func(level - 1, cnt - (len[level - 1] + 2));
        }

        return pat[level];
    }
}