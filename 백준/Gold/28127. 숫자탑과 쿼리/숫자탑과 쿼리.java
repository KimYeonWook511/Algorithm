import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());
        for (int t = 0; t < Q; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            // a+0d, a+1d, a+2d, a+3d
            // a+0d, 2a+1d, 3a+(1+2)d, 4a+(1+2+3)d
            // an+(1+...+n-1)d
            // an+(n*(n-1))/2*d
            // x <= an+(n*n*d/2)-(n*d/2) => n층
            // n+(n*(n-1)) <= 2,000,000
            // n^2 <= 2,000,000
            long left = 0;
            long right = 1500;
            while (left <= right) {
                long mid = (left + right) >> 1;
                long val = a * mid + (mid * (mid - 1)) * d / 2;

                if (val < x) left = mid + 1;
                else right = mid - 1;
            }

            long n = left;
            sb.append(n).append(" ").append(x - (a * (n - 1) + ((n - 1) * (n - 2) * d) / 2)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}