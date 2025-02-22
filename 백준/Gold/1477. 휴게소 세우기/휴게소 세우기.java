import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[N + 2];
        arr[N + 1] = L;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = L - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            int sum = 0;
            for (int i = 1; i <= N + 1; i++) {
                sum += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if (sum > M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);

        br.close();
    }
}