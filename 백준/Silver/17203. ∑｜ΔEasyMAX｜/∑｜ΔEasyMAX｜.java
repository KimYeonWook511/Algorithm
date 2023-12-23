import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int sum[] = new int[N];

        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            sum[i] = sum[i - 1] + Math.abs(temp - num);
            temp = num;
        }

        for (int run = 0; run < Q; run++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            sb.append(sum[r - 1] - sum[l - 1]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}