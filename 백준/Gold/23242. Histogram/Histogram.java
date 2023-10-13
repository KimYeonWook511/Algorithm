import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int b, n, num;
    static double sum[], pow[], dp[][], nume, avg;
    static final double MAX = 40_000_000;

    public static void main(String[] args) throws IOException {
        b = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        sum = new double[n + 1];
        pow = new double[n + 1];
        dp = new double[b + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + num;
            pow[i] = pow[i - 1] + num * num;

            nume = sum[i];
            avg = nume / i;

            dp[1][i] = pow[i] - 2 * nume * avg + i * avg * avg;
        }

        for (int i = 2; i <= b; i++) {
            Arrays.fill(dp[i], MAX);
            dp[i][0] = 0;
        }

        for (int endIdx = 1; endIdx <= n; endIdx++) {
            for (int startIdx = 0; startIdx < endIdx; startIdx++) {
                for (int i = 2; i <= b; i++) {
                    nume = sum[endIdx] - sum[startIdx];
                    avg = nume / (endIdx - startIdx);

                    dp[i][endIdx] = Math.min(dp[i][endIdx], dp[i - 1][startIdx] + (pow[endIdx] - pow[startIdx]) - 2 * nume * avg + (endIdx - startIdx) * avg * avg);
                }
            }
        }

        System.out.println(String.format("%.6f", dp[b][n]));

        br.close();
    }
}