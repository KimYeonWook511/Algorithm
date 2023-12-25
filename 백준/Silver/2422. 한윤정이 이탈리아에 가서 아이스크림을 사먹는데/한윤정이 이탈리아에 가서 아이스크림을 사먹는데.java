import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean chk[][] = new boolean[N + 1][N + 1];
        int result = 0;

        for (int run = 0; run < M; run++) {
            st = new StringTokenizer(br.readLine());

            chk[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int i1 = N - 2; i1 > 0; i1--) {
            for (int i2 = N - 1; i2 > i1; i2--) {
                if (chk[i1][i2] || chk[i2][i1]) continue;

                for (int i3 = N; i3 > i2; i3--) {
                    if (chk[i1][i3] || chk[i3][i1]) continue;
                    if (chk[i2][i3] || chk[i3][i2]) continue;

                    result++;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}