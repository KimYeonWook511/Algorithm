import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static int P, Q, X, Y;
    static Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        System.out.println(func(N));

        br.close();
    }

    static long func(long i) {
        if (i <= 0) return 1;

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        long left = func(i / P - X);
        long right = func(i / Q - Y);
        long result = left + right;
        dp.put(i, result);

        return result;
    }
}