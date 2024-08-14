import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for (int k = 0; k < i; k++) {
                sum += arr[i] * arr[k];
            }
        }

        System.out.println(sum);

        br.close();
    }
}