import java.io.*;
import java.util.*;

public class Main {
    static final int END = 1422;
    static final int MAX_DIST = 200;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int max = 0;
            for (int i = 1; i < n; i++) {
                max = Math.max(max, arr[i] - arr[i - 1]);
            }

            sb.append(((max <= MAX_DIST) && (2 * (END - arr[n - 1]) <= MAX_DIST)) ? "POSSIBLE\n" : "IMPOSSIBLE\n");
        }

        System.out.print(sb);

        br.close();
    }
}
