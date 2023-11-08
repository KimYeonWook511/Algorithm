import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long max = 0;
        long min = 1;

        int arr[] = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            max = Math.max(max, arr[i]);
        }

        while (min <= max) {           
            long avg = (max + min) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i] / avg;
            }

            if (cnt >= N) {
                min = avg + 1;

            } else {
                max = avg - 1;
            }
        }

        System.out.println(max);

        br.close();
    }
}