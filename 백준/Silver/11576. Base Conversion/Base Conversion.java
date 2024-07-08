import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int pow = (int)Math.pow(A, m - 1);
        int val = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            val += Integer.parseInt(st.nextToken()) * pow;
            pow /= A;
        }

        int result[] = new int[20];
        int idx = 0;

        while (val > 0) {
            result[idx++] = val % B;
            val /= B;
        }

        for (int i = idx - 1; i >= 0; i--) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}