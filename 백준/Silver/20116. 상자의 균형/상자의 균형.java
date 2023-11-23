import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        long sum[] = new long[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }

        for (int i = 2; i <= n; i++) {
            double mid = (sum[n] - sum[i - 1]) / (double)(n - i + 1);

            long min = sum[i - 1] - sum[i - 2] - L;
            long max = sum[i - 1] - sum[i - 2] + L;

            if (mid <= min || mid >= max) {
                sum[0] = -1;
                break;
            }
        }

        System.out.println(sum[0] == -1 ? "unstable" : "stable");

        br.close();
    }
}