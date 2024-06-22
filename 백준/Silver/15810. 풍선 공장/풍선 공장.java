import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }

        long left = 0;
        long right = (long)min * M;
        
        while (left <= right) {
            long mid = (left + right) >> 1;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid / arr[i];
            }

            if (cnt < M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);

        br.close();
    }
}