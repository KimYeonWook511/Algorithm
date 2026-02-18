import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isPrime[] = new boolean[1_000_001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int k = i * i; k < isPrime.length; k += i) {
                    isPrime[k] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean flag = false;

            for (int a = 3; a <= n / 2; a += 2) {
                if (isPrime[a] && isPrime[n - a]) {
                    sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
