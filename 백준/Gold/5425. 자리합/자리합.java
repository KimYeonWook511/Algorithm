import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            sb.append(func(b) - func(a - 1)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static long func(long num) {
        long sum = 0;
        for (long i = 1; i <= num; i *= 10) {
            long cur = (num / i) % 10;
            long left = num / (i * 10);
            long right = num % i;

            sum += left * 45 * i;
            sum += (cur * (cur - 1)) / 2 * i;
            sum += cur * (right + 1);
        }
        return sum;
    }
}