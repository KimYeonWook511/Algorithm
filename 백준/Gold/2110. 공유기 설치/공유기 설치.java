import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];
        
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                sum += arr[i] - arr[i - 1];

                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }

            if (cnt >= C) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left - 1);

        br.close();
    }
}