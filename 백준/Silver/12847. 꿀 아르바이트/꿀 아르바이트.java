import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long sum[] = new long[n + 1];
        long max = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < m; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());
        }
        
        for (int i = m; i <= n; i++) {
            sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());

            max = Math.max(max, sum[i] - sum[i - m]);
        }

        System.out.println(max);

        br.close();
    }
}