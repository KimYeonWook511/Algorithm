import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = 1;
        int max = 1_000_000_000;

        while (min <= max) {
            int mid = (min + max) / 2;

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < M) max = mid - 1;
            else min = mid + 1;
        }

        System.out.println(min - 1);

        br.close();
    }
}