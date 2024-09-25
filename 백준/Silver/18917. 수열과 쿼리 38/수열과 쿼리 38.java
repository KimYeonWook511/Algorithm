import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        long sum = 0;
        long xor = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                sum += x;
                xor ^= x;

            } else if (cmd == 2) {
                int x = Integer.parseInt(st.nextToken());
                sum -= x;
                xor ^= x;

            } else if (cmd == 3) {
                sb.append(sum).append("\n");

            } else {
                sb.append(xor).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}