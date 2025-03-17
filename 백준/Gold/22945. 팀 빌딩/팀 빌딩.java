import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;

        int result = 0;
        while (left < right) {
            int val = right - left - 1;

            if (arr[left] < arr[right]) {
                val *= arr[left];
                left++;

            } else {
                val *= arr[right];
                right--;
            }

            result = Math.max(result, val);
        }

        System.out.println(result);

        br.close();
    }
}