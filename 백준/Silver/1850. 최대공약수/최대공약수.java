import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long val = A > B ? gcd(A, B) : gcd(B, A);

        for (int i = 0; i < val; i++) {
            sb.append(1);
        }

        System.out.println(sb);

        br.close();
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}