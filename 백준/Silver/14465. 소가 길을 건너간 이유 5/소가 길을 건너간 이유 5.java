import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean arr[] = new boolean[n + 1];

        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[num] = true;
        }

        int cnt = 0;
        int min = k;

        for (int i = k - 1; i > 0; i--) {
            if (arr[i]) cnt++;
        }

        for (int i = k; i <= n; i++) {
            if (arr[i]) cnt++;
            if (arr[i - k]) cnt--;

            min = Math.min(min, cnt);

            if (min == 0) break;
        }

        System.out.println(min);

        br.close();
    }
}