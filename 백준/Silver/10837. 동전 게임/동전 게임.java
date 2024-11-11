import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (M == N) {
                sb.append("1\n");
                continue;
            }

            if (M > N) {
                sb.append(((M << 1) - N - K > 2) ? "0\n" : "1\n");
                continue;
            }

            sb.append(((N << 1) - M - K > 1) ? "0\n" : "1\n");
        }

        System.out.println(sb);
        
        br.close();
    }
}