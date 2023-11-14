import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long sum[] = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }

        sum[0] = Long.MIN_VALUE;

        Arrays.sort(sum);

        long result = 0;

        for (int i = N - K + 1; i <= N; i++) {
            result += sum[i];
        }

        System.out.println(result);

        br.close();
    }
}