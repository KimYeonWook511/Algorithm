import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int val = M * K;

        st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = N - 1; i >= 0; i--) {
            val -= arr[i];

            if (val <= 0) {
                System.out.println(N - i);
                break;
            }
        }

        if (val > 0) System.out.println("STRESS");

        br.close();
    }
}