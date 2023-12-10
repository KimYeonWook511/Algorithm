import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            arr[i] = h - temp;

            temp = h;
        }

        Arrays.sort(arr);

        int sum = 0;

        for (int i = 1; i <= N - K; i++) {
            sum += arr[i];
        }

        System.out.println(sum);

        br.close();
    }
}