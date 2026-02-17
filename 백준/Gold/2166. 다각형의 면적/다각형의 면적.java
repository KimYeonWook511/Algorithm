import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long x[] = new long[N];
        long y[] = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            sum += (x[i] * y[next]) - (x[next] * y[i]);
        }

        double area = Math.abs(sum) / 2.0;

        System.out.println(String.format("%.1f", area));

        br.close();
    }
}
