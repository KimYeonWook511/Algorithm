import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int sum[][] = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            int id = Integer.parseInt(br.readLine()) - 1;

            sum[i][0] = sum[i - 1][0];
            sum[i][1] = sum[i - 1][1];
            sum[i][2] = sum[i - 1][2];

            sum[i][id]++;
        }

        for (int run = 0; run < Q; run++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken()) - 1;
            int endIdx = Integer.parseInt(st.nextToken());

            sb.append(sum[endIdx][0] - sum[startIdx][0]).append(" ")
                .append(sum[endIdx][1] - sum[startIdx][1]).append(" ")
                .append(sum[endIdx][2] - sum[startIdx][2]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}