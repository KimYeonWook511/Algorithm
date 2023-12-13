import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int cnt[] = new int[N];

        for (int i = 0; i < M; i++) {
            int box = Integer.parseInt(st.nextToken());

            for (int k = 0; k < N; k++) {
                if (arr[k] >= box) {
                    cnt[k]++;
                    break;
                }
            }
        }

        boolean flag;
        int idx, temp;
        int result = 0;

        while (true) {
            flag = true;
            idx = N - 1;
            temp = N;

            while (idx >= 0) {
                if (cnt[idx] == 0) {
                    idx--;
                    continue;
                }

                flag = false;

                int available = temp - idx;

                if (cnt[idx] < available) {
                    temp -= cnt[idx];
                    M -= cnt[idx];
                    cnt[idx] = 0;

                } else {
                    // cnt[idx] >= available
                    temp -= available;
                    M -= available;
                    cnt[idx] -= available;
                }

                idx--;
            }

            if (flag) break;

            result++;
        }

        System.out.println(M == 0 ? result : -1);

        br.close();
    }
}