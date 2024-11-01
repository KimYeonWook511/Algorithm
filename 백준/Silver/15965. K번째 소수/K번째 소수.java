import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        boolean isNotPrime[] = new boolean[10_000_001];

        int max = (int)Math.sqrt(10_000_000);
        for (int i = 2; i <= max; i++) {
            if (isNotPrime[i]) continue;

            for (int j = i * i; j <= 10_000_000; j += i) {
                isNotPrime[j] = true;
            }
        }

        int cnt = 1;
        for (int i = 2; i <= 10_000_000; i++) {
            if (isNotPrime[i]) continue;

            if (cnt++ == K) {
                System.out.println(i);
                break;
            }
        }

        br.close(); 
    }
}