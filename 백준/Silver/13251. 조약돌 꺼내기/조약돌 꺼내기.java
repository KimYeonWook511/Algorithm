import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int arr[] = new int[M];
        int N = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            N += arr[i];
        }

        int K = Integer.parseInt(br.readLine());
        double result = 0;

        for (int i = 0; i < M; i++) {
            if (arr[i] < K) continue;

            double val = 1;
            for (int r = Math.min(K, arr[i] - K) - 1; r >= 0; r--) {
                val *= (arr[i] - r);
                val /= (1 + r);
            }

            result += val;
        }

        double val = 1;
        for (int r = Math.min(K, N - K) - 1; r >= 0; r--) {
            val *= (N - r);
            val /= (1 + r);
        }

        System.out.println(result / val);

        br.close();
    }
}