import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int day = 0;

        for (int i = x; i <= n; i++) {
            int cnt = sum[i] - sum[i - x];

            if (cnt > max) {
                max = cnt;
                day = 1;

            } else if (cnt == max) {
                day++;
            }
        }

        if (max == 0) sb.append("SAD");
        else sb.append(max).append("\n").append(day);

        System.out.println(sb.toString());

        br.close();
    }
}