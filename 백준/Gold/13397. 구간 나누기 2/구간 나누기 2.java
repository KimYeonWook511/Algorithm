import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) >> 1;

            int cnt = 1;
            int min = arr[0];
            int max = arr[0];
            for (int i = 1; i < N; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if (max - min <= mid) continue;

                cnt++;
                min = arr[i];
                max = arr[i];
            }

            if (cnt > M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);

        br.close();
    }
}