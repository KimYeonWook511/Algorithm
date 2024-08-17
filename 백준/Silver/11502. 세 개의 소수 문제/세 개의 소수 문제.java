import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        boolean isNotPrime[] = new boolean[1001];
        int prime[] = new int[1001];
        int idx = 0;

        for (int i = 2; i <= 1000; i++) {
            if (isNotPrime[i]) continue;

            prime[idx] = i;
            idx++;

            for (int k = i * i; k <= 1000; k += i) {
                isNotPrime[k] = true;
            }
        }

        for (int t = 0; t < T; t++) {
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < idx; i++) {
                for (int k = i; k < idx; k++) {
                    for (int j = k; j < idx; j++) {
                        if (prime[i] + prime[k] + prime[j] == num) {
                            sb.append(prime[i]).append(" ").append(prime[k]).append(" ").append(prime[j]).append("\n");
                            i = k = idx;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}