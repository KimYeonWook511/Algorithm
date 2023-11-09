import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int min = 1;

        while (min <= max) {
            int sum = 0;

            int avg = (max + min) / 2;

            for (int i = 0; i < N; i++) {
                sum += Math.min(avg, arr[i]);
            }

            if (sum <= M) min = avg + 1;
            else max = avg - 1;
        }   

        System.out.println(max);

        br.close();
    }
}