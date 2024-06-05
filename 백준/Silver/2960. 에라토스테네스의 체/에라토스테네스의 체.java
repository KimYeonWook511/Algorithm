import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean chk[] = new boolean[N + 1];
        int cnt = 0;

        loop : for (int i = 2; i <= N; i++) {
            for (int k = i; k <= N; k += i) {
                if (chk[k]) continue;

                chk[k] = true;

                if (++cnt == K) {
                    System.out.println(k);
                    break loop;
                }
            }
        }

        br.close();
    }
}