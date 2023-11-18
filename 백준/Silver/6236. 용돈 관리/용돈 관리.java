import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()); 

            arr[i] = num;
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int sum = mid;

            for (int i = 0; i < N; i++) {
                sum -= arr[i];

                if (sum < 0) {
                    sum = mid - arr[i];
                    cnt++;
                }
            }

            if (cnt <= M) right = mid;
            else left = mid + 1;
        }

        System.out.println(right);

        br.close();
    }
}