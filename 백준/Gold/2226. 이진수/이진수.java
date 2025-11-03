import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 2^N-1 자리수
        // 0->10 , 1->01
        // 1 0
        // 01 1
        // 1001 dp[i-1]*2-i%2
        // 01101001 2+1-0
        // 1001011001101001 3+3-1
        // 01101001100101101001011001101001 6+5-0
        // 1001011001101001011010011001011001101001100101101001011001101001 11+11-1 =21

        BigInteger count = BigInteger.ZERO;
        if (N != 1) {
            count = BigInteger.ONE;
            for (int i = 3; i <= N; i++) {
                count = count.multiply(BigInteger.TWO);
                if (i % 2 == 0) {
                    count = count.add(BigInteger.ONE);
                } else {
                    count = count.subtract(BigInteger.ONE);
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}