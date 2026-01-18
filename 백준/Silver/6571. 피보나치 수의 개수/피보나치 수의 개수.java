import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    static BigInteger MAX = BigInteger.TEN.pow(100);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger dp[] = new BigInteger[600];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.TWO;
        int len = 2;

        while (true) {
            BigInteger next = dp[len - 1].add(dp[len - 2]);
            if (next.compareTo(MAX) > 0) break;

            dp[len] = next;
            len++;
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String aStr = st.nextToken();
            String bStr = st.nextToken();

            if (aStr.equals("0") && bStr.equals("0")) break;

            BigInteger a = new BigInteger(aStr);
            BigInteger b = new BigInteger(bStr);

            int answer = 0;
            for (int i = 0; i < len; i++) {
                if (dp[i].compareTo(a) >= 0 && dp[i].compareTo(b) <= 0) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
