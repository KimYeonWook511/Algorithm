import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int H[] = new int[N + 1];
        int sum[] = new int[N + 2];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sum[a] += k;
            sum[b + 1] -= k;
        }

        for (int i = 1; i <= N; i++) {
            sum[i + 1] += sum[i];
            H[i] += sum[i];

            sb.append(H[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}