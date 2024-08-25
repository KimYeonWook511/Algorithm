import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int len = (int)Math.sqrt(B);
        boolean isNotPrime[] = new boolean[len + 1];
        int max = (int)Math.sqrt(len);

        for (int i = 2; i <= max; i++) {
            if (isNotPrime[i]) continue;

            for (int k = i * i; k <= len; k += i) {
                isNotPrime[k] = true;
            }
        }

        int cnt = 0;
        for (int i = 2; i <= len; i++) {
            if (isNotPrime[i]) continue;

            long temp = i;
            while (true) {
                if ((double)i > (double)B / temp) break;

                if ((double)i >= (double)A / temp) cnt++;
                temp *= i;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}