import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        double sum[] = new double[n + 1];
        double pow[] = new double[n + 1];
        double dp[][] = new double[b + 1][n + 1];
        int MAX = 40_000_000;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + num;
            pow[i] = pow[i - 1] + num * num;

            double nume = sum[i];
            double avg = nume / i;

            dp[1][i] = pow[i] - 2 * nume * avg + i * avg * avg;

            for (int k = 2; k <= b; k++) {
                dp[k][i] = MAX;
            }
        }

        for (int endIdx = 1; endIdx <= n; endIdx++) {
            for (int startIdx = 0; startIdx < endIdx; startIdx++) {
                for (int i = 2; i <= b; i++) {
                    double nume = sum[endIdx] - sum[startIdx];
                    double avg = nume / (endIdx - startIdx);

                    dp[i][endIdx] = Math.min(dp[i][endIdx], dp[i - 1][startIdx] + (pow[endIdx] - pow[startIdx]) - 2 * nume * avg + (endIdx - startIdx) * avg * avg);
                }
            }
        }

        System.out.println(String.format("%.6f", dp[b][n]));

        br.close();
    }
}