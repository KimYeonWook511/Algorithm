import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int val = 0;
        for (int i = 1; i < N; i++) {
            val = func(val, arr[i] - arr[i - 1]);
        }

        System.out.println(1 - N + (arr[N - 1] - arr[0]) / val);

        br.close();
    }

    static int func(int a, int b) {
        if (b == 0) return a;

        return func(b, a % b);
    }
}