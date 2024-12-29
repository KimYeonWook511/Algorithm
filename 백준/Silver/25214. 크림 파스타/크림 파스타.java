import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());

            if (min > A) min = A;
            else result = Math.max(result, A - min);

            sb.append(result).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}