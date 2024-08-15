import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        for (int t = 1; t <= P; t++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int M = Integer.parseInt(st.nextToken());

            int a = 1;
            int b = 1;
            int cnt = 0;

            int temp = 0;
            while (true) {
                cnt++;
                temp = (a + b) % M;
                a = b;
                b = temp;

                if (a == 1 && b == 1) break;
            }

            sb.append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}