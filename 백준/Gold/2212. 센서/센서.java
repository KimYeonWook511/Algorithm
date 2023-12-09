import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int arr2[] = new int[N];

        for (int i = 1; i < N; i++) {
            arr2[i] = arr[i] - arr[i - 1];
        }

        Arrays.sort(arr2);

        int sum = 0;

        for (int i = 1; i <= N - K; i++) {
            sum += arr2[i];
        }

        System.out.println(sum);

        br.close();
    }
}