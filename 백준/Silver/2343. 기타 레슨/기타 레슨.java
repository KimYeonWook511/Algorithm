import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        int max = 0;
        int min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
            min = Math.max(min, arr[i]);
        }

        while (min < max) {
            int avg = (min + max) / 2;

            int cnt = 1;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if (sum > avg) {
                    sum = arr[i];
                    cnt++;
                }
            }

            if (cnt <= M) max = avg;
            else min = avg + 1;
        }

        System.out.println(max);

        br.close();
    }
}