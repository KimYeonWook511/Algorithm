import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());

        System.out.println(func(U) - func(L - 1));

        br.close();
    }

    static long func(int num) {
        long sum = 0;

        // i는 자릿수
        for (long i = 1; i <= num; i *= 10) {
            long left = num / (i * 10);
            long cur = (num / i) % 10;
            long right = num % i;

            // i자리에서 (0~9)의 등장 횟수
            sum += left * 45 * i;
            // i자리에서 (0~cur-1)의 등장 횟수
            sum += (cur * (cur - 1)) / 2 * i;
            // i자리에서 cur의 등장 횟수
            sum += cur * (right + 1);
        }

        return sum;
    }
}