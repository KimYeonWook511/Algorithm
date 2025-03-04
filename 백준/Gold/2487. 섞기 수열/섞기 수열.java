import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        boolean chk[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (chk[i]) continue;

            int pre = i;
            long cnt = 1;
            while (true) {
                chk[pre] = true;

                if (arr[pre] == i) break;

                cnt++;
                pre = arr[pre];
            }

            if (result == 0) {
                result = cnt;
                continue;
            }

            result = result * cnt / gcd(result, cnt);
        }

        System.out.println(result);

        br.close();
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}