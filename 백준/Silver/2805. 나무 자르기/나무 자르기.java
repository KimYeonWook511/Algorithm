import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        long max = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        long min = 0;
        max--;

        while (min <= max) {
            long sum = 0;

            long avg = (max + min) / 2;

            for (int i = 0; i < N; i++) {
                sum += Math.max(arr[i] - avg, 0);
            }

            if (sum >= M) min = avg + 1;
            else max = avg - 1;
        }   

        System.out.println(max);

        br.close();
    }
}