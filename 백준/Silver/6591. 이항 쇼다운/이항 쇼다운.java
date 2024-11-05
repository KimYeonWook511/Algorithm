import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            if (N == 0 && K == 0) break;

            long result = 1;
            K = N - (K << 1) < 0 ? N - K : K;

            for (long i = 1; i <= K; i++) {
                result *= N;
                result /= i;
                N--;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}