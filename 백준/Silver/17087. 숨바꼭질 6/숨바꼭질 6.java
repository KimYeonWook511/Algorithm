import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        int result = arr[0];
        for (int i = 1; i < N; i++) {
            result = gcd(result, arr[i]);
        }

        System.out.println(result);

        br.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}