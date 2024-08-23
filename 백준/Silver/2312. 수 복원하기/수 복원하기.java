import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean isNotPrime[] = new boolean[100_001];
        for (int i = 2; i * i <= 100_000; i++) {
            if (isNotPrime[i]) continue;
            
            for (int k = i * i; k <= 100_000; k += i) {
                isNotPrime[k] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 2; i <= N; i++) {
                int cnt = 0;

                while (!isNotPrime[i]) {
                    if (N % i != 0) break;

                    cnt++;
                    N /= i;
                }
                
                if (cnt > 0) sb.append(i).append(" ").append(cnt).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}