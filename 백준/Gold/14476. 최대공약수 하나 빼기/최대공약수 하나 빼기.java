import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left[] = new int[N + 1];
        int right[] = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            left[i] = gcd(left[i - 1], arr[i]);
            right[N - i + 1] = gcd(arr[N - i + 1], right[N - i + 2]);
        }

        int maxGcd = -1;
        int k = -1;
        for (int i = 1; i <= N; i++) {
            int val = gcd(left[i - 1], right[i + 1]);
            if (val > maxGcd && arr[i] % val != 0) {
                maxGcd = val;
                k = arr[i];
            }
        }

        if (maxGcd == -1) {
            System.out.println(-1);
        } else {
            System.out.println(maxGcd + " " + k);
        }

        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}