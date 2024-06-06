import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int A = a1 * b2 + b1 * a2;
        int B = a2 * b2;
        int val = func(A, B);

        System.out.println(A / val + " " + B / val);

        br.close();
    }

    static int func (int a, int b) {
        if (b == 0) return a;

        return func (b, a % b);
    }
}