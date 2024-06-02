import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[4_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int val = 2_000_000;

        for (int run = 0; run < N; run++) {
            arr[Integer.parseInt(st.nextToken()) + val]++;    
        }

        int max = val << 1;

        for (int i = 0; i <= max; i++) {
            if (arr[i] == 0) continue;

            for (int k = arr[i]; k > 0; k--) {
                sb.append(i - val).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}