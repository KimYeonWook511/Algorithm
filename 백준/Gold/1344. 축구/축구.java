import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double P[] = {Double.parseDouble(br.readLine()) / 100, Double.parseDouble(br.readLine()) / 100};

        double sum[] = new double[2];

        double dp[][] = new double[19][20]; // column -1 보정
        int isNotPrime[] = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
        int len = isNotPrime.length;

        dp[0][1] = 1;

        for (int t = 0; t < 2; t++) {

            for (int r = 1; r <= 18; r++) {
                for (int c = 1; c <= r + 1; c++) {
                    dp[r][c] = dp[r - 1][c - 1] * P[t] + dp[r - 1][c] * (1 - P[t]);
                }
            }

            for (int i = 0; i < len; i++) {
                sum[t] += dp[18][isNotPrime[i] + 1];
            }
        }

        System.out.println(1 - (sum[0] * sum[1]));

        br.close();
    }
}