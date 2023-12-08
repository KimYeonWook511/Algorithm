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

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                sum += arr[i];

            } else if (arr[i] == 0) {
                if (i % 2 != 0) {
                    for (int k = 0; k < i; k += 2) {
                        sum += arr[k] * arr[k + 1];
                    }

                    i = 0;
                }

            } else if (arr[i] > 1) {
                if (i == 0) {
                    sum += arr[i];

                } else if (arr[i - 1] > 1) {
                    sum += arr[i] * arr[i - 1];
                    i--;

                } else {
                    sum += arr[i];
                }

            } else {
                int end = i;

                if (i % 2 == 0) {
                    sum += arr[i];
                    i--;
                }

                for (int k = 0; k < end; k += 2) {
                    sum += arr[k] * arr[k + 1];
                }

                i = 0;
            }
        }

        System.out.println(sum);

        br.close();
    }
}