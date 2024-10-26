import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int temp, val;
        boolean flag = false;

        for (int i = L; i <= 100; i++) {
            temp = N - (i * (i + 1) >> 1);

            if (temp % i != 0) continue;

            val = temp / i + 1;

            if (val < 0) continue;

            for (int k = 0; k < i; k++) {
                sb.append(val + k).append(" ");
            }

            flag = true;
            break;
        }

        System.out.println(flag ? sb : -1);

        br.close();
    }
}