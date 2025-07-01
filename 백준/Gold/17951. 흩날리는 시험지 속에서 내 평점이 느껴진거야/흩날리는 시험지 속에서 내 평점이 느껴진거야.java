import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 2_000_000; // 20 * 100,000
        while (left <= right) {
            int mid = (left + right) >> 1;

            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }

            if (cnt >= K) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);

        br.close();
    }
}