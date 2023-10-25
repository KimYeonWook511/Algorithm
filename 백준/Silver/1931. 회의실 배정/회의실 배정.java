import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        StringTokenizer st;
        
        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[run][0] = s;
            arr[run][1] = e;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];

            return a[1] - b[1];
        });

        int cnt = 0;
        int end = 0;

        for (int[] t : arr) {
            if (t[0] >= end) {
                cnt++;
                end = t[1];
            }
        }

        System.out.println(cnt);

        br.close();
    }
}