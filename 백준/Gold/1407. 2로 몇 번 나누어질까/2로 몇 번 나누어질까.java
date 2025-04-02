import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(func(B) - func(A - 1));

        br.close();
    }

    static long func(long X) {
        long val = 1;
        long sum = 0;

        while (true) {
            long cal = X / val;

            if (cal == 0) break;

            sum += ((cal + 1) >> 1) * val;
            val <<= 1;
        }

        return sum;
    }
}