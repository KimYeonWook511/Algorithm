import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        // an = (N-1)*(a(n-1)+a(n-2))
        // result = n! * an
        long factorial = 1;
        long dp[] = new long[N + 1]; // == an => derangement(완전순열 or 교란순열)라고 함. 공부해보자
        dp[0] = 1; // 초기화
        for (int i = 2; i <= N; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
            dp[i] %= MOD;
            factorial = (factorial * i) % MOD;
        }

        System.out.println((factorial * dp[N]) % MOD);

        br.close();
    }
}