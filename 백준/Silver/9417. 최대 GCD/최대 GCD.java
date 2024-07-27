import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[100];
        int idx = 0;

        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            idx = 0;

            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for (int i = 1; i < idx; i++) {
                for (int k = 0; k < i; k++) {
                    max = Math.max(max, arr[i] > arr[k] ? gcd(arr[i], arr[k]) : gcd(arr[k], arr[i]));
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}