import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long sum = 0;
        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (cnt == 2) {
                cnt = 0;
                continue;
            }

            sum += arr[i];
            cnt++;
        }

        System.out.println(sum);

        br.close();
    }
}