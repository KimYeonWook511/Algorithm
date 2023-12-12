import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        for (int run = 0; run < N; run++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int i = 0; i < M; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            arr[run] = sum;
        }

        Arrays.sort(arr);

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += arr[i] * (N - i);
        }

        System.out.println(result);

        br.close();
    }
}