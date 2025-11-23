import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 1;
        if (N % 2 == 0) {
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                arr[i] = A - B;
            }

            Arrays.sort(arr);

            answer = Math.abs(arr[N / 2] - arr[N / 2 - 1]) + 1;
        }

        System.out.println(answer);

        br.close();
    }
}