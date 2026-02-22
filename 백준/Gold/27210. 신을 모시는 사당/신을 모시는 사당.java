import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int maxSum = Integer.MIN_VALUE;
        int min = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int d = Integer.parseInt(st.nextToken());
            int val = (d == 1) ? 1 : -1;

            max = Math.max(val, max + val);
            maxSum = Math.max(maxSum, max);

            min = Math.min(val, min + val);
            minSum = Math.min(minSum, min);
        }

        int answer = Math.max(maxSum, Math.abs(minSum));
        System.out.println(answer);

        br.close();
    }
}