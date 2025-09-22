import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = 60_000_000_000L; // max = 20억*30
        while (left <= right) { // log60,000,000,000 / log2
            long mid = (left + right) >> 1;

            long sum = 0;
            for (int i = 0; i < M; i++) {
                sum += (mid - 1) / arr[i] + 1;
            }

            if (sum < N) left = mid + 1;
            else right = mid - 1;
        }

        long targetTime = left - 1;
        int result = N;
        if (targetTime >= 0) {
            int cnt = 0;
            for (int i = M - 1; i >= 0; i--) {
                cnt += targetTime / arr[i] + 1;
            }

            for (int i = M - 1; i >= 0; i--) {
                if (targetTime % arr[i] == 0) {
                    if (cnt == N) {
                        result = i + 1;
                        break;
                    }

                    cnt--;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}