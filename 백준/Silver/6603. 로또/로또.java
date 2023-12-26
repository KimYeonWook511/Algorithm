import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int k, arr[], result[] = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            arr = new int[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            func(0, 0);
            sb.append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int cnt, int idx) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        int max = k - 6 + cnt;

        for (int i = idx; i <= max; i++) {
            result[cnt] = arr[i];
            func(cnt + 1, i + 1);
        }
    }
}