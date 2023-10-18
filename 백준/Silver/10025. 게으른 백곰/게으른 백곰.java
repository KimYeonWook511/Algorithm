import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long sum[] = new long[1_000_002];

        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            sum[x + 1] = g;
        }

        for (int i = 2; i <= 1_000_001; i++) {
            sum[i] += sum[i - 1];
        }

        if (k > 500_000) k = 500_000;

        long max = 0;

        for (int s = 2 * k + 1; s <= 1_000_001; s++) {
            max = Math.max(max, sum[s] - sum[s - (2 * k + 1)]);
        }

        System.out.println(max);

        br.close();
    }
}