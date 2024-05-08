import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int val = arr[r] - arr[l];

            if (val < M) {
                r++;

                if (r == N) break;

            } else if (val > M) {
                min = Math.min(min, val);
                l++;

            } else {
                min = val;
                break;
            }
        }

        System.out.println(min);

        br.close();
    }
}