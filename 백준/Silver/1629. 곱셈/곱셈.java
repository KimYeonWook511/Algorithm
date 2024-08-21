import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(func(A, B, C));

        br.close();
    }

    static long func(int A, int B, int C) {
        if (B == 0) return 1;

        long val = func(A, B >> 1, C);
        val *= val;
        val %= C;

        return B % 2 == 0 ? val : val * A % C;
    }
}